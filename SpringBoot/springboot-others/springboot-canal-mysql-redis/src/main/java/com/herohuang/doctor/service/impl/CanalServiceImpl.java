package com.herohuang.doctor.service.impl;

import java.net.InetSocketAddress;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.herohuang.doctor.dto.Canal;
import com.herohuang.doctor.service.CanalService;
import com.herohuang.doctor.util.PropertyUtil;
import com.herohuang.doctor.util.RedisUtil;

/**
 * Created by herohuang on 26/04/2017.
 */
@Service
public class CanalServiceImpl implements CanalService {
	static Logger logger = LoggerFactory.getLogger(CanalServiceImpl.class);
	@Autowired
	private PropertyUtil propertyUtil;

	@Override
	public void startBinlog() throws Exception {
		CanalConnector connector = CanalConnectors.newSingleConnector(
				new InetSocketAddress(AddressUtils.getHostIp(), 11111),
				"example", "", "");
		int batchSize = 1000;
		int emptyCount = 0;
		try {
			connector.connect();
			connector.subscribe(".*\\..*");
			connector.rollback();
			int totalEmptyCount = 10;
			while (true) {
				Message message = connector.getWithoutAck(batchSize);
				long batchId = message.getId();
				int size = message.getEntries().size();
				if (batchId == -1 || size == 0) {
					try {
						// logger.info("canal thread is running");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				} else {
					printEntry(message.getEntries());
				}
				connector.ack(batchId);
			}
		} finally {
			connector.disconnect();
		}
	}

	private void printEntry(List<CanalEntry.Entry> entrys) {
		for (CanalEntry.Entry entry : entrys) {
			if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN
					|| entry.getEntryType() == EntryType.TRANSACTIONEND) {
				continue;
			}
			RowChange rowChage = null;
			try {
				rowChage = RowChange.parseFrom(entry.getStoreValue());
			} catch (Exception e) {
				throw new RuntimeException(
						"ERROR ## parser of eromanga-event has an error , data:"
								+ entry.toString(), e);
			}
			EventType eventType = rowChage.getEventType();
			if (eventType == EventType.DELETE || eventType == EventType.INSERT
					|| eventType == EventType.UPDATE
					|| eventType == EventType.ALTER) {
				List<Canal> list = propertyUtil.getCacheConfig();
				for (Canal canal : list) {
					if (canal
							.getTableName()
							.toLowerCase()
							.equals(entry.getHeader().getTableName()
									.toLowerCase())) {
						String[] cacheKyes = canal.getCacheKey().split(",");
						for (String cacheKye : cacheKyes) {
							RedisUtil.delKey(cacheKye);
						}
					}
				}
			}
		}
	}
}

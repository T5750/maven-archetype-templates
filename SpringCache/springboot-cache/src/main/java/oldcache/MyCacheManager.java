package oldcache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyCacheManager<T> {
	private Map<String, T> cache = new ConcurrentHashMap<String, T>();

	public T getValue(Object key) {
		return cache.get(key);
	}

	public void addOrUpdateCache(String key, T value) {
		cache.put(key, value);
	}

	public void evictCache(String key) {// 根据 key 来删除缓存中的一条记录
		if (cache.containsKey(key)) {
			cache.remove(key);
		}
	}

	public void evictCache() {// 清空缓存中的所有记录
		cache.clear();
	}
}
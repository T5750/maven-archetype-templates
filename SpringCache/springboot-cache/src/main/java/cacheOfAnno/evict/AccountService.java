package cacheOfAnno.evict;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import cacheOfAnno.Account;

public class AccountService {
	@Cacheable(value = "accountCache") // 使用了一个缓存名叫 accountCache
	public Account getAccountByName(String userName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		// System.out.println("real query account." + userName);
		return getFromDB(userName);
	}

	private Account getFromDB(String acctName) {
		System.out.println("real querying db..." + acctName);
		return new Account(acctName);
	}

	@CacheEvict(value = "accountCache", allEntries = true) // 清空 accountCache 缓存
	public void reload() {
		throw new RuntimeException();
	}

	@CacheEvict(value = "accountCache", allEntries = true, beforeInvocation = true)
	// 清空 accountCache 缓存
	public void reloadOk() {
		throw new RuntimeException();
	}
}

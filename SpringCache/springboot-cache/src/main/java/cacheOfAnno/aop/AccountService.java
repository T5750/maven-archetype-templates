package cacheOfAnno.aop;

import org.springframework.cache.annotation.Cacheable;

import cacheOfAnno.Account;

public class AccountService {
	private Account getFromDB(String acctName) {
		System.out.println("real querying db..." + acctName);
		return new Account(acctName);
	}

	public Account getAccountByName2(String userName) {
		return this.getAccountByName(userName);
	}

	@Cacheable(value = "accountCache") // 使用了一个缓存名叫 accountCache
	public Account getAccountByName(String userName) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		return getFromDB(userName);
	}
}

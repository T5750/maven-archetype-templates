package oldcache;

import cacheOfAnno.Account;

public class MyAccountService {
	private MyCacheManager<Account> cacheManager;

	public MyAccountService() {
		cacheManager = new MyCacheManager<Account>();// 构造一个缓存管理器
	}

	public Account getAccountByName(String acctName) {
		Account result = cacheManager.getValue(acctName);// 首先查询缓存
		if (result != null) {
			System.out.println("get from cache..." + acctName);
			return result;// 如果在缓存中，则直接返回缓存的结果
		}
		result = getFromDB(acctName);// 否则到数据库中查询
		if (result != null) {// 将数据库查询的结果更新到缓存中
			cacheManager.addOrUpdateCache(acctName, result);
		}
		return result;
	}

	public void reload() {
		cacheManager.evictCache();
	}

	private Account getFromDB(String acctName) {
		System.out.println("real querying db..." + acctName);
		return new Account(acctName);
	}
}
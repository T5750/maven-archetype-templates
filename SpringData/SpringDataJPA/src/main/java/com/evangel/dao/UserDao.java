package com.evangel.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evangel.domain.AccountInfo;

/**
 * Author:ZhangJianPing Time:11-9-4,下午8:50
 */
// 第一个为该接口处理的域对象类型，第二个为该域对象的主键类型。
// @RepositoryDefinition(domainClass = AccountInfo.class, idClass = Long.class)
public interface UserDao extends Repository<AccountInfo, Long> {
	public AccountInfo save(AccountInfo accountInfo);

	// @Query("select a from AccountInfo a where a.accountId = ?1")
	public AccountInfo findByAccountId(Long accountId);
	// @Query("from AccountInfo a where a.accountId = :id")
	// public AccountInfo findByAccountId(@Param("id")Long accountId);

	// @Query("select a from AccountInfo a where a.balance > ?1")
	public Page<AccountInfo> findByBalanceGreaterThan(Integer balance,
			Pageable pageable);
	// @Query("from AccountInfo a where a.balance > :balance")
	// public Page<AccountInfo> findByBalanceGreaterThan(
	// @Param("balance")Integer balance,Pageable pageable);

	// TransactionRequiredException: Executing an update/delete query
	@Transactional
	@Modifying
	@Query("update AccountInfo a set a.balance = ?1 where a.balance < ?2")
	public int increaseSalary(int after, int before);
}

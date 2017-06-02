package com.evangel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evangel.dao.UserDao;
import com.evangel.domain.AccountInfo;
import com.evangel.domain.UserInfo;

/**
 * Author:ZhangJianPing Time:11-9-14,下午5:10
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	// private UserDao userDao = new UserDaoImpl();
	@Autowired
	private UserDao userDao;

	@Transactional
	public AccountInfo createNewAccount(String username, String password,
			Integer initBalance) {
		AccountInfo accountInfo = new AccountInfo();
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		accountInfo.setBalance(initBalance);
		accountInfo.setUserInfo(userInfo);
		return userDao.save(accountInfo);
	}

	public AccountInfo findAccountInfoById(Long id) {
		return userDao.findByAccountId(id);
	}

	public List<AccountInfo> findByBalanceGreaterThan(Integer balance,
			Pageable pageable) {
		Page<AccountInfo> accounts = userDao.findByBalanceGreaterThan(balance,
				pageable);
		return accounts.getContent();
	}

	public int increaseSalary(int after, int before) {
		return userDao.increaseSalary(after, before);
	}
}

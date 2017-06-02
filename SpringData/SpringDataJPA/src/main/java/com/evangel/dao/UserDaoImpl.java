//package com.evangel.dao;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import com.evangel.domain.AccountInfo;
//
//public class UserDaoImpl implements UserDao {
//	public AccountInfo save(AccountInfo accountInfo) {
//		EntityManagerFactory emf = Persistence
//				.createEntityManagerFactory("SimplePU");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(accountInfo);
//		em.getTransaction().commit();
//		emf.close();
//		return accountInfo;
//	}
//
//	@Override
//	public AccountInfo findByAccountId(Long accountId) {
//		return null;
//	}
//
//	@Override
//	public Page<AccountInfo> findByBalanceGreaterThan(Integer balance,
//			Pageable pageable) {
//		return null;
//	}
//}
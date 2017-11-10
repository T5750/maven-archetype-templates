package com.evangel.secure;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import io.undertow.security.idm.Account;
import io.undertow.security.idm.Credential;
import io.undertow.security.idm.IdentityManager;
import io.undertow.security.idm.PasswordCredential;

public class CustomIdentityManager implements IdentityManager {
	private final Map<String, char[]> users;

	CustomIdentityManager(final Map<String, char[]> users) {
		this.users = users;
	}

	public Account verify(Account account) {
		return account;
	}

	public Account verify(Credential credential) {
		return null;
	}

	public Account verify(String id, Credential credential) {
		Account account = getAccount(id);
		if (account != null && verifyCredential(account, credential)) {
			return account;
		}
		return null;
	}

	private boolean verifyCredential(Account account, Credential credential) {
		if (credential instanceof PasswordCredential) {
			char[] password = ((PasswordCredential) credential).getPassword();
			char[] expectedPassword = users.get(account.getPrincipal()
					.getName());
			return Arrays.equals(password, expectedPassword);
		}
		return false;
	}

	private Account getAccount(final String id) {
		if (users.containsKey(id)) {
			return new Account() {
				private static final long serialVersionUID = 1L;
				private final Principal principal = () -> id;

				public Principal getPrincipal() {
					return principal;
				}

				public Set<String> getRoles() {
					return Collections.emptySet();
				}
			};
		}
		return null;
	}
}

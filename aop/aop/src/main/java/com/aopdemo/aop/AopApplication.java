package com.aopdemo.aop;

import com.aopdemo.aop.dao.AccountDao;
import com.aopdemo.aop.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao , MembershipDao membershipDao) {
		return args -> {

		//	demoTheBeforeAdvice(accountDao , membershipDao);
			demoTheAfterReturningAdvice(accountDao);


		};
	}

	private void demoTheAfterReturningAdvice(AccountDao accountDao) {

		List<Account> theAccounts = accountDao.findAccounts();

		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice ");

		System.out.println("**************");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	/*
	private void demoTheBeforeAdvice(AccountDao accountDao , MembershipDao membershipDao) {

		Account account = new Account();
		account.setName("Jonathan");
		account.setLevel("Silver");

		accountDao.addAccount(account,true);

		accountDao.doWork();

		accountDao.setName("Chaby");
		accountDao.setServiseCode("U154");

		String name = accountDao.getName();
		String servisCode = accountDao.getServiseCode();

		membershipDao.addSillyMember();

		membershipDao.goToSleep();

	}
	 */

}

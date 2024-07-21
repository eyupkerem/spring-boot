package com.aopdemo.aop;

import com.aopdemo.aop.dao.AccountDao;
import com.aopdemo.aop.dao.MembershipDao;
import com.aopdemo.aop.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDao accountDao ,
											   MembershipDao membershipDao,
											   TrafficFortuneService trafficFortuneService) {
		return args -> {

		//	demoTheBeforeAdvice(accountDao , membershipDao);
		//	demoTheAfterReturningAdvice(accountDao);
		//	demoTheAfterThrowingAdvice(accountDao);
		//	demoTheAfterAdvice(accountDao);
		//	demoTheAroundAdvice(trafficFortuneService);

			demoToAroundAdviceHandleException( trafficFortuneService);


		};
	}

	private void demoToAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n MAin Proram demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		boolean tripWare = true;
		String data = trafficFortuneService.getFortune(tripWare);

		System.out.println("\n My fortune is : " + data);

		System.out.println("Finished");
	}

	/*
	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n MAin Proram demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\n My fortune is : " + data);

		System.out.println("Finished");
	}

	 */

	/*
	private void demoTheAfterAdvice(AccountDao accountDao) {

		List<Account> theAccounts = null;

		try{

			boolean tripWire = false;
			theAccounts =  accountDao.findAccounts(tripWire);
		}
		catch (Exception exception){
			System.out.println("\n Main program : ...caught exception "+ exception);
		}


		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice ");

		System.out.println("**************");

		System.out.println(theAccounts);

		System.out.println("\n");

	}
	 */

	/*

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {

		List<Account> theAccounts = null;

		try{

			boolean tripWire = true;
			theAccounts =  accountDao.findAccounts(tripWire);
		}
		catch (Exception exception){
			System.out.println("\n Main program : ...caught exception "+ exception);
		}


		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice ");

		System.out.println("**************");

		System.out.println(theAccounts);

		System.out.println("\n");
	}
	 */

	/*
	private void demoTheAfterReturningAdvice(AccountDao accountDao) {

		List<Account> theAccounts = accountDao.findAccounts();

		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice ");

		System.out.println("**************");

		System.out.println(theAccounts);

		System.out.println("\n");
	}
	 */

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

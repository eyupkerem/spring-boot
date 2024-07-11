package com.aopdemo.aop;

import com.aopdemo.aop.dao.AccountDao;
import com.aopdemo.aop.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao , MembershipDao membershipDao) {
		return args -> {

			demoTheBeforeAdvice(accountDao , membershipDao);


		};
	}

	private void demoTheBeforeAdvice(AccountDao accountDao , MembershipDao membershipDao) {

		accountDao.addAccount();

		membershipDao.addAccount();

	}

}

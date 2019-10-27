package com.gorniak.allisjava.incomes;

import com.gorniak.allisjava.incomes.dao.Income;
import com.gorniak.allisjava.incomes.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class InComesApplication implements CommandLineRunner {

	@Autowired
	private IService<Income> service;

	public static void main(String[] args) {
		SpringApplication.run(InComesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Income income = new Income();
//		income.setMoney(BigDecimal.valueOf(100));
//		income.setDate(LocalDate.now());
//		income.setDescription("Moj pierwszy wplyw");
//		service.saveOrUpdate(income);

	}
}

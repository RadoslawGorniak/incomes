package com.gorniak.allisjava.incomes.repository;

import com.gorniak.allisjava.incomes.dao.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncomeRepository extends JpaRepository<Income, Long> {

}

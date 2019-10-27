package com.gorniak.allisjava.incomes.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface IService<T> {
    Collection<T> findAll();
    T findById(Long id);
    T saveOrUpdate(T t);
    String deleteById(Long id);
    BigDecimal takeSum();
    Collection<T> findOnlyPlusIncome();
    Collection<T> findOnlyMinusIncome();
    Collection<T> getIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate);
    Collection<T> getOnlyPlusIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate);
    Collection<T> getOnlyMinusIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate);
}

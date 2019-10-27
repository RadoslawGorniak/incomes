package com.gorniak.allisjava.incomes.controller.impl;

import com.gorniak.allisjava.incomes.controller.IController;
import com.gorniak.allisjava.incomes.dao.Income;
import com.gorniak.allisjava.incomes.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeControllerImpl implements IController<Income> {

    private IService<Income> incomeService;



    @Autowired
    public IncomeControllerImpl(IService<Income> incomeService) {
        this.incomeService = incomeService;
    }

    @Override
    public ResponseEntity<Collection<Income>> findAll() {
        return new ResponseEntity<>(incomeService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Income> findById(Long id) {
        return new ResponseEntity<>(incomeService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Income> save(Income income) {
        return new ResponseEntity<>(incomeService.saveOrUpdate(income), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Income> update(Income income) {
        return new ResponseEntity<>(incomeService.saveOrUpdate(income), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(incomeService.deleteById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BigDecimal> takeSum() {
        return new ResponseEntity<>(incomeService.takeSum(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Income>> findOnlyPlusIncome() {
        return new ResponseEntity<>(incomeService.findOnlyPlusIncome(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Income>> findOnlyMinusIncome() {
        return new ResponseEntity<>(incomeService.findOnlyMinusIncome(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Income>> getIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate) {
        return new ResponseEntity<>(incomeService.getIncomeFromTimePeriod(beginDate,endDate), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Income>> getOnlyPlusIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate) {
        return new ResponseEntity<>(incomeService.getOnlyPlusIncomeFromTimePeriod(beginDate,endDate), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<Income>> getOnlyMinusIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate) {
        return new ResponseEntity<>(incomeService.getOnlyMinusIncomeFromTimePeriod(beginDate,endDate), HttpStatus.OK);
    }
}

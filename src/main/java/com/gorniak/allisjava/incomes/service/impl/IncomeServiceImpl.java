package com.gorniak.allisjava.incomes.service.impl;

import com.gorniak.allisjava.incomes.dao.Income;
import com.gorniak.allisjava.incomes.repository.IIncomeRepository;
import com.gorniak.allisjava.incomes.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IService<Income> {

    private IIncomeRepository iIncomeRepository;

    @Autowired
    public IncomeServiceImpl(IIncomeRepository iIncomeRepository) {
        this.iIncomeRepository = iIncomeRepository;
    }

    @Override
    public Collection<Income> findAll() {
        return iIncomeRepository.findAll();
    }

    @Override
    public Income findById(Long id) {
        return iIncomeRepository.findById(id).get();
    }

    @Override
    public Income saveOrUpdate(Income income) {
        return iIncomeRepository.saveAndFlush(income);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            iIncomeRepository.deleteById(id);
            jsonObject.put("message", "Book deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public BigDecimal takeSum(){
        BigDecimal sum = iIncomeRepository.findAll().stream()
                .map(Income::getMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
    }

    @Override
    public Collection<Income> findOnlyPlusIncome() {
        return iIncomeRepository.findAll().stream()
                .filter(checksPlusIncome())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Income> findOnlyMinusIncome() {
        return iIncomeRepository.findAll().stream()
                .filter(checksMinusIncome())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Income> getIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate) {
        return iIncomeRepository.findAll().stream()
                .filter(checkIfTheDateIsBetween(beginDate, endDate))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Income> getOnlyPlusIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate) {
        return iIncomeRepository.findAll().stream()
                .filter(checksPlusIncome())
                .filter(checkIfTheDateIsBetween(beginDate,endDate))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Income> getOnlyMinusIncomeFromTimePeriod(LocalDate beginDate, LocalDate endDate) {
        return iIncomeRepository.findAll().stream()
                .filter(checksMinusIncome())
                .filter(checkIfTheDateIsBetween(beginDate,endDate))
                .collect(Collectors.toList());
    }

    private Predicate<Income> checksMinusIncome() {
        return x -> x.getMoney().compareTo(BigDecimal.ZERO) < 0;
    }

    private Predicate<Income> checksPlusIncome() {
        return x -> x.getMoney().compareTo(BigDecimal.ZERO) > 0;
    }

    private Predicate<Income> checkIfTheDateIsBetween(LocalDate beginDate, LocalDate endDate) {
        return x -> ((x.getDate().isAfter(beginDate)) || (x.getDate().isEqual(beginDate))) && ((x.getDate().isBefore(endDate)) || (x.getDate().isEqual(endDate)));
    }


}

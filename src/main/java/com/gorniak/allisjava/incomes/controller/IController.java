package com.gorniak.allisjava.incomes.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


public interface IController<T> {

    @GetMapping
    ResponseEntity<Collection<T>> findAll();

    @GetMapping("{id}")
    ResponseEntity<T> findById(@PathVariable Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<T> save(@RequestBody T t);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<T> update(@RequestBody T t);

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);

    @RequestMapping("/sum")
    @GetMapping
    ResponseEntity<BigDecimal> takeSum();

    @RequestMapping("/allplus")
    @GetMapping
    ResponseEntity<Collection<T>> findOnlyPlusIncome();

    @RequestMapping("/allminus")
    @GetMapping
    ResponseEntity<Collection<T>> findOnlyMinusIncome();


    @GetMapping("/local-date")
    ResponseEntity<Collection<T>> getIncomeFromTimePeriod(@RequestParam("beginDate")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate, @RequestParam("endDate")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping("/take-plus-income-period")
    ResponseEntity<Collection<T>> getOnlyPlusIncomeFromTimePeriod(@RequestParam("beginDate")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate, @RequestParam("endDate")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping("/take-minus-income-period")
    ResponseEntity<Collection<T>> getOnlyMinusIncomeFromTimePeriod(@RequestParam("beginDate")
                                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate, @RequestParam("endDate")
                                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
}

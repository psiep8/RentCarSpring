package com.example.rentcarspring.service;

import com.example.rentcarspring.dao.FilterDateDAO;
import com.example.rentcarspring.entity.Auto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class FilterDateServiceImpl implements FilterDateService {

    @Autowired
    FilterDateDAO filterDateDAO;

    @Override
    public List<Auto> getDataRange(LocalDate inizio, LocalDate fine) {
        return filterDateDAO.getDataRange(inizio, fine);
    }
}

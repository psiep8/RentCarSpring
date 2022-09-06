package com.example.rentcarspring.service.impl;

import com.example.rentcarspring.dao.FilterDateDAO;
import com.example.rentcarspring.entity.Auto;
import com.example.rentcarspring.service.FilterDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilterDateServiceImpl implements FilterDateService {

    @Autowired
    FilterDateDAO filterDateDAO;

    @Override
    public List<Auto> getDataRange(LocalDate inizio, LocalDate fine) {
        return filterDateDAO.getDataRange(inizio, fine);
    }
}

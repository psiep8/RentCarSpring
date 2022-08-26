package com.example.rentcarspring.service;

import com.example.rentcarspring.dao.FilterDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FilterServiceImpl implements FilterService {
    @Autowired
    FilterDAO filterDAO;

    @Override
    public List<String> getColumn(String campo, String filter) {
        return filterDAO.getColumn(campo, filter);
    }
}

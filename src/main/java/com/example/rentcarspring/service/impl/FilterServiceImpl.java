package com.example.rentcarspring.service.impl;

import com.example.rentcarspring.dao.FilterDAO;
import com.example.rentcarspring.service.FilterService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilterServiceImpl implements FilterService {

    private final FilterDAO filterDAO;

    public FilterServiceImpl(FilterDAO filterDAO) {
        this.filterDAO = filterDAO;
    }

    @Override
    public List<String> getColumn(String campo, String filter) {
        return filterDAO.getColumn(campo, filter);
    }
}

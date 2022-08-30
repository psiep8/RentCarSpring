package com.example.rentcarspring.service;

import com.example.rentcarspring.dao.FilterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilterServiceImpl implements FilterService {
    @Autowired
    FilterDAO filterDAO;

    @Override
    public List<String> getColumn(String campo, String filter) {
        return filterDAO.getColumn(campo, filter);
    }
}

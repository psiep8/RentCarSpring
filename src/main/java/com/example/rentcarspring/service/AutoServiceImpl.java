package com.example.rentcarspring.service;

import com.example.rentcarspring.dao.AutoDAO;
import com.example.rentcarspring.entity.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {
    @Autowired
    AutoDAO autoDAO;

    @Override
    public void updateAuto(Auto auto) {
        autoDAO.updateAuto(auto);
    }

    @Override
    public void deleteAuto(int id) {
        autoDAO.deleteAuto(id);
    }

    @Override
    public List<Auto> getAuto() {
        return autoDAO.getAuto();
    }

    @Override
    public Auto getAuto(int id) {
        return autoDAO.getAuto(id);
    }
}

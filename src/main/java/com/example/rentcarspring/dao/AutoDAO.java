package com.example.rentcarspring.dao;

import com.example.rentcarspring.entity.Auto;

import java.util.List;

public interface AutoDAO {
    void updateAuto(Auto auto);

    void deleteAuto(int id);

    List<Auto> getAllAuto();

    Auto getAuto(int id);
}

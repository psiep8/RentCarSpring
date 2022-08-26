package com.example.rentcarspring.service;

import com.example.rentcarspring.entity.Auto;

import java.util.List;

public interface AutoService {
    void updateAuto(Auto auto);

    void deleteAuto(int id);

    List<Auto> getAuto();

    Auto getAuto(int id);
}

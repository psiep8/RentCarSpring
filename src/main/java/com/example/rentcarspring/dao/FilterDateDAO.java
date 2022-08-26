package com.example.rentcarspring.dao;

import com.example.rentcarspring.entity.Auto;

import java.time.LocalDate;
import java.util.List;

public interface FilterDateDAO {
    List<Auto> getDataRange(LocalDate inizio, LocalDate fine);
}

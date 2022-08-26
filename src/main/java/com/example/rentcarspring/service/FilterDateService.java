package com.example.rentcarspring.service;

import com.example.rentcarspring.entity.Auto;

import java.time.LocalDate;
import java.util.List;

public interface FilterDateService {
    List<Auto> getDataRange(LocalDate inizio, LocalDate fine);

}

package com.example.rentcarspring.dao;

import java.util.List;

public interface FilterDAO {
    List<String> getColumn(String campo, String filter);
}

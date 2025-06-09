package com.nhom2.project_capybra_system.repository;

import java.util.List;

public interface IRepository <T>{
    List<T> findAll();
    T findById(int id);
}


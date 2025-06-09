package com.nhom2.project_capybra_system.service;

import java.util.List;

public interface IService <T>{
    List<T> findAll();
    boolean delete( int id);

    T findById(int id);
}

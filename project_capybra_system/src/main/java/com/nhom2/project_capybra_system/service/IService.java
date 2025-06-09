package com.nhom2.project_capybra_system.service;

import java.util.List;

public interface IService <T>{
    List<T> findAll();
    T findById(Integer id);
    boolean delete( int id);

}

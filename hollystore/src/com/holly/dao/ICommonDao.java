package com.holly.dao;

import java.util.List;

public interface ICommonDao<T> {
    void save(Object entity);
    void update(Object entity);
    void delete(Object entity);
    T findByName(String name);
    List<T> findByPage(String start,String number,String hql);
    
}

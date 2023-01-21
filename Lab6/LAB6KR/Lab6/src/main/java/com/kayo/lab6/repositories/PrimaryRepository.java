package com.kayo.lab6.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimaryRepository<T> {
    public List<T> getAll();
    public T getById(Long id);
    public void add(T input);
    public void deleteById(Long id);
}

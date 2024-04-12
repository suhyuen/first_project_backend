package com.example.community1.services;

import com.example.community1.mappers.CategoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
    @Autowired
    CategoriesMapper categoriesMapper;

    public CategoriesService() {
    }
}


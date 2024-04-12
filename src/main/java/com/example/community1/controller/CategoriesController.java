package com.example.community1.controller;

import com.example.community1.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    public CategoriesController() {
    }
}

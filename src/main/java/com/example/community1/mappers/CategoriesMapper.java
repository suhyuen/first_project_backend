package com.example.community1.mappers;

import com.example.community1.dtos.CategoriesDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoriesMapper {
    void insertCategories(CategoriesDto var1);
}

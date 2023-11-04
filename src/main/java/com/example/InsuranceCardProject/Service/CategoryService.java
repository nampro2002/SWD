package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.dto.RequestCategoryDTO;
import java.util.List;

public interface CategoryService {

    Category addNewCategory(RequestCategoryDTO requestCategoryDTO);

    List<Category> getAllCategory();

    Category updateCategory(Integer id, RequestCategoryDTO requestCategoryDTO);

    void deleteCategory(Integer id);
}

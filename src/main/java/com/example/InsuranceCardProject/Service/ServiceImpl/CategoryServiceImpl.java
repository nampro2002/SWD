package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Repository.CategoryRepository;
import com.example.InsuranceCardProject.Service.CategoryService;
import com.example.InsuranceCardProject.dto.RequestCategoryDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Override
    public Category addNewCategory(RequestCategoryDTO requestCategoryDTO) {
        Category category = new Category();
        category.setCategoryName(requestCategoryDTO.getCategoryName());
        category.setDescription(requestCategoryDTO.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Integer id, RequestCategoryDTO requestCategoryDTO) {
        Category category = categoryRepository.findById(id).get();
        category.setCategoryName(requestCategoryDTO.getCategoryName());
        category.setDescription((requestCategoryDTO.getDescription()));
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }
}

package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Entity.Category;
import com.example.InsuranceCardProject.Service.CategoryService;
import com.example.InsuranceCardProject.Service.UserService;
import com.example.InsuranceCardProject.dto.RequestCategoryDTO;
import com.example.InsuranceCardProject.dto.RequestUserDTO;
import com.example.InsuranceCardProject.dto.UpdateUserDTO;
import com.example.InsuranceCardProject.dto.UserResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody RequestCategoryDTO requestCategoryDTO) {
        System.out.println("add");
        return categoryService.addNewCategory(requestCategoryDTO);
    }
    @GetMapping("/getCategory")
    public List<Category> geCategory() {
        System.out.println("get");
        return categoryService.getAllCategory();
    }
    @PutMapping("/category/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody RequestCategoryDTO RequestCategoryDTO) {
        System.out.println("update");
        return categoryService.updateCategory(id, RequestCategoryDTO);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        System.out.println("delete");
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("delete ok");
    }
}

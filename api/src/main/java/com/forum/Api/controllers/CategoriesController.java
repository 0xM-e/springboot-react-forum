package com.forum.Api.controllers;

import com.forum.Api.business.abstracts.CategoryService;
import com.forum.Api.business.responses.ResponseType;
import com.forum.Api.business.responses.ResponseWrapper;
import com.forum.Api.common.ResponseMessage;
import com.forum.Api.entities.concretes.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseWrapper<List<Category>>> getAll(){
        List<Category> categories = this.categoryService.getAll();
        return ResponseMessage.generateResponseMessage(ResponseType.SUCCESS, categories, HttpStatus.OK);
    }
}

package com.forum.Api.business.abstracts;

import com.forum.Api.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
}
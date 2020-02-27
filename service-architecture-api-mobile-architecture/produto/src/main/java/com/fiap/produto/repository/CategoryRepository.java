package com.fiap.produto.repository;

import com.fiap.produto.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findByName(String name);
}

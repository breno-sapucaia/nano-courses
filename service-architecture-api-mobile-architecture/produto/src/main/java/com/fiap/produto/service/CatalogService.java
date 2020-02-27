package com.fiap.produto.service;

import com.fiap.produto.domain.Category;
import com.fiap.produto.domain.Product;
import com.fiap.produto.repository.CategoryRepository;
import com.fiap.produto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.util.resources.cldr.teo.CalendarData_teo_KE;

@Service
public class CatalogService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public CatalogService(final ProductRepository productRepository,
                          final CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Product add(final String name,final String description) {
    return productRepository.save(new Product.Builder()
                                        .name(name)
                                        .description(description)
                                        .category(getDefaultCategory())
                                    .build());
    }

    public Category getDefaultCategory(){
        final String name = "Padrão";
        final Category found = categoryRepository.findByName(name);

        if (found != null){
            return found;
        }

        return new Category.Builder()
                    .name(name)
                    .description("Padrão")
                    .build();
    }
}

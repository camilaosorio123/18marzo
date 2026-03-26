package dev.cami.ticket.controller;

import dev.cami.ticket.model.Category;
import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.repository.CategoryRepository;
import dev.cami.ticket.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
    private CategoryService service;
    private final CategoryRepository repository;

    public CategoryController(CategoryService service, CategoryRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
        public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = service.getCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        boolean exists = repository.existsByName(category.getName());
        if (exists) {
            return null;
        }
        Category createdCategory = service.create(category);
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.create(category))
                ;
    }
}

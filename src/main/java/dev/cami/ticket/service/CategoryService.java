package dev.cami.ticket.service;

import dev.cami.ticket.model.Category;
import dev.cami.ticket.model.Ticket;
import dev.cami.ticket.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getCategories() {
        return repository.getAll();
    }

    public Category create(Category category) {
        boolean exists = this.repository.existsByName(category.getName());
        if (exists) {
            return null;
        }
        return repository.save(category);
    }
}

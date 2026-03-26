package dev.cami.ticket.repository;
import dev.cami.ticket.model.Category;
import dev.cami.ticket.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();
    private Long currentId = 3L;

    public CategoryRepository() {
        categories = new ArrayList<>();
        categories.add(new Category(1L,"Bug", "Problema o error que afecta el funcionamiento esperado"));
        categories.add(new Category(2L, "Feature","Nueva funcionalidad solicitada por el usuario" ));
    }

    public List<Category> getAll() {
        return categories;
    }

    public Category save(Category category) {
        category.setId(currentId++);

        categories.add(category);
        return category;
    }

    public boolean existsByName(String aName) {
        for (Category category : categories) {
            if (category.getName().equals(aName)) {
                return true;
            }

        }
        return false;
    }

}
package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByCategoryNameLike(String categoryName);

}
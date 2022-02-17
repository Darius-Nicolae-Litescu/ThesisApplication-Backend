package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findByIdIn(Collection<Long> ids);

    List<Category> findByCategoryNameLike(String categoryName);

}
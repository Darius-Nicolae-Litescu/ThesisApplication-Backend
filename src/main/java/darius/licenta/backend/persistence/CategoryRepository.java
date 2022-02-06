package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findByIdIn(Collection<Long> ids);

    List<Category> findByCategoryNameLike(String categoryName);

}
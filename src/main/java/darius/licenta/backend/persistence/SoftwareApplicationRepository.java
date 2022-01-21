package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.SoftwareApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SoftwareApplicationRepository extends JpaRepository<SoftwareApplication, Long> {
    List<SoftwareApplication> findByNameIgnoreCase(String name);

    List<SoftwareApplication> findByDescriptionIsLikeIgnoreCase(String description);

    @Override
    Optional<SoftwareApplication> findById(Long softwareApplicationId);

}
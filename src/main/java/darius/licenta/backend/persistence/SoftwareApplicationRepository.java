package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.SoftwareApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoftwareApplicationRepository extends JpaRepository<SoftwareApplication, Long> {
    Optional<SoftwareApplication> findByNameIgnoreCase(String name);

    Optional<SoftwareApplication> findByDescriptionIsLikeIgnoreCase(String description);

    @Override
    Optional<SoftwareApplication> findById(Long softwareApplicationId);

}
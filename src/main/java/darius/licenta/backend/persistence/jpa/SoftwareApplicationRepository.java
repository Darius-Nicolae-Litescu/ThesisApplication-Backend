package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.SoftwareApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface SoftwareApplicationRepository extends JpaRepository<SoftwareApplication, Long>, JpaSpecificationExecutor<SoftwareApplication> {
    List<SoftwareApplication> findByNameIgnoreCase(String name);

    List<SoftwareApplication> findByDescriptionIsLikeIgnoreCase(String description);

    @Override
    Optional<SoftwareApplication> findById(Long softwareApplicationId);

}
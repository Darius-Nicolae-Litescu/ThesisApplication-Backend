package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.SoftwareApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareApplicationRepository extends JpaRepository<SoftwareApplication, Long> {
}
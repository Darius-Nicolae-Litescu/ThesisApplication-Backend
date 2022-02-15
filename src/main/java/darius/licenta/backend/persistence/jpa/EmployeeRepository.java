package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
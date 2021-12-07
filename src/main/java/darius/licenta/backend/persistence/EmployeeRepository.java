package darius.licenta.backend.persistence;

import darius.licenta.backend.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
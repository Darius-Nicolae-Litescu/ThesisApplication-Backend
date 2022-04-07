package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUser_Username(String username);
    Optional<Employee> findByUser_Id(Long id);


}
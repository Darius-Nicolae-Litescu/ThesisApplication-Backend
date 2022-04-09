package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.dto.normal.user.UserBasicInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Long deleteByUsername(String username);

    @Query("select new darius.licenta.backend.dto.normal.user.UserBasicInfoDto(u.id, u.username) from User u")
    List<UserBasicInfoDto> getAllUsersBasicInfo();
}
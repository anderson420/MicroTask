package test.core.microuser.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.core.microuser.persistance.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}

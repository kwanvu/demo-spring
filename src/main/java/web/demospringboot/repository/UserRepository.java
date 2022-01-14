package web.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.demospringboot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUser(String user);
}

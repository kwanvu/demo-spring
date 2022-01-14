package web.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.demospringboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneByCode(String code);
}

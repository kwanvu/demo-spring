package web.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.demospringboot.entity.BookEntity;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    BookEntity findOneById(Long id);
    BookEntity findOneByName(String name);
    void deleteById(Long id);
}

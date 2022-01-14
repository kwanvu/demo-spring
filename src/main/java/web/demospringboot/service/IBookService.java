package web.demospringboot.service;

import org.springframework.data.domain.Pageable;
import web.demospringboot.dto.BookDTO;

import java.util.List;

public interface IBookService {
    BookDTO save(BookDTO bookDTO);
    BookDTO findOneById(Long id);
    void delete(Long[] ids);
    List<BookDTO> findAll(Pageable pageable);
    List<BookDTO> findAll();
    int totalItem();
}

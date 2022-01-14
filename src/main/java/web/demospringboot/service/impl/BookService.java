package web.demospringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.demospringboot.converter.BookConverter;
import web.demospringboot.dto.BookDTO;
import web.demospringboot.entity.BookEntity;
import web.demospringboot.entity.CategoryEntity;
import web.demospringboot.repository.BookRepository;
import web.demospringboot.repository.CategoryRepository;
import web.demospringboot.service.IBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        if(bookDTO.getId()!=null){
            BookEntity oldBookEntity = bookRepository.findOneById(bookDTO.getId());
            bookEntity = bookConverter.toEntity(bookDTO, oldBookEntity);
        }else {
            bookEntity = bookConverter.toEntity(bookDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(bookDTO.getCategoryCode());
        bookEntity.setCategory(categoryEntity);
        bookEntity = bookRepository.save(bookEntity);
        return bookConverter.toDTO(bookEntity);
    }

    @Override
    public BookDTO findOneById(Long id) {
        BookEntity entity = bookRepository.findOneById(id);
        BookDTO result = bookConverter.toDTO(entity);
        return result;
    }

    @Override
    public void delete(Long[] ids) {
        for(long id: ids){
            bookRepository.deleteById(id);
        }
    }

    @Override
    public List<BookDTO> findAll(Pageable pageable) {
        List<BookDTO> result = new ArrayList<>();
        List<BookEntity> entities = bookRepository.findAll(pageable).getContent();
        for(BookEntity entity:entities){
            BookDTO bookDTO = bookConverter.toDTO(entity);
            result.add(bookDTO);
        }
        return result;
    }

    @Override
    public List<BookDTO> findAll() {
        List<BookDTO> result = new ArrayList<>();
        List<BookEntity> entities = bookRepository.findAll();
        for(BookEntity entity:entities){
            BookDTO bookDTO = bookConverter.toDTO(entity);
            result.add(bookDTO);
        }
        return result;
    }

    @Override
    public int totalItem() {
        return (int)bookRepository.count();
    }

}

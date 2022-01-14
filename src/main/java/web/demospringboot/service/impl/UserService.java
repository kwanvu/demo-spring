package web.demospringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import web.demospringboot.converter.UserConverter;
import web.demospringboot.dto.UserDTO;
import web.demospringboot.entity.BookEntity;
import web.demospringboot.entity.UserEntity;
import web.demospringboot.repository.BookRepository;
import web.demospringboot.repository.UserRepository;
import web.demospringboot.service.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity = userConverter.toEntity(userDTO);
        List<BookEntity> books = new ArrayList<>();
        for(String bookName: userDTO.getBookNames()){
            BookEntity book = bookRepository.findOneByName(bookName);
            books.add(book);
        }
        userEntity.setBooks(books);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }
}

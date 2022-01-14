package web.demospringboot.converter;

import org.springframework.stereotype.Component;
import web.demospringboot.dto.BookDTO;
import web.demospringboot.entity.BookEntity;

@Component
public class BookConverter {

    public BookEntity toEntity(BookDTO dto){
        BookEntity entity = new BookEntity();
        entity.setName(dto.getName());
        entity.setAuthor(dto.getAuthor());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        return entity;
    }

    public BookDTO toDTO(BookEntity entity){
        BookDTO dto = new BookDTO();
        if(entity.getId()!=null){
            dto.setId(entity.getId());
        }
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setPrice(entity.getPrice());
        dto.setImgUrl(entity.getImgUrl());
        dto.setCategoryCode(entity.getCategory().getCode());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public BookEntity toEntity(BookDTO dto, BookEntity entity){
        entity.setName(dto.getName());
        entity.setAuthor(dto.getAuthor());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
        return entity;
    }

}

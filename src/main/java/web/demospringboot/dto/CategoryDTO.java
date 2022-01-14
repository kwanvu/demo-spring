package web.demospringboot.dto;

import web.demospringboot.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends BaseDTO<CategoryDTO>{

    private String name;

    private String code;

    private List<BookEntity> bookNames = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BookEntity> getBookNames() {
        return bookNames;
    }

    public void setBookNames(List<BookEntity> bookNames) {
        this.bookNames = bookNames;
    }
}

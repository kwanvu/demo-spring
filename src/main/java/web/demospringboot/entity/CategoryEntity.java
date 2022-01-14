package web.demospringboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

    @Column
    private String name;

    @Column
    private String code;

    @OneToMany(mappedBy = "category")
    private List<BookEntity> books = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(String name, String code, List<BookEntity> books) {
        this.name = name;
        this.code = code;
        this.books = books;
    }

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

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}

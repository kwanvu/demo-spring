package web.demospringboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private Float price;

    @Column
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(mappedBy = "books")
    private List<UserEntity> users = new ArrayList<>();

    public BookEntity() {
    }

    public BookEntity(String name, String author, Float price, String imgUrl, CategoryEntity category, List<UserEntity> users) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}

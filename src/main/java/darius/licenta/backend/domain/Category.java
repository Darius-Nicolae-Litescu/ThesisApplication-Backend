package darius.licenta.backend.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = Category.TABLE_NAME)
public class Category {
    public static final String TABLE_NAME = "category";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "story_id", nullable = true, insertable = false, updatable = false)
    private Story story;

    @Column(name = "category_picture", nullable = true)
    @Lob
    private Blob categoryPicture;

    public Category(Long id, String categoryName, Blob categoryPicture) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryPicture = categoryPicture;
    }

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Blob getCategoryPicture() {
        return categoryPicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void setCategoryPicture(Blob categoryPicture) {
        this.categoryPicture = categoryPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}

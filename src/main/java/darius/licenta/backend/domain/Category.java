package darius.licenta.backend.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Category.TABLE_NAME)
public class Category {
    public static final String TABLE_NAME = "category";

    @Id
    @GeneratedValue()
    private long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToOne(mappedBy = "category")
    private Story story;

    public Category(long id, String categoryName, Story story) {
        this.id = id;
        this.categoryName = categoryName;
        this.story = story;
    }

    public Category() {
    }

    public long getId() {
        return this.id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Story getStory() {
        return this.story;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Category)) return false;
        final Category other = (Category) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$categoryName = this.getCategoryName();
        final Object other$categoryName = other.getCategoryName();
        if (!Objects.equals(this$categoryName, other$categoryName))
            return false;
        final Object this$story = this.getStory();
        final Object other$story = other.getStory();
        if (!Objects.equals(this$story, other$story)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $categoryName = this.getCategoryName();
        result = result * PRIME + ($categoryName == null ? 43 : $categoryName.hashCode());
        final Object $story = this.getStory();
        result = result * PRIME + ($story == null ? 43 : $story.hashCode());
        return result;
    }

    public String toString() {
        return "Category(id=" + this.getId() + ", categoryName=" + this.getCategoryName() + ", story=" + this.getStory() + ")";
    }
}

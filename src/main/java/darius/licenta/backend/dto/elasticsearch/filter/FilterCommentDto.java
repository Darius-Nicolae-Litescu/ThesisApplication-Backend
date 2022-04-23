package darius.licenta.backend.dto.elasticsearch.filter;

import java.util.Objects;

public class FilterCommentDto {
    private final String content;

    public FilterCommentDto(String content) {
        this.content = content;
    }


    public String getContent() {
        return this.content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterCommentDto that = (FilterCommentDto) o;

        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FilterCommentDto{" +
                "content='" + content + '\'' +
                '}';
    }
}

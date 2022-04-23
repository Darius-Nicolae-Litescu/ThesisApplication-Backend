package darius.licenta.backend.dto.normal.board.response.fulldetails;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CardDto implements Serializable {
    private final Long id;
    private final BigDecimal rank;
    private final StoryDto story;

    public CardDto(Long id, BigDecimal rank, StoryDto story) {
        this.id = id;
        this.rank = rank;
        this.story = story;
    }


    public Long getId() {
        return this.id;
    }

    public BigDecimal getRank() {
        return this.rank;
    }

    public StoryDto getStory() {
        return this.story;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardDto cardDto = (CardDto) o;

        if (!Objects.equals(id, cardDto.id)) return false;
        if (!Objects.equals(rank, cardDto.rank)) return false;
        return Objects.equals(story, cardDto.story);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (story != null ? story.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "id=" + id +
                ", rank=" + rank +
                ", story=" + story +
                '}';
    }
}

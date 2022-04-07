package darius.licenta.backend.service.statistics;

public class StoryUserCommentsAggregationResult {
    private final Long storyId;
    private final Long storyCommentsCount;
    private final String username;

    public StoryUserCommentsAggregationResult(Long storyId, Long storyCommentsCount, String username) {
        this.storyId = storyId;
        this.storyCommentsCount = storyCommentsCount;
        this.username = username;
    }

    public Long getStoryId() {
        return storyId;
    }

    public Long getStoryCommentsCount() {
        return storyCommentsCount;
    }

    public String getUsername() {
        return username;
    }
}

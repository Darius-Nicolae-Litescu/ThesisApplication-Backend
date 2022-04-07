package darius.licenta.backend.service.statistics;

public class StoryTaskUserCommentsAggregationResult {
    private final Long storyTaskId;
    private final Long storyTaskCommentsCount;
    private final String username;

    public StoryTaskUserCommentsAggregationResult(Long storyTaskId, Long storyTaskCommentsCount, String username) {
        this.storyTaskId = storyTaskId;
        this.storyTaskCommentsCount = storyTaskCommentsCount;
        this.username = username;
    }

    public Long getStoryTaskId() {
        return storyTaskId;
    }

    public Long getStoryTaskCommentsCount() {
        return storyTaskCommentsCount;
    }

    public String getUsername() {
        return username;
    }
}

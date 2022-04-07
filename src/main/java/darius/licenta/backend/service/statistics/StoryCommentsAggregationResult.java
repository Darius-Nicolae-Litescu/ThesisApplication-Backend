package darius.licenta.backend.service.statistics;

public class StoryCommentsAggregationResult {

    private final Long storyId;
    private final Long completedCount;

    public StoryCommentsAggregationResult(Long storyId, Long completedCount) {
        this.storyId = storyId == null ? 0 : storyId;
        this.completedCount = completedCount == null ? 0 : completedCount;
    }

    public Long getStoryId() {
        return storyId;
    }

    public Long getCompletedCount() {
        return completedCount;
    }
}
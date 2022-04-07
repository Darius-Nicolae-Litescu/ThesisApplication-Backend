package darius.licenta.backend.service.statistics;

public class StoryStatusAggregationResult {

    private final Long storyCount;
    private final Long completedCount;

    public StoryStatusAggregationResult(Long storyCount, Long completedCount) {
        this.storyCount = storyCount == null ? 0 : storyCount;
        this.completedCount = completedCount == null ? 0 : completedCount;
    }

    public Long getStoryCount() {
        return storyCount;
    }

    public Long getCompletedCount() {
        return completedCount;
    }
}
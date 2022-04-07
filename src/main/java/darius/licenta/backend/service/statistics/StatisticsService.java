package darius.licenta.backend.service.statistics;

import darius.licenta.backend.payload.response.ApiResponse;

import java.util.List;
import java.util.Map;

public interface StatisticsService {

    ApiResponse<StoryStatusAggregationResult> countFinishedStoriesAfterDate(Integer numberOfMonths);
    ApiResponse<List<StoryUserCommentsAggregationResult>> countStoryUserComments();
    ApiResponse<List<StoryTaskUserCommentsAggregationResult>> countStoryTaskUserComments();
    ApiResponse<List<StoryCommentsAggregationResult>> countStoryComments();
}

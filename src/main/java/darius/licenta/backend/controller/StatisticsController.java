package darius.licenta.backend.controller;

import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.service.statistics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin(origins = "http://localhost:3000")
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/stories/finished/before/{numberOfMonths}")
    public ApiResponse<StoryStatusAggregationResult> countFinishedStoriesAfterDate(@PathVariable Integer numberOfMonths) {
        return statisticsService.countFinishedStoriesAfterDate(numberOfMonths);
    }

    @GetMapping("/stories/user/comments")
    public ApiResponse<List<StoryUserCommentsAggregationResult>> countUserStoryComments() {
        return statisticsService.countStoryUserComments();
    }

    @GetMapping("/stories/tasks/user/comments")
    public ApiResponse<List<StoryTaskUserCommentsAggregationResult>> countUserStoryTaskComments() {
        return statisticsService.countStoryTaskUserComments();
    }

    @GetMapping("/stories/comments")
    public ApiResponse<List<StoryCommentsAggregationResult>> countStoryComments() {
        return statisticsService.countStoryComments();
    }
}

package darius.licenta.backend.service.statistics;


import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.jpa.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final StoryRepository storyRepository;

    @Autowired
    public StatisticsServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public ApiResponse<StoryStatusAggregationResult> countFinishedStoriesAfterDate(Integer numberOfMonths) {
        Date dateMinusNumberOfMonths = Date.from(LocalDate.now().minusMonths(numberOfMonths).atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateMinusNumberOfMonths.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        return new ApiResponse<>(storyRepository.countFinishedStoriesAfterDate(sqlDate), HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<StoryUserCommentsAggregationResult>> countStoryUserComments() {
        return new ApiResponse<>(storyRepository.countStoryUserComments(), HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<StoryTaskUserCommentsAggregationResult>> countStoryTaskUserComments() {
        return new ApiResponse<>(storyRepository.countStoryTaskUserComments(), HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<StoryCommentsAggregationResult>> countStoryComments() {
        return new ApiResponse<>(storyRepository.countStoryComments(), HttpStatus.OK);
    }
}

package darius.licenta.backend.dto.elasticsearch;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public class ElasticSearchResultQuery implements Serializable {

    private Float timeTook;
    private Integer numberOfResults;

    @JsonValue
    @JsonRawValue
    private String elements;

    public ElasticSearchResultQuery() {
    }

    public ElasticSearchResultQuery(Float timeTook, Integer numberOfResults, String elements) {
        this.timeTook = timeTook;
        this.numberOfResults = numberOfResults;
        this.elements = elements;
    }

    public Float getTimeTook() {
        return timeTook;
    }

    public void setTimeTook(Float timeTook) {
        this.timeTook = timeTook;
    }

    public Integer getNumberOfResults() {
        return numberOfResults;
    }

    public void setNumberOfResults(Integer numberOfResults) {
        this.numberOfResults = numberOfResults;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

}
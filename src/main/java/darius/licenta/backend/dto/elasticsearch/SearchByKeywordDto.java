package darius.licenta.backend.dto.elasticsearch;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SearchByKeywordDto {
    List<String> collections;
    String term;
    List<String> fields;
    String from;
    String size;

    public SearchByKeywordDto()
    {

    }

    public SearchByKeywordDto(List<String> collections, String term, List<String> fields, String from, String size) {
        this.collections = collections;
        this.term = term;
        this.fields = fields;
        this.from = from;
        this.size = size;
    }

    public List<String> getCollections() {
        return collections;
    }

    public void setCollections(List<String> collections) {
        this.collections = collections;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

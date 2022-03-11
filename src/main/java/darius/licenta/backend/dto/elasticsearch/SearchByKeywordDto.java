package darius.licenta.backend.dto.elasticsearch;

import java.util.List;
import java.util.Optional;

public class SearchByKeywordDto {
    Optional<List<String>> collections;
    String term;
    Optional<List<String>> fields;
    Optional<List<String>> returnFields;
    String from;
    String size;

    public SearchByKeywordDto() {

    }

    public SearchByKeywordDto(List<String> collections, String term, List<String> fields, List<String> returnFields, String from, String size) {
        this.collections = Optional.of(collections);
        this.term = term;
        this.fields = Optional.of(fields);
        this.returnFields = Optional.of(returnFields);
        this.from = from;
        this.size = size;
    }

    public Optional<List<String>> getReturnFields() {
        return returnFields;
    }

    public Optional<List<String>> getCollections() {
        return collections;
    }

    public void setCollections(List<String> collections) {
        this.collections = Optional.of(collections);
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Optional<List<String>> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = Optional.of(fields);
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

    public void setReturnFields(List<String> returnFields) {
        this.returnFields = Optional.of(returnFields);
    }
}

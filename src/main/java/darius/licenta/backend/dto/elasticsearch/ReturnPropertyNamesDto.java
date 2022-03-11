package darius.licenta.backend.dto.elasticsearch;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class ReturnPropertyNamesDto {
    Map<String,List<String>> propertyNamesForCollections;

    public ReturnPropertyNamesDto() {
    }

    public ReturnPropertyNamesDto( Map<String,List<String>> propertyNamesForCollections) {
        this.propertyNamesForCollections = propertyNamesForCollections;
    }

    public  Map<String,List<String>> getPropertyNamesForCollections() {
        return propertyNamesForCollections;
    }

    public void setPropertyNamesForCollections(Map<String,List<String>> propertyNamesForCollections) {
        this.propertyNamesForCollections = propertyNamesForCollections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReturnPropertyNamesDto that = (ReturnPropertyNamesDto) o;

        return Objects.equals(propertyNamesForCollections, that.propertyNamesForCollections);
    }

    @Override
    public int hashCode() {
        return propertyNamesForCollections != null ? propertyNamesForCollections.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ReturnPropertyNamesDto{" +
                "propertyNamesForCollections=" + propertyNamesForCollections +
                '}';
    }
}

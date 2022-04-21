package darius.licenta.backend.dto.elasticsearch.filter;

import java.util.Objects;

public class FilterSoftwareApplicationDto {
    private final String name;
    private final String description;

    public FilterSoftwareApplicationDto(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterSoftwareApplicationDto that = (FilterSoftwareApplicationDto) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilterSoftwareApplicationDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

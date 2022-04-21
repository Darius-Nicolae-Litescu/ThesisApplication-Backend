package darius.licenta.backend.dto.elasticsearch.filter;

import java.util.Objects;

public class FilterByMultipleFieldsDto {
    FilterStoryDto filterStoryDto;
    FilterStoryTaskDto filterStoryTaskDto;
    FilterSoftwareApplicationDto filterSoftwareApplicationDto;
    FilterCommentDto filterCommentDto;
    FilterUserDto filterUserDto;
    int startFromResult;
    int pageSize;

    public FilterByMultipleFieldsDto() {
    }


    public FilterStoryDto getFilterStoryDto() {
        return this.filterStoryDto;
    }

    public void setFilterStoryDto(FilterStoryDto filterStoryDto) {
        this.filterStoryDto = filterStoryDto;
    }

    public FilterStoryTaskDto getFilterStoryTaskDto() {
        return this.filterStoryTaskDto;
    }

    public void setFilterStoryTaskDto(FilterStoryTaskDto filterStoryTaskDto) {
        this.filterStoryTaskDto = filterStoryTaskDto;
    }

    public FilterSoftwareApplicationDto getFilterSoftwareApplicationDto() {
        return this.filterSoftwareApplicationDto;
    }

    public void setFilterSoftwareApplicationDto(FilterSoftwareApplicationDto filterSoftwareApplicationDto) {
        this.filterSoftwareApplicationDto = filterSoftwareApplicationDto;
    }

    public FilterCommentDto getFilterCommentDto() {
        return this.filterCommentDto;
    }

    public void setFilterCommentDto(FilterCommentDto filterCommentDto) {
        this.filterCommentDto = filterCommentDto;
    }

    public FilterUserDto getFilterUserDto() {
        return this.filterUserDto;
    }

    public void setFilterUserDto(FilterUserDto filterUserDto) {
        this.filterUserDto = filterUserDto;
    }

    public int getStartFromResult() {
        return this.startFromResult;
    }

    public void setStartFromResult(int startFromResult) {
        this.startFromResult = startFromResult;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterByMultipleFieldsDto that = (FilterByMultipleFieldsDto) o;

        if (startFromResult != that.startFromResult) return false;
        if (pageSize != that.pageSize) return false;
        if (!Objects.equals(filterStoryDto, that.filterStoryDto))
            return false;
        if (!Objects.equals(filterStoryTaskDto, that.filterStoryTaskDto))
            return false;
        if (!Objects.equals(filterSoftwareApplicationDto, that.filterSoftwareApplicationDto))
            return false;
        if (!Objects.equals(filterCommentDto, that.filterCommentDto))
            return false;
        return Objects.equals(filterUserDto, that.filterUserDto);
    }

    @Override
    public int hashCode() {
        int result = filterStoryDto != null ? filterStoryDto.hashCode() : 0;
        result = 31 * result + (filterStoryTaskDto != null ? filterStoryTaskDto.hashCode() : 0);
        result = 31 * result + (filterSoftwareApplicationDto != null ? filterSoftwareApplicationDto.hashCode() : 0);
        result = 31 * result + (filterCommentDto != null ? filterCommentDto.hashCode() : 0);
        result = 31 * result + (filterUserDto != null ? filterUserDto.hashCode() : 0);
        result = 31 * result + startFromResult;
        result = 31 * result + pageSize;
        return result;
    }

    @Override
    public String toString() {
        return "FilterByMultipleFieldsDto{" +
                "filterStoryDto=" + filterStoryDto +
                ", filterStoryTaskDto=" + filterStoryTaskDto +
                ", filterSoftwareApplicationDto=" + filterSoftwareApplicationDto +
                ", filterCommentDto=" + filterCommentDto +
                ", filterUserDto=" + filterUserDto +
                ", startFromResult=" + startFromResult +
                ", pageSize=" + pageSize +
                '}';
    }
}

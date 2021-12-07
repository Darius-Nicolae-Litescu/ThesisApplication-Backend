package darius.licenta.backend.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
        "page",
        "pageSize",
        "numberOfElements",
        "rows",
        "totalElements",
        "totalPages"
})
public class PaginatedResponse<T> {

    @JsonProperty("page")
    private int page;

    @JsonProperty("pageSize")
    private int pageSize;

    @JsonProperty("numberOfElements")
    private int numberOfElements;

    @JsonProperty("rows")
    private List<T> rows;

    @JsonProperty("totalElements")
    private long totalElements;

    @JsonProperty("totalPages")
    private int totalPages;


    public PaginatedResponse(int page, int pageSize, int currentRowCount, List<T> rows, long totalElements, int totalPages) {
        this.page = page;
        this.pageSize = pageSize;
        this.numberOfElements = currentRowCount;
        this.rows = rows;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public PaginatedResponse() {
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    @JsonProperty("pageSize")
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("currentRowCount")
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @JsonProperty("rows")
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @JsonProperty("totalElements")
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaginatedResponse<?> that = (PaginatedResponse<?>) o;
        return page == that.page && pageSize == that.pageSize && numberOfElements == that.numberOfElements && totalElements == that.totalElements && totalPages == that.totalPages && rows.equals(that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, pageSize, numberOfElements, rows, totalElements, totalPages);
    }

    @Override
    public String toString() {
        return "PaginatedResponse{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", numberOfElements=" + numberOfElements +
                ", rows=" + rows +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                '}';
    }
}

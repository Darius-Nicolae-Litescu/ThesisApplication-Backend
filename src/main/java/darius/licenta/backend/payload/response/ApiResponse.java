package darius.licenta.backend.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({
        "success",
        "message"
})
public class ApiResponse<T> implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 4L;

    @JsonProperty("message")
    private String message;

    @JsonProperty("success")
    private T result;

    @JsonIgnore
    private HttpStatus status;

    public ApiResponse(String message, T result, HttpStatus status) {
        this.message = message;
        this.result = result;
        this.status = status;
    }

    public ApiResponse(T result, HttpStatus status) {
        this.result = result;
        this.status = status;
    }
    public ApiResponse() {
    }

    public String getMessage() {
        return this.message;
    }

    public Object getResult() {
        return this.result;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("success")
    public void setResult(T result) {
        this.result = result;
    }

    @JsonIgnore
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse<?> that = (ApiResponse<?>) o;
        return message.equals(that.message) && result.equals(that.result) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, result, status);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", result=" + result +
                ", status=" + status +
                '}';
    }
}
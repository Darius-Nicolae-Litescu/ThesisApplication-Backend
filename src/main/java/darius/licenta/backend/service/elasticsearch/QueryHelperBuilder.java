package darius.licenta.backend.service.elasticsearch;

import org.apache.http.client.methods.HttpPost;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.util.List;
import java.util.Optional;

public class QueryHelperBuilder {

    public static String buildMultipleFieldSearchQuery(String term, Optional<List<String>> returnFields, Optional<List<String>> fields, String from, String size) {
        return "{\n" +
                "   \"from\":" + from + ",\n" +
                "   \"size\":" + size + ",\n" +
                "   \"track_total_hits\":true,\n" +
                "   \"_source\":" + returnFields.map(JSONArray::new).orElseGet(JSONArray::new) + "," +
                "   \"query\":{\n" +
                "      \"bool\":{\n" +
                "         \"should\":[\n" +
                "            {\n" +
                "               \"query_string\":{\n" +
                "                  \"fuzziness\":\"AUTO\",\n" +
                "                  \"query\":\"" + term + "\",\n" +
                "                  \"fields\":" + fields.map(JSONArray::new).orElseGet(JSONArray::new) +
                "               \n" +
                "            }\n" +
                "            },\n" +
                "            {\n" +
                "               \"query_string\":{\n" +
                "                  \"fuzziness\":\"AUTO\",\n" +
                "                  \"query\":\"*" + term + "*\",\n" +
                "                  \"fields\":" + fields.map(JSONArray::new).orElseGet(JSONArray::new) +
                "               \n" +
                "            }\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   },\n" +
                "   \"highlight\":{\n" +
                "      \"fields\":{\n" +
                "         \"*\":{}\n" +
                "      },\n" +
                "      \"require_field_match\":true\n" +
                "   }\n" +
                "}";
    }
}
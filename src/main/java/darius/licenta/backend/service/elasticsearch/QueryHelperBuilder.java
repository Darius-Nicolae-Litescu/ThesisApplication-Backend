package darius.licenta.backend.service.elasticsearch;

import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.util.List;

public class QueryHelperBuilder {

    public static String buildMultipleFieldSearchQuery(String term, List<String> returnFields, List<String> fields, String from, String size) {
        return "{\n" +
                "   \"from\":" + from + ",\n" +
                "   \"size\":" + size + ",\n" +
                "   \"track_total_hits\":true,\n" +
                "   \"_source\":" + new JSONArray(returnFields) + "," +
                "   \"query\":{\n" +
                "      \"bool\":{\n" +
                "         \"should\":[\n" +
                "            {\n" +
                "               \"query_string\":{\n" +
                "                  \"fuzziness\":\"AUTO\",\n" +
                "                  \"query\":\"" + term + "\",\n" +
                "                  \"fields\":" + new JSONArray(fields) +
                "               \n" +
                "            }\n" +
                "            },\n" +
                "            {\n" +
                "               \"query_string\":{\n" +
                "                  \"fuzziness\":\"AUTO\",\n" +
                "                  \"query\":\"*" + term + "*\",\n" +
                "                  \"fields\":" + new JSONArray(fields) +
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
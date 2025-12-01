package org.example;

import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Reusable_methods {
    public static JsonPath rawtojson(String response){
        JsonPath jsonParser=new JsonPath(response);
        return jsonParser ;
    }

    public static Map<String,Object> search_name(List<Map<String, Object>> list, String SearchField, String SearchValue) {
        Map<String, Object> obj_found = null;
        boolean match = false;
        for (Map<String, Object> obj : list) {
            Object nameValue = obj.get(SearchField);
            if (((String) nameValue).equalsIgnoreCase(SearchValue)) {
                System.out.println("Found + : " + nameValue + "with ID : " + obj.get("id"));
                obj_found = obj;
                break;

            }
        }
        return obj_found;
    }
}

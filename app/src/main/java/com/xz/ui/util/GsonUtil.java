package com.xz.ui.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class GsonUtil {

    private static final Gson GSON = new Gson();
    private static final JsonParser PARSER = new JsonParser();

    private GsonUtil() {
    	
    }
 
    public static <T> T jsonStringToObject(String jsonStr, Class<T> objCls) {
        try {
            return GSON.fromJson(jsonStr, objCls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
    public static Object jsonStringToObject(String jsonStr, Type type) {
        try {
            return GSON.fromJson(jsonStr, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public static <T> List<T> jsonArrayStringToList(String jsonArrayStr, Class<T> elementCls) {
        List<T> result = new ArrayList<T>();
        try {
            JsonArray array = stringToJsonArray(jsonArrayStr);
            for (JsonElement element : array) {
                result.add(GSON.fromJson(element, elementCls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static List jsonArrayStringToList(String jsonArrayStr, Type type) {
		List result = new ArrayList();
        try {
            JsonArray array = stringToJsonArray(jsonArrayStr);
            for (JsonElement element : array) {
                result.add(GSON.fromJson(element, type));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 
    public static String objectToJsonString(Object obj) {
        try {
            return GSON.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public static <T> String listToJsonArrayString(List<T> list) {
        Type type = new TypeToken<List<T>>(){ }.getType();	//SUPPRESS CHECKSTYLE
        try {
            return GSON.toJson(list, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     
    public static JsonObject stringToJson(String str) {
        try {
            return PARSER.parse(str).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public static JsonArray stringToJsonArray(String str) {
        try {
            return PARSER.parse(str).getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    public static String jsonToString(JsonObject jsonObject) {
        return jsonObject.toString();
    }
 
    public static String jsonArrayToString(JsonArray jsonArray) {
        return jsonArray.toString();
    }
}

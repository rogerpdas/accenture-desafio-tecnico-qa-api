package br.com.desafio_tecnico_accenture.util;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ReportUtil {

    private static final Map<String, Response> bag = new HashMap<>();

    public static void setResponseReport(String nameRequest, Response getResponse){
        bag.put(nameRequest,getResponse);
    }

    public static Response getResponseReport(String nameRequest){
        return bag.get(nameRequest);
    }

}

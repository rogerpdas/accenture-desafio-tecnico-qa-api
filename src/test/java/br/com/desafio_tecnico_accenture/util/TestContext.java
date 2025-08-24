package br.com.desafio_tecnico_accenture.util;

import java.util.*;


public class TestContext {
    private static final TestContext INSTANCE = new TestContext();
    private final Map<String, Object> bag = new HashMap<>();

    private TestContext() { }

    public static TestContext get() {
        return INSTANCE;
    }

    public void set(String k, Object v){
        bag.put(k, v);
    }

    @SuppressWarnings("unchecked")
    public <T> T getAs(String k){
        return (T) bag.get(k);
    }
}
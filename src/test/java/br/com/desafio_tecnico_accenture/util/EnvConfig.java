package br.com.desafio_tecnico_accenture.util;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {

    private static final Dotenv dotenv = Dotenv.load();
    public static String get(String key) { return dotenv.get(key); }
    public static String baseUrl() { return get("BASE_URL"); }
    public static String password() { return get("PASSWORD"); }
    public static String user(){ return get("USER_NAME");}


}
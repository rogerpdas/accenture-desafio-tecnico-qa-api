package br.com.desafio_tecnico_accenture.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuthUtil {
    public static String header() {
        String raw = EnvConfig.user() + ":" + EnvConfig.password();
        String b64 = Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
        return "Basic " + b64;
    }
}
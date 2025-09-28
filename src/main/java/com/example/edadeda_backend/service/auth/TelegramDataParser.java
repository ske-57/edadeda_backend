package com.example.edadeda_backend.service.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class TelegramDataParser {

    public record Result(Long tgId, String name) {}

    public Result parse(String initDataString) {
        Map<String, String> qs = parseQueryPreservingPlus(initDataString);
        String userJson = qs.get("user");
        if (userJson == null || userJson.isBlank())
            throw new IllegalArgumentException("initData: параметр 'user' отсутствует");

        try {
            JsonNode u = new ObjectMapper().readTree(userJson);
            Long id = u.path("id").isMissingNode() ? null : u.get("id").asLong();
            if (id == null) throw new IllegalArgumentException("initData.user.id отсутствует");
            String first = u.path("first_name").asText(null);
            String username = u.path("username").asText(null);
            String name = (first != null && !first.isBlank()) ? first : username;
            return new Result(id, name);
        } catch (Exception e) {
            throw new IllegalArgumentException("initData: не удалось распарсить JSON из 'user'", e);
        }
    }

    private Map<String, String> parseQueryPreservingPlus(String q) {
        Map<String, String> map = new LinkedHashMap<>();
        if (q == null || q.isEmpty()) return map;
        for (String pair : q.split("&")) {
            int idx = pair.indexOf('=');
            String rawKey = (idx >= 0) ? pair.substring(0, idx) : pair;
            String rawVal = (idx >= 0) ? pair.substring(idx + 1) : "";
            String key = decode(rawKey);
            String val = decode(rawVal);
            map.put(key, val);
        }
        return map;
    }

    private String decode(String s) {
        try {
            return URLDecoder.decode(s.replace("+", "%2B"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Failed to URL-decode: " + s, e);
        }
    }
}

package com.dongdong.entity.enumeration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum SexEnum {

    MAN("0", "男"),

    WOMAN("1", "女"),

    OTHER("2", "其他");

    private String code;
    private String value;

    SexEnum(String code, String value){
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static Map<String, SexEnum> getMap() {
        Map<String, SexEnum> eduMaps = new HashMap<>();
        Arrays.stream(SexEnum.values()).forEach(edu -> {
            eduMaps.put(edu.code, edu);
        });
        return eduMaps;
    }
}

package com.dongdong.entity.enumeration;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaodexu
 */
@Getter
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

    public static Map<String, SexEnum> getMap() {
        Map<String, SexEnum> eduMaps = new HashMap<>();
        Arrays.stream(SexEnum.values()).forEach(edu -> {
            eduMaps.put(edu.code, edu);
        });
        return eduMaps;
    }
}

package com.dongdong.consts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result <T> {

    private String code;

    private String message;

    private String timeStamp;

    private T data;
}

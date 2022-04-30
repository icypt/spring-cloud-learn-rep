package com.icypt.learn.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResultVo<T> {
    private String code;
    private String message;
    private T  data;

    public ResultVo(String code, String message) {
       this(code, message, null);
    }
}

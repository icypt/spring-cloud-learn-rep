package com.icypt.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}

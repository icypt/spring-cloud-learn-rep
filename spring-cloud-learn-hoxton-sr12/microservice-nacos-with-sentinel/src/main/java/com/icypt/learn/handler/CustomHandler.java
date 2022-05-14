package com.icypt.learn.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomHandler {
    public static String defaultHandler(BlockException blockException) {
        return "defaultHandler";
    }
}

package com.icypt.learn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.icypt.learn.handler.CustomHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class FlowCtrlController {

    @GetMapping("/testA")
    @SentinelResource(value = "testA" ,blockHandlerClass = CustomHandler.class, blockHandler = "defaultHandler")
    public  String testA() {
        return "=========testA=============";
    }

    @GetMapping("/testB")
    public  String testB() {
        System.out.println("=========testB=============");
        return "=========testB=============";
    }

    @GetMapping("/exception")
    public  String timeout() throws InterruptedException {
        int a = 10/0;
        return "0k";
    }

    //===============热点限流===================
    @GetMapping("/hotKey")
    @SentinelResource(value = "hot", blockHandler = "hotKeyHandle")
    public  String hotKey(@RequestParam("a") String a,
                          @RequestParam("b") String b) throws InterruptedException {
        return a + "\t" + b;
    }

    public String hotKeyHandle(String a, String b , BlockException e) {
        return "被热点限流";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "resourceName", blockHandler = "byResourceHandler")
    public  String byResource() {
        return "byResource";
    }

    public String byResourceHandler(BlockException blockException) {
        return "byResourceHandler";
    }


}

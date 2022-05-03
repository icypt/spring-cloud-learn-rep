package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Payment;
import com.icypt.learn.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;




    @PostMapping("/create")
    public ResultVo create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("=====插入成功=======");
        if(result > 0) {
            return new ResultVo("200", "插入数据成功,port："+serverPort,result);
        } else {
            return new ResultVo("444", "插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public ResultVo get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if(null != payment) {
            return new ResultVo("200", "查询成功,port："+serverPort, payment);
        } else {
            return new ResultVo("444", "没记录", null);
        }
    }

    @GetMapping("/registerInfo")
    public Object registerInfo() {
        List<String> services = discoveryClient.getServices();
        for(String service : services) {
            log.info("======element=======" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-provider-register-multiple");
        for(ServiceInstance instance : instances) {
            log.info("========info==========" + instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() +"\t" + instance.getUri());
        }
        return discoveryClient.getServices();
    }

    @GetMapping("/timeout")
    public String timeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

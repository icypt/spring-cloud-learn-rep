package com.icypt.learn.controller;

import com.icypt.learn.common.vo.ResultVo;
import com.icypt.learn.entity.Order;
import com.icypt.learn.entity.PayStream;
import com.icypt.learn.service.PayStreamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/payStream")
public class PayStreamController {

    @Resource
    private PayStreamService payStreamService;

    @PostMapping("/create")
    public ResultVo create(@RequestBody PayStream payStream) {
        payStream.setPayStreamCreateTime(new Date());
        boolean flag = payStreamService.createPayStream(payStream);
        if(flag) {
            return new ResultVo("200", "流水创建成功");
        } else {
            return new ResultVo("500", "流水创建失败");
        }
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody PayStream payStream) {
        boolean flag = payStreamService.updatePayStream(payStream);
        if(flag) {
            return new ResultVo("200", "流水更新成功");
        } else {
            return new ResultVo("500", "流水更新失败");
        }
    }

    @PostMapping("/pay")
    public ResultVo pay(@RequestBody PayStream payStream) {
        if("105".equals(payStream.getPayStreamAmt())) {
            throw new RuntimeException("系统运行异常");
        }
        return new ResultVo("200", "支付成功");
    }
}

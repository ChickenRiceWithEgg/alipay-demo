package com.learn.alipaydemo.controller;

import com.alipay.api.AlipayApiException;
import com.learn.alipaydemo.entity.Alipay;
import com.learn.alipaydemo.service.AlipayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class AlipayController {

    @Resource
    private AlipayService alipayService;

    /**
     * 沙箱支付需要把浏览器中和支付宝相关的网页全部关闭，否则提示存在钓鱼风险
     * @param outTradeNo
     * @param subject
     * @param totalAmount
     * @param body
     * @return
     * @throws AlipayApiException
     */
    @PostMapping("alipay")
    public String pay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        Alipay alipayBean = new Alipay();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return alipayService.pay(alipayBean);
    }

}

package com.learn.alipaydemo.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.learn.alipaydemo.entity.Alipay;
import com.learn.alipaydemo.properties.AlipayProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class AlipayService {

    @Resource
    private AlipayProperties alipayProperties;

    public String pay(Alipay alipay) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayProperties.getServerUrl(),
                alipayProperties.getAppId(),
                alipayProperties.getPrivateKey(),
                alipayProperties.getFormat(),
                alipayProperties.getCharset(),
                alipayProperties.getPublicKey(),
                alipayProperties.getSignType());
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(alipayProperties.getReturnUrl());
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(alipayProperties.getNotifyUrl());
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipay));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        log.info(result);
        // 返回付款信息
        return result;
    }

}

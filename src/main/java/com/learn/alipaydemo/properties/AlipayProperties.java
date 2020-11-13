package com.learn.alipaydemo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties {

    /**
     * 支付宝网关接口
     */
    private String serverUrl;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 请求格式
     */
    private String format;

    /**
     * 编码
     */
    private String charset;

    /**
     * 签名方式
     */
    private String signType;

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    private String returnUrl;

    /**
     * 服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    private String notifyUrl;

}

package com.god23bin.msm.service;

/**
 * 短信服务
 * @author god23bin
 */
public interface MsmService {
    /**
     * 发送短信
     * @param phoneNumber 手机号
     * @param code 随机验证码
     * @return
     */
    boolean sendShortMessage(String phoneNumber, String code);
}

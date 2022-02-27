package com.god23bin.msm.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.god23bin.msm.service.MsmService;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 短信服务
 * @author god23bin
 */
@Service
public class MsmServiceImpl implements MsmService {
    /**
     * 短信应用SDK AppID   // 1400开头
     */
    private static final int APP_ID = 1400634204;
    /**
     * 短信应用SDK AppKey
     */
    private static final String APP_KEY = "0a350b3ec9a4106d349edeb8163497f9";
    /**
     * 短信模板ID，需要在短信应用中申请
     */
    private static final int TEMPLATE_ID = 1309848;
    /**
     * 签名，使用的是`签名内容`，而不是`签名ID`
     */
    private static final String SMS_SIGN = "god23bin公众号";
    /**
     * 发送短信
     *
     * @param phoneNumber 手机号
     * @param code        随机验证码
     * @return
     */
    @Override
    public boolean sendShortMessage(String phoneNumber, String code) {
        try {
            // 数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            String[] params = {code};
            SmsSingleSender ssender = new SmsSingleSender(APP_ID, APP_KEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, TEMPLATE_ID, params, SMS_SIGN, "", "");
            return true;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
            return false;
        }
    }
}

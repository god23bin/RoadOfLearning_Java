package com.god23bin.msm.controller;

import com.god23bin.commonbase.utils.RedisUtil;
import com.god23bin.commonutils.RandomUtils;
import com.god23bin.commonutils.Result;
import com.god23bin.msm.service.MsmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * 短信服务前端控制器
 * @author god23bin
 */
@RestController
@CrossOrigin
@RequestMapping("/txmsm/msm")
public class MsmController {

    @Autowired
    MsmService msmService;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("send/{phoneNumber}")
    public Result sendMsm(@PathVariable String phoneNumber) {
        // 先看看缓存中有没有验证码
        String code = (String)redisUtil.get("phoneNumber");
        // 有验证码则直接返回
        if (!StringUtils.isEmpty(code)) {
            return Result.ok();
        }
        // 没有则生成字符串类型的4位数的验证码
        code = RandomUtils.getFourBitRandom();
        boolean flag = msmService.sendShortMessage(phoneNumber, code);
        if (flag) {
            // 发送成功，则将验证码存储到 redis 里，设置过期时间300秒，即5分钟
            redisUtil.set(phoneNumber, code, 300);
            return Result.ok();
        } else {
            return Result.error().msg("短信验证码发送失败");
        }
    }

}

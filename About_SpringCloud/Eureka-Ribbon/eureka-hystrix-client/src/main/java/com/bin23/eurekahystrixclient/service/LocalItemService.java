package com.bin23.eurekahystrixclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocalItemService {

    @Autowired
    private RestTemplate restTemplate;
    /**
     * @HystrixCommand该注解修饰的hi()方法就启动了熔断的功能
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String id){
        return restTemplate.getForObject("http://hystrix-provider/hi?id=" + id, String.class);
    }

    public String hiError(String id){
        return String.format("你好啊，你的消息是：%s，但是请求失败", id);
    }
}

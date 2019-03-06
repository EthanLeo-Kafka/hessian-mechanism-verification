package cn.mamba.services;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yufei.liu
 * @Date 2019/3/6 14:57
 * @Version v1.0
 */
@Service("chinese")
public class ChineseGreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String s) {
        return "你好呀，" + s;
    }

}

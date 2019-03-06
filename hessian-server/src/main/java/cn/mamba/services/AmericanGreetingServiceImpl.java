package cn.mamba.services;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yufei.liu
 * @Date 2019/3/6 14:58
 * @Version v1.0
 */
@Service("american")
public class AmericanGreetingServiceImpl implements GreetingService {


    @Override
    public String sayHello(String s) {
        return "Hello, " + s;
    }
}

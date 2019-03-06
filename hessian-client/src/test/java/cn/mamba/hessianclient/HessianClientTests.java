package cn.mamba.hessianclient;

import cn.mamba.beans.Config;
import cn.mamba.beans.ResultBean;
import cn.mamba.services.ConfigService;
import cn.mamba.services.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HessianClientTests {

    @Autowired
    ConfigService configService;

    @Autowired
    @Qualifier("american")
    GreetingService americanGreetingService;

    @Autowired
    @Qualifier("chinese")
    GreetingService chineseGreetingService;

    @Test
    public void configTest() {
        ResultBean<Long> addResult = configService.addConfig(Config.builder().name("配置项名称").value("配置项值").build());
        System.out.println(addResult);

        ResultBean<Collection<Config>> all = configService.getAll();
        System.out.println(all);

        // 把刚刚新建的删除掉
        ResultBean<Boolean> deleteResult = configService.delete(addResult.getData());
        System.out.println(deleteResult);
    }

    @Test
    public void greetingTest() {
        System.err.println(americanGreetingService.sayHello("Jack"));
        System.err.println(chineseGreetingService.sayHello("上官狗蛋"));
    }
}

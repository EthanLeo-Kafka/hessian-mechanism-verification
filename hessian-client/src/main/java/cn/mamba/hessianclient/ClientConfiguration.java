package cn.mamba.hessianclient;

import cn.mamba.services.ConfigService;
import cn.mamba.services.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * @author yufei.liu
 */
@Configuration
public class ClientConfiguration {

    @Bean
    public HessianProxyFactoryBean helloClient() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();

        factory.setServiceUrl("http://localhost:8082/ConfigService");
        factory.setServiceInterface(ConfigService.class);

        return factory;
    }

    @Bean
    public HessianProxyFactoryBean american() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();

        factory.setServiceUrl("http://localhost:8082/american");
        factory.setServiceInterface(GreetingService.class);

        return factory;
    }

    @Bean
    public HessianProxyFactoryBean chinese() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();

        factory.setServiceUrl("http://localhost:8082/chinese");
        factory.setServiceInterface(GreetingService.class);

        return factory;
    }
}
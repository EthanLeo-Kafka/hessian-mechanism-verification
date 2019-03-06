package cn.mamba;

import cn.mamba.services.ConfigService;
import cn.mamba.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * 发布Config的Hessian服务
 *
 * @author 晓风轻 https://github.com/xwjie/HessianDemo
 */
@Configuration
public class ServerConfiguration {

    @Autowired
    private ConfigService configServiceImpl;

    @Autowired
    @Qualifier("american")
    private GreetingService americanGreetingService;

    @Autowired
    @Qualifier("chinese")
    private GreetingService chineseGreetingService;

    @Bean(name = "/ConfigService")
    public HessianServiceExporter hessianServiceExporter() {
        HessianServiceExporter exporter = new HessianServiceExporter();

        exporter.setService(configServiceImpl);
        exporter.setServiceInterface(ConfigService.class);

        return exporter;
    }

    @Bean(name = "/american")
    public HessianServiceExporter american() {
        HessianServiceExporter exporter = new HessianServiceExporter();

        exporter.setService(americanGreetingService);
        exporter.setServiceInterface(GreetingService.class);

        return exporter;
    }

    @Bean(name = "/chinese")
    public HessianServiceExporter chinese() {
        HessianServiceExporter exporter = new HessianServiceExporter();

        exporter.setService(chineseGreetingService);
        exporter.setServiceInterface(GreetingService.class);

        return exporter;
    }
}
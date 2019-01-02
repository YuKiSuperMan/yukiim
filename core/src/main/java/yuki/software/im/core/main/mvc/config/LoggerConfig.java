package yuki.software.im.core.main.mvc.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @programN: yukiim
 * @description: 日志
 * @author: YuKi
 * @create: 2019-01-02 11:34
 * @email: 1040929773@qq.com
 */
@Configuration
@EnableAspectJAutoProxy
public class LoggerConfig {

    @Bean
    public static Logger logger(){
        String path="/log4j.properties";
        URL url=LoggerConfig.class.getResource(path);
        ConfigurationSource source;
        try {
            source = new ConfigurationSource(new FileInputStream(new File(url.getPath())),url);
            Configurator.initialize(null, source);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Logger logger = Logger.getLogger(LoggerConfig.class);
        return logger;
    }

}

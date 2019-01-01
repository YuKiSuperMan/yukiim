package yuki.software.im.core.main.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @programN: yuki_im
 * @description: 开启
 * @author: YuKi
 * @create: 2019-01-01 15:42
 * @email: 1040929773@qq.com
 */
@Configuration
@ComponentScan("yuki.software.im")
public class SpringStart {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

}

package cn.jianwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author jianwoo
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class JianwooApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(JianwooApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  简窝模板应用启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}

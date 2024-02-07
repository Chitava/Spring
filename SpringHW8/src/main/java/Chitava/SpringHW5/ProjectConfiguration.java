package Chitava.SpringHW5;

import Chitava.SpringHW5.aspect.TaskLogerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "Chitava.SpringHW5")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public TaskLogerAspect aspect() {
        return new TaskLogerAspect();
    }
}

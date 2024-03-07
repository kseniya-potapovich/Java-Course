package com.tms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class AllAnnotation {
    /*@Component - помечает класс как потенциальный бин
    @ComponentScan("com.tms") - сканируть путь, который указан
    @Autowired - внедряет зависимость
    @Qualifier - определяет какой из бинов нужно заавтовайрить
    @Primary - определяет какой из бинов более главный
    @Bean - объект, который контролируется Spring*/


}

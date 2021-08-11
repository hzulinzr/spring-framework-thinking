package com.lin.spring.ioc.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author lzr
 * 依赖查找示例
 * @date 2021-07-29 11:36:13
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 DependencyLookupDemo 作为配置类
        applicationContext.register(DependencyLookupDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找对象
        lookupByObjectProvider(applicationContext);

        // 关闭上下文
        applicationContext.close();
    }

    @Bean
    public String helloWorld() {
        return "helloWorld";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}


package com.baoshan.shanghai.project.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时启动，停止监视器；
 */
@EnableScheduling
@Component
public class CronTimer {

    @Autowired
    private KafkaListenerEndpointRegistry registry;
    @Autowired
    private ConsumerFactory consumerFactory;
    // 监听器容器工厂(设置禁止KafkaListener自启动)
    @Bean
    public ConcurrentKafkaListenerContainerFactory delayContainerFactory() {
        ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
        container.setConsumerFactory(consumerFactory);
        //禁止KafkaListener自启动
        container.setAutoStartup(false);
        return container;
    }
    // 监听器
    @KafkaListener(id="timingConsumer",topics = "topic2",containerFactory = "delayContainerFactory")
    public void onMessage1(ConsumerRecord<?, ?> record){
        System.out.println("消费成功 listener："+record.topic()+"-"+record.partition()+"-"+record.value());
    }

    // 定时启动监听器
    @Scheduled(cron = "0 36 15 * * ? ")
    public void startListener() {
        System.out.println("启动监听器...");
        // "timingConsumer"是@KafkaListener注解后面设置的监听器ID,标识这个监听器
        if (!registry.getListenerContainer("timingConsumer").isRunning()) {
            registry.getListenerContainer("timingConsumer").start();
        }
        //registry.getListenerContainer("timingConsumer").resume();
    }

    // 定时停止监听器
    @Scheduled(cron = "0 38 15 * * ? ")
    public void shutDownListener() {
        System.out.println("关闭监听器...");
        registry.getListenerContainer("timingConsumer").pause();
    }
}

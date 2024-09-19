package dev.isaac.tests.xmlcamel.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.builder.DeadLetterChannelBuilder;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.apache.camel.model.RedeliveryPolicyDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value("${spring.activemq.password}")
    private String password;
    @Value("${spring.activemq.user}")
    private String username;

    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory() {
        var connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean(name = "activemq")
    public ActiveMQComponent createComponent(ConnectionFactory factory) {
        var activemq = new ActiveMQComponent();
        activemq.setConnectionFactory(factory);
        activemq.setMaxConcurrentConsumers(1);
        activemq.setConcurrentConsumers(1);
        return activemq;
    }


    @Bean
    public DeadLetterChannelBuilder globalCamelErrorHandler() {
        var deadLetterChannelBuilder = new DeadLetterChannelBuilder();
        deadLetterChannelBuilder.setDeadLetterUri("activemq:queue:demo-queue.dlq");
        deadLetterChannelBuilder.setRedeliveryPolicy(new RedeliveryPolicyDefinition()
                .maximumRedeliveries(1)
                .redeliveryDelay(150));
        deadLetterChannelBuilder.useOriginalMessage();
        return deadLetterChannelBuilder;
    }
}

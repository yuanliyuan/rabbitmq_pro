package com.yl.spingboot.producer;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {

    @Bean("directQueue")
    public Queue directQueue(){
        return new Queue("direct_queue",true);
    }

    @Bean("directExchange")
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange",true,false);
    }

    @Bean
    public Binding bindingDirect(@Qualifier("directQueue") Queue queue, @Qualifier("directExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("direct").noargs();
    }


}

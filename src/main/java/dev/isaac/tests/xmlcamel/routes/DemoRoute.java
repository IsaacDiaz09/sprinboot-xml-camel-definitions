package dev.isaac.tests.xmlcamel.routes;

import dev.isaac.tests.xmlcamel.camelbeans.MyBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class DemoRoute extends RouteBuilder {
    @Autowired
    private MyBean mybean;

    @Override
    public void configure() {
        from("timer://demotimer?period=1500")
            .log("Current Time is :: " + LocalDateTime.now())
                .to("bean:myBean");
    }
}

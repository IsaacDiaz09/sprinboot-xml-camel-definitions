package dev.isaac.tests.xmlcamel.camelbeans;

import lombok.extern.log4j.Log4j2;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DemoProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        var randomNumber = Math.random();
        //if (randomNumber > 0.5) {
            throw new NullPointerException();
        //}
    }
}

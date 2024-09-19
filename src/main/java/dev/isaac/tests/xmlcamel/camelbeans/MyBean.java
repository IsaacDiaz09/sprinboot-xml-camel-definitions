package dev.isaac.tests.xmlcamel.camelbeans;

import dev.isaac.tests.xmlcamel.annotations.UseByCamelRoute;
import dev.isaac.tests.xmlcamel.services.TodosRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyBean {

    private final TodosRepository todosRepository;

    @UseByCamelRoute
    public void doProcess(Exchange exchange) {
        log.info("Created Todo with ID: '{}'", 1);
    }

    @PostConstruct
    void emptyTodos() {

    }

}

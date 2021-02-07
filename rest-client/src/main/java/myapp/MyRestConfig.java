package myapp;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRestConfig extends RouteBuilder {

    @Value("${rest.port}")
    private int restPort;

    @Override
    public void configure() {
        restConfiguration().component("jetty").port(restPort);
    }

}

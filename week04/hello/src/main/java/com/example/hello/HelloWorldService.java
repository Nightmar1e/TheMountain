package com.example.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    @Value("${native_hello_world}")
    private String nativeHelloWorld;

    @Value("${NL_hello_world}")
    private String nlHelloWorld;

    @Value("${FR_hello_world}")
    private String frHelloWorld;

    @Value("${GER_hello_world}")
    private String gerHelloWorld;

    public String getNativeHelloMessage() {
        return nativeHelloWorld;
    }

    public String getNLHelloMessage() {
        return nlHelloWorld;
    }

    public String getFRHelloMessage() {
        return frHelloWorld;
    }

    public String getGERHelloMessage() {
        return gerHelloWorld;
    }
}

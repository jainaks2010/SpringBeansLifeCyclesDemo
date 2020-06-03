package com.demo.spring.beans.lifecycles;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private String serviceName = "BookService";

    public String getServiceName() {
        return serviceName;
    }
}

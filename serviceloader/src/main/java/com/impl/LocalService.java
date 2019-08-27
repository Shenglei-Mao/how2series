package com.impl;

import com.service.IService;

/**
 * @author : Michael M
 */
public class LocalService implements IService {
    @Override
    public String sayHello() {
        return "Hello local service";
    }

    @Override
    public String getScheme() {
        return "local";
    }
}

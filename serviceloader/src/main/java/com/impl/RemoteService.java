package com.impl;

import com.service.IService;

/**
 * @author : Michael M
 */
public class RemoteService implements IService {
    @Override
    public String sayHello() {
        return "Hello remote service";
    }

    @Override
    public String getScheme() {
        return "remote";
    }
}

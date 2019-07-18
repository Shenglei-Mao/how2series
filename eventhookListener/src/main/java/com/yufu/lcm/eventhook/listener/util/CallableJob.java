package com.yufu.lcm.eventhook.listener.util;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class CallableJob implements Callable<String> {
    private String data;

    @Override
    public String call() throws Exception {

        return data;
    }
}

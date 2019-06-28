package com.yufu.lcm.eventhook.listener.util;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitMQUtil {

    public static void main(String[] args) {
        checkServer();
    }
    public static void checkServer() {
        if(NetUtil.isUsableLocalPort(5672)) {
            log.warn("RabbitMQ未启动");
            System.exit(1);
        }else {
            log.info("RabbitMQ已经启动。");
        }
    }
}

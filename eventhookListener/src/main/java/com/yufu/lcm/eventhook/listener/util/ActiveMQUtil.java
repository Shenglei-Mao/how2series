package com.yufu.lcm.eventhook.listener.util;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActiveMQUtil {

    public static void main(String[] args) {
        checkServer();
    }
    public static void checkServer() {
        if(NetUtil.isUsableLocalPort(8161)) {
            log.warn("ActiveMQ未启动");
            System.exit(1);
        }else {
            log.info("ActiveMQ已经启动。");
        }
    }
}

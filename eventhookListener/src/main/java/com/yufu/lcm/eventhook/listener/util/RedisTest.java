package com.yufu.lcm.eventhook.listener.util;

import redis.clients.jedis.Jedis;

public class RedisTest {
    private final static Jedis jedis = new Jedis("localhost");
    public static void main(String[] args) {
        jedis.set("Shenglei", "male");
    }
}

package com.yufu.lcm.eventhook.listener.eventconvert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Jackson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        DingTalkEvent dingTalkEvent = DingTalkEvent.newInstance().
            setUserId("tn-0c1d86f3be9a4d73a051fba97192e059").
            setEvent("update").
            setResult("success");

        int a = 0;
        try {
            System.out.print("Jackson String is: ");
            System.out.println(objectMapper.writeValueAsString(dingTalkEvent));
            System.out.print("Default String is: ");
            System.out.println(dingTalkEvent.toString());


            String jacksonString = objectMapper.writeValueAsString(dingTalkEvent);
            Map<String, String> map = objectMapper.readValue(jacksonString, Map.class);
            System.out.println(map);
            System.out.println(map.get("userId"));
            System.out.println(map.get("Hello"));


            a = 2;

            final StandardEvent dingTalkEvent1 = objectMapper.readValue(jacksonString, StandardEvent.class);
            System.out.println(dingTalkEvent1);

        } catch (IOException e) {
            System.out.println("Convert to standard event here...");
        }

        System.out.println(a);
    }
}
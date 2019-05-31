package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Queue;

@Setter
@Getter
public class CityObject {
    private Queue<UserObject> pq;
    private Map<String, AreaObject> lut;

}

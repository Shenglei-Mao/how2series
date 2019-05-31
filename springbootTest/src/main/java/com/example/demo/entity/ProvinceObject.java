package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Queue;

@Setter
@Getter
public class ProvinceObject {
    private Queue<UserObject> pq;
    /*
    ProvinceObject有多个，但是对所有Province来说，这个Map是唯一的，那么Spring要如何处理？
     */
    private Map<String, CityObject> lut;
}


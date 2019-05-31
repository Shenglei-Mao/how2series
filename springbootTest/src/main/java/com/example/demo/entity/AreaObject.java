package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;

@Setter
@Getter
public class AreaObject {
    private Queue<UserObject> pq;
}

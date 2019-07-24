package com.yufu.lcm.eventhook.listener.eventconvert;

public class Debug {
    public static void main(String[] args) {
        int i = 0;
        while(true){
            printMessage(i++);
        }
    }
    private static void printMessage(int i){
        System.out.println(i);
    }
}

package pojo.girl;

import pojo.Boy;
import pojo.Girl;

public class Wangmeili implements Girl, Boy {

    @Override
    public void data() {
        System.out.println("Wangmeili: Sure, where to date?");
    }

    @Override
    public void watchMovie() {
        System.out.println("Wangmeili: What about Tokyo Hot?");
    }
}

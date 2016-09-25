package main.java.bupt.wxy.learn.test;

import java.io.Serializable;

/**
 * Created by xiyuanbupt on 9/18/16.
 */
public class Person implements Serializable{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

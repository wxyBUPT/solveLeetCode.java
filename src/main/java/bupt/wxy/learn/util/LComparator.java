package bupt.wxy.learn.util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiyuanbupt on 9/16/16.
 *
 */
public class LComparator {
    public static void main(String[] args){
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(1);
        dogs[1] = new Dog(2);
        Arrays.sort(dogs,new Dog());
        System.out.println("foo");
        /**
         * 因为没有实现comparable ,所以会报错
         */
        Arrays.sort(dogs);

    }
}

class Dog implements Comparator<Dog>{
    int age;

    public Dog(){

    }

    public Dog(int age){
        this.age = age;
    }
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.age - o2.age;
    }
}

class Cat implements Comparable<Cat>{
    @Override
    public int compareTo(Cat o) {
        return 0;
    }
}

class People implements Comparable<People>,Comparator<People>{
    @Override
    public int compareTo(People o) {
        return 0;
    }

    @Override
    public int compare(People o1, People o2) {
        return 0;
    }
}
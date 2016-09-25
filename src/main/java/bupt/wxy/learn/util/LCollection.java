package main.java.bupt.wxy.learn.util;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/14/16.
 */
public class LCollection {


    public static void main(String[] args){
        Collection<LearnCollection> c = new ArrayList<>();
        Collection<LearnCollection> d = new LinkedList<>();
        c.add(new LearnCollection());
        Object[] dogs = c.toArray();
        for(Object o:dogs){
            System.out.println(o);
        }
        c.addAll(d);
    }

    static class LearnCollection{
        @Override
        public String toString(){
            return "foo";
        }
    }
}

class MyMap<K,V> extends AbstractMap<K,V>{
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}

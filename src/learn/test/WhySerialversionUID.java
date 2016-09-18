package learn.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by xiyuanbupt on 9/18/16.
 * 如果不适用SerialversionUID,那么java 会自动帮助生成一个uuid,如果class 文件变了,那么uuid
 * 也就变了,即使多一个空格
 */
public class WhySerialversionUID {

    public static void main(String[] args) throws Exception{

        //这里是把对象序列化到文件中
        Person crab = new Person();
        crab.setName("Mr.Crab");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                "crab_file"
        ));
        oo.writeObject(crab);
        oo.writeObject(crab);
        oo.writeObject(crab);
        oo.writeObject(crab);
        oo.close();

        //下面是将对象从文件读回到内存
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("crab_file"));
        Person crab_back = (Person)oi.readObject();
        System.out.println("Hi, My name is: " + crab_back.getName());
        oi.close();
    }
}

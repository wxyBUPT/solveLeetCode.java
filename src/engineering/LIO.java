package engineering;

import java.io.*;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class LIO {
    public static void main(String[] args){
        InputStream in = new InputStream() {

            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        try {
            FileInputStream fi = new FileInputStream(new File("./test_java.in"));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {

            File f = new File("./test_java.in");
            System.out.println(f.exists());
            f.createNewFile();
            System.out.println(f.getName());
            System.out.println(f.getParent());
            System.out.println(f.getAbsoluteFile());
            System.out.println(f.getAbsolutePath());
            System.out.println(f.toURI());
            System.out.println(f.getUsableSpace());
            f.list();
            f.createTempFile("foo","bar");
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(new File("./test_java.in"));
            FileInputStream fi = new FileInputStream("./test_java.in");
            InputStreamReader inputStreamReader = new InputStreamReader(fi);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}

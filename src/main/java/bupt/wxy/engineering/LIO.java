package main.java.bupt.wxy.engineering;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;

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
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("./test_java.in"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("./random_access.in"), "rw");
            FileChannel fc = randomAccessFile.getChannel();
            randomAccessFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        Channels.newChannel(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        });

        FileChannel fileChannel = new FileChannel() {
            @Override
            public int read(ByteBuffer dst) throws IOException {
                return 0;
            }

            @Override
            public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
                return 0;
            }

            @Override
            public int write(ByteBuffer src) throws IOException {
                return 0;
            }

            @Override
            public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
                return 0;
            }

            @Override
            public long position() throws IOException {
                return 0;
            }

            @Override
            public FileChannel position(long newPosition) throws IOException {
                return null;
            }

            @Override
            public long size() throws IOException {
                return 0;
            }

            @Override
            public FileChannel truncate(long size) throws IOException {
                return null;
            }

            @Override
            public void force(boolean metaData) throws IOException {

            }

            @Override
            public long transferTo(long position, long count, WritableByteChannel target) throws IOException {
                return 0;
            }

            @Override
            public long transferFrom(ReadableByteChannel src, long position, long count) throws IOException {
                return 0;
            }

            @Override
            public int read(ByteBuffer dst, long position) throws IOException {
                return 0;
            }

            @Override
            public int write(ByteBuffer src, long position) throws IOException {
                return 0;
            }

            @Override
            public MappedByteBuffer map(MapMode mode, long position, long size) throws IOException {
                return null;
            }

            @Override
            public FileLock lock(long position, long size, boolean shared) throws IOException {
                return null;
            }

            @Override
            public FileLock tryLock(long position, long size, boolean shared) throws IOException {
                return null;
            }

            @Override
            protected void implCloseChannel() throws IOException {

            }
        };
    }
}

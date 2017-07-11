package com.minsub.java.basic;

import java.io.*;

/**
 * Created by kakao on 2017. 7. 11..
 */
public class SerializingTest {

    public static final String FILENAME = "data.ser";

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        Point before = new Point();
        before.x = 7;
        before.y = 20;
        before.lat = (float) 3.14;
        before.lon = (float) 12.15;

        writeObject(before);

        Object after = readObject();
        System.out.print("Before : ");
        System.out.println(before);
        System.out.print("After  : ");
        System.out.println(after);
    }

    private static void writeObject(Object obj) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILENAME);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
        fos.close();
    }

    private static Object readObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FILENAME);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object result = ois.readObject();
        ois.close();
        fis.close();

        return result;
    }

    static class Point implements Serializable {
        int x, y;
        transient float lat, lon;

        @Override
        public String toString() {
            return String.format("x=%d, y=%d, lat=%f, lon=%f", x, y, lat, lon);
        }
    }
}
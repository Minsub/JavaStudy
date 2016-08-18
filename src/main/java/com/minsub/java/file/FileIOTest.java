package com.minsub.java.file;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by hmm1115222 on 2016-08-02.
 */
public class FileIOTest {

//    @Test
    public void testJava7Paths() {
        // File 대신 Path를 사용
        Path path1 = Paths.get("C:/README.md");
        System.out.println(path1 + ": " + Files.exists(path1));

        // 디렉토리별로 다중 parameter로 넘길 수 있음
        Path path2 = Paths.get("C:","README.md");
        System.out.println(path2 + ": " + Files.exists(path2));

        //상대경로도 표시 가능
        Path path3 = Paths.get("src/main/java/com/minsub/java/file/TEXT_FILE.txt");
        System.out.println(path3 + ": " + Files.exists(path3));

    }

//    @Test
    public void testJava7ReadLine() throws Exception {
        // Read
        Path path = Paths.get("src/main/java/com/minsub/java/file/TEXT_FILE.txt");
        for (String line: Files.readAllLines(path)) {
            System.out.println(line);
        }
        String contents = "This is copied file";

        // Write
        Files.write(Paths.get("src/main/java/com/minsub/java/file/TEXT_FILE2.txt"), contents.getBytes());
    }

    @Test
    public void testCommonsIO() {
        try {
            String dir = "D:/JavaStudy/src/main/java/com/minsub/java/file/";
            String contents = "this is sample file\n2nd\n3nd";
            File file = new File(dir + "testWrite.txt");
            // write
            FileUtils.write(file, contents, Charset.forName("UTF-8"));

            // read
            String sReadContents = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
            System.out.println("read: " + sReadContents);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

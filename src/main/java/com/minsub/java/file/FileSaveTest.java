package com.minsub.java.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.StopWatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.*;

/**
 * Created by hmm1115222 on 2016-08-03.
 */
public class FileSaveTest {
    private static final String PATH_BASE = "D:/JavaStudy/src/main/java/com/minsub/java/file/";
    private static final String PATH_SRC = PATH_BASE + "TEST.zip";
    private static final String PATH_DES = PATH_BASE + "TEST_copy.zip";

    private static File strFile = new File(PATH_SRC);
    private static File desFile = new File(PATH_DES);
    private static int bufferSize = 1024 * 4;

    private StopWatch sw = new StopWatch();

    @Before
    public void setUp() throws Exception {
        Path path = Paths.get(PATH_DES);
        if (Files.exists(path)) {
            Files.delete(path);
        }
        sw.reset();
        sw.start();
    }
    @After
    public void after() throws Exception {
        sw.stop();
        System.out.println(": " + sw.toString());
    }

    @Test
    public void normal() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        BufferedInputStream bis = new BufferedInputStream(fis, bufferSize);
        BufferedOutputStream bos = new BufferedOutputStream(fos, bufferSize);

        int read = -1;
        while( (read = bis.read()) != -1 ) {
            bos.write(read);
        }

        bis.close();
        bos.close();

        System.out.print("Normal: Buffered File Input Stream: " );
    }

    @Test
    public void scater() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        ScatteringByteChannel sbc = fis.getChannel();
        GatheringByteChannel gbc = fos.getChannel();

        ByteBuffer bb = ByteBuffer.allocateDirect(bufferSize);
        while (sbc.read(bb) != -1) {
            bb.flip();
            gbc.write(bb);
            bb.clear();
        }

        fis.close();
        fos.close();

        System.out.print("Scatter: Scattering/Gathering Byte Channel: ");
    }

    @Test
    public void mapped() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();

        MappedByteBuffer mbb = fcIn.map(FileChannel.MapMode.READ_ONLY, 0, fcIn.size());
        fcOut.write(mbb);

        fis.close();
        fos.close();

        System.out.print("mappedByteBuffer: File Channel MappedByteBuffer: ");
    }

    @Test
    public void fileChannel() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();

        ByteBuffer bb = ByteBuffer.allocateDirect((int) fcIn.size());
        fcIn.read(bb);

        bb.flip();
        fcOut.write(bb);

        fis.close();
        fos.close();

        System.out.print("FileChannel + byte buffer: ");
    }

    @Test
    public void transferTO() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();

        fcIn.transferTo(0, fcIn.size(), fcOut);

        fis.close();
        fos.close();

        System.out.print("FileChannel + TransferTo: ");
    }

    @Test
    public void transfrom() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        FileChannel fcIn = fis.getChannel();
        FileChannel fcOut = fos.getChannel();

        fcOut.transferFrom(fcIn, 0, fcIn.size());

        fis.close();
        fos.close();

        System.out.print("FileChannel + TransferFrom: ");
    }

    @Test
    public void fileWriter() throws Exception {
        FileReader fr = new FileReader(strFile);
        FileWriter fw = new FileWriter(desFile);

        int read = -1;

        while((read = fr.read()) != -1) {
            fw.write(read);
        }

        fw.close();
        fr.close();

        System.out.print("fileReader + fileWriter: ");
    }

    @Test
    public void ioUtils() throws Exception {
        FileInputStream fis = new FileInputStream(strFile);
        //FileOutputStream fos = new FileOutputStream(desFile);

        FileUtils.copyInputStreamToFile(fis, desFile);

        System.out.print("Commons ioUtils: ");
    }

    @Test
    public void java7builtIn() throws Exception {
        Path pathSrc = Paths.get(PATH_SRC);
        Path pathDes = Paths.get(PATH_DES);
        CopyOption[] options = new CopyOption[]{StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES};

        Files.copy(pathSrc, pathDes, options);

        System.out.print("built-in NIO Copy(1.7): ");
    }

}

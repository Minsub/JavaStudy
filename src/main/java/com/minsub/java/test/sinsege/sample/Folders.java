package com.minsub.java.test.sinsege.sample;

import java.util.Collection;

public class Folders {
    private final static String FOLDER = "<folder";
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        return null;
    }


    public static void addName(String xml, char startingLetter) {
        int startIndex = xml.indexOf(FOLDER);
        //int endIndex = xml.lastIndexOf()


    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
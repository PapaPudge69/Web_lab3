package com.example.webmy3.db;

import java.io.*;

public class TestApp {
    static String user;
    static String password;
    static String url;

    public static String pass () throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:\\IntelliJ IDEA\\IntelliJ IDEA Projects\\webmy3\\src\\main\\java\\com\\example\\webmy3\\db\\123.txt"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String line = br.readLine();
        return line;
    }
//    public static  DBConnector() throws IOException {
//        user = "s369052";
//        password = pass();
//        url ="jdbc:postgresql://localhost:5432/studs";
//
//    }

    public static void main(String args[]) throws IOException {
        System.out.println(password = pass());
    }
}
package com.example.webmy3.db;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.DataInputStream;


public class DBConnector {
    String user;
    static String password;
    String url;
    public static String pass () throws IOException {
        DataInputStream dis =
                new DataInputStream (
                        Files.newInputStream(Paths.get("/home/studs/s369052/123.txt")));
        byte[] datainBytes = new byte[dis.available()];
        dis.readFully(datainBytes);
        dis.close();

        String pass = new String(datainBytes, 0, datainBytes.length);
        return pass;
    }
    public DBConnector() throws IOException {
        user = "s369052";
        password = pass();
        url ="jdbc:postgresql://localhost:5432/studs";
   }

   public Connection getConnection() throws Exception {
//       try {
//           Class.forName("org.postgresql.Driver");
//       } catch (ClassNotFoundException e) {
//           throw new Exception("Database driver not found");
//       }
//       return DriverManager.getConnection(url,user,password);

       InitialContext ctx = new InitialContext();
       DataSource ds = (DataSource) ctx.lookup("java:/PostgresDS");
       return ds.getConnection();
//   return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
    }


}
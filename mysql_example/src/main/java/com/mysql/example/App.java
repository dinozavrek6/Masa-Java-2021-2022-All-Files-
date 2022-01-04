package com.mysql.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
// import com.mysql.cj.x.protobuf.MysqlxCrud.Column;
// import com.mysql.cj.xdevapi.Result;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        ArrayList<String> usrPass = new ArrayList<>();
        usrPass = ReadFileByLine("mysql_crds.txt");
        String usr = usrPass.get(0);
        String psswd = usrPass.get(1);

        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/masa", usr, psswd);
            System.out.println("MySQL DB connected!");
            preparedStatement = conn.prepareStatement("INSERT INTO "
                    + "masa.students (p_id, name, surname) " + "VALUES (77777777, 'Jen', 'Snow');");
            preparedStatement.execute();

            preparedStatement = conn.prepareStatement("SELECT * FROM masa.students");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
            int nColumns = rsmd.getColumnCount();
            while (resultSet.next())
            {
                for (int i = 1; i <= nColumns; i++)
                {
                    String colVal = resultSet.getString(i);
                    System.out.print(colVal + " ");
                }
                System.out.println("");
            }

        }
        catch (Exception e)
        {
            System.out.println("Error connecting to MySQL DB!");
            System.out.println(e);
        }
    }

    public static ArrayList<String> ReadFileByLine(String fileName)
    {
        ArrayList<String> usrPass = new ArrayList<>();

        try
        {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                usrPass.add(scanner.next());
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return usrPass;
    }
}

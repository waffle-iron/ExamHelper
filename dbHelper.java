/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author David
 */

class Question{
    String question;
    String subject;
}

public class dbHelper{
        
    public static Connection c = null;
    public static String subTable = "Subject";
    public static String quesTable = "Question";
    public static String dbName = "ExamHelperDB";
    
    
    public static void createDB(){
        
        c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
	} catch (Exception e) {
	    System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    System.exit(0);
	}
	    System.out.println("Opened database successfully");
    }
    
    public static void addQuestion(Question ques){
        Statement stmt = null;
        int numSubjects = 0;
        int numQuestions = 0;
        
        
        try{
            stmt = c.createStatement();
            String sql = "create table if not exists subject(ID int primary key, sub text not null);\n";
            sql += "create table if not exists question(qID int primary key,sID int not null,ques text not null);\n";
            ResultSet rs = stmt.executeQuery(sql);
        } catch (Exception e){
            
        }
    }

    public static void main(String[] args) {
        
    }
    
}

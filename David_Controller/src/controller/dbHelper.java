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
    
    public static void createPopTables(){
        Statement stmt = null;
        
        try{
            stmt = c.createStatement();
            String sql = "create table if not exists subject(ID integer primary key autoincrement, sub text not null unique);\n";
            sql += "create table if not exists question(qID integer primary key autoincrement, sID int not null, ques text not null unique);\n";
            stmt.executeUpdate(sql);
            sql = "insert into subject values (null, \"Math\");\n" +
                    "insert into subject values (null, \"Introduction to Computer Science\");\n" +
                    "insert into subject values (null, \"Algorithms\");\n" +
                    "insert into subject values (null, \"Data Structures\");\n" +
                    "insert into subject values (null, \"Info and Rec\");";
            stmt.executeUpdate(sql);
            System.out.println("Created and populated the subject table");
            
            
            sql = "insert into question values(null, 4, \"Why are interfaces important when considering data structures?\");\n" +
                    "insert into question values(null, 4, \"How do you know the size of an array in C++?\");\n" +
                    "insert into question values(null, 5, \"What is collaborative filtering?\");\n" +
                    "insert into question values(null, 5, \"Give 4 examples of recommender systems as discussed in class\");\n" +
                    "insert into question values(null, 3, \"How does DFS work?\");\n" +
                    "insert into question values(null, 2, \"Write the pseudocode for an addition calculator function that takes two parameters (number A and number B)\");\n" +
                    "insert into question values(null, 2, \"What is a stack trace and why is it important?\");\n" + 
                    "insert into question values(null, 1, \"What is 5 x 5\");\n" +
                    "insert into question values(null, 1, \"How many flip flops does toby wear\");\n";
            
            stmt.executeUpdate(sql);
            System.out.println("Created and populated the question table");
        } catch (Exception e){ 
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        
        
    }
    
    public static void deleteAll(){
        Statement stmt = null;
        
        try{
            stmt = c.createStatement();
            String sql = "drop table question;\n" +
                    "drop table subject;\n";
            stmt.executeUpdate(sql);
        } catch (Exception e){
            
        }

    }
    
    public static void addQuestion(Question ques){
        Statement stmt = null;
        int numSubjects = 0;
        int numQuestions = 0;
        
        String question = ques.question;
        String subject = ques.subject;
        
        
        try{
//            // create the tables if they don't already exist
            stmt = c.createStatement();
//            String sql = "create table if not exists subject(ID integer primary key autoincrement, sub text not null unique);\n";
//            sql += "create table if not exists question(qID integer primary key autoincrement, sID int not null, ques text not null unique);\n";
//            stmt.executeUpdate(sql);
//          
            String sql = "";
            //find out if the subject related to the question exists already
            sql = "select ID from subject where sub = '"+subject+"';";
            // select * from subject where sub = 'algorithms');
            int subID = 0;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                subID = rs.getInt("ID");
            }
            
            
            //if the subject doesn't exist add it into the subject table
            if (subID == 0){
                sql = "insert into subject values (null, '"+subject+"');";
                // insert into table subject values (null, 'algorithms');
                stmt.executeUpdate(sql);
                
                // get newID now that it's added into the table
                sql = "select ID from subject where sub = '"+subject+"';";
                // select * from subject where sub = 'algorithms');
                rs = stmt.executeQuery(sql);
                subID = rs.getInt("ID");
            }
            //if the subject does exist, make sure the question isn't already in the dB
            else{
                sql = "select qID from question where sid = "+subID+" and ques = \""+question+"\";";
                //select qid from question where sid = 2 and ques = "What is a question?";
                int qID = 0;
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                    qID = rs.getInt("qID");
                }
                
                if(qID == 0){//if the question doesn't already exists
                     //use the subID to insert the question into the question table
                    sql = "insert into question values (null, "+subID+", '"+question+"');";
                    //insert into table question values (null, 4, 'How does DFS work?');
                    stmt.executeUpdate(sql);
                }
                else{
                    System.out.println("Question already added");
                }
                
            }
            
        } catch (Exception e){ 
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Added question successfully");
    }

    public static void main(String[] args) {
        createDB();
//        createPopTables();
        Question q = new Question();
        q.question = "What is the meaning of life?";
        q.subject = "Memes";
        addQuestion(q);
        
        
    }
    
}

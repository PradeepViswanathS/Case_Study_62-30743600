package com.cts.dao.ipml;

import com.cts.exceptions.ChoiceInvalidException;
import com.cts.model.DocumentModel;
import com.cts.service.DocumentService;
import com.cts.util.Databaseconnectiondetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Documentdao {

    Databaseconnectiondetails databaseConnections = new Databaseconnectiondetails();
    DocumentModel documentModel = new DocumentModel();

    public void addDoc() throws ChoiceInvalidException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter document title: ");
        documentModel.setTitle(sc.nextLine());
        System.out.print("Enter description: ");
        documentModel.setDes(sc.nextLine());
        System.out.print("Enter File Path: ");
        documentModel.setFilePath(sc.nextLine());
        System.out.print("Enter date(YYYY-MM-DD): ");
        documentModel.setDate(sc.nextLine());
        String query = "insert into documents(Title,Description,File_Path,Upload_Date) values(?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            //pst.setInt(1,docId);
            pst.setString(1,documentModel.getTitle());
            pst.setString(2,documentModel.getDes());
            pst.setString(3,documentModel.getFilePath());
            pst.setString(4, documentModel.getDate());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            DocumentService.options();}
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            DocumentService.options();
        }
    }
    //this function is written to view particular data.
    public void viewDoc() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Document Title: ");
        documentModel.setTitle(sc.nextLine());
        String query = "select * from documents where Title = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, documentModel.getTitle());
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.print(rs.getInt(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getString(3)+"  ");
            System.out.print(rs.getString(4)+"  ");
            System.out.println(rs.getDate(5)+"  ");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            DocumentService.options();}
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            DocumentService.options();
        }
    }
    //this function is written to update the table.
    public void updateDoc() throws ChoiceInvalidException {
        String prevName;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter updated document title: ");
        documentModel.setTitle(sc.nextLine());
        System.out.print("Enter updated description: ");
        documentModel.setDes(sc.nextLine());
        System.out.print("Enter updated Path: ");
        documentModel.setFilePath(sc.nextLine());
        System.out.print("Enter updated date(YYYY-MM-DD): ");
        documentModel.setDate(sc.nextLine());
        System.out.print("Enter Previous Title: ");
        prevName = sc.nextLine();
        String query = "Update documents set Title = ? , Description = ? , File_Path = ? , Upload_Date = ? where Title = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, documentModel.getTitle());
            pst.setString(2, documentModel.getDes());
            pst.setString(3, documentModel.getFilePath());
            pst.setString(4, documentModel.getDate());
            pst.setString(5,prevName);
            int rows = pst.executeUpdate();
            System.out.println(rows+" Rows Affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            DocumentService.options();}
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            DocumentService.options();
        }
    }
    //we can delete certatin rows using this function.
    public void deleteDoc() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Document Title: ");
        documentModel.setTitle(sc.nextLine());
        String query = "delete from documents where Title = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,documentModel.getTitle());
            int rows = pst.executeUpdate();
            System.out.println(rows+" Deleted");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            DocumentService.options();}
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            DocumentService.options();
        }
    }
    //this function is written to view all data in the table.
    public void viewAllDoc() throws ChoiceInvalidException {
        String query = "select * from documents";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();
            while(rs.getInt(1)!=0) {
                System.out.print(rs.getInt(1) + "  ");
                System.out.print(rs.getString(2) + "  ");
                System.out.print(rs.getString(3) + "  ");
                System.out.print(rs.getString(4) + "  ");
                System.out.println(rs.getDate(5) + "  ");
                rs.next();
            }
            con.close();
        }catch (Exception e){
            System.out.println("End Of Table");
        }
        try{
            DocumentService.options();}
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            DocumentService.options();
        }
    }
}

package com.cts.dao.ipml;

import com.cts.exceptions.ChoiceInvalidException;
import com.cts.model.CaseModel;
import com.cts.service.CaseService;
import com.cts.util.Databaseconnectiondetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Casedao {

    CaseModel caseModel = new CaseModel();
    Databaseconnectiondetails databaseConnections = new Databaseconnectiondetails();

    public void addCase() throws ChoiceInvalidException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Client Id: ");
        caseModel.setClientId(sc.nextInt());
        System.out.print("Enter Case Number: ");
        caseModel.setCaseNum(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter description: ");
        caseModel.setDes(sc.nextLine());
        System.out.print("Enter Case Status: ");
        caseModel.setStatus(sc.nextLine());
        System.out.print("Enter Case Open Date(YYYY-MM-DD): ");
        caseModel.setOpenDate(sc.nextLine());
        System.out.print("Enter Case Close Date(YYYY-MM-DD): ");
        caseModel.setCloseDate(sc.nextLine());
        String query = "insert into cases(Client_id,Case_num,Description,Status,Open_date,Close_date) values(?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,caseModel.getClientId());
            pst.setInt(2,caseModel.getCaseNum());
            pst.setString(3,caseModel.getDes());
            pst.setString(4,caseModel.getStatus());
            pst.setString(5,caseModel.getOpenDate());
            pst.setString(6,caseModel.getCloseDate());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            CaseService.options();
        }
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            CaseService.options();
        }
    }

    //this function is written to view particular data.

    public void viewCases() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Case Number: ");
        caseModel.setCaseNum(sc.nextInt());
        String query = "select * from cases where Case_num = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,caseModel.getCaseNum());
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.print(rs.getInt(1)+"  ");
            System.out.print(rs.getInt(2)+"  ");
            System.out.print(rs.getInt(3)+"  ");
            System.out.print(rs.getString(4)+"  ");
            System.out.print(rs.getString(5)+"  ");
            System.out.print(rs.getString(6)+"  ");
            System.out.println(rs.getString(7)+"  ");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            CaseService.options();
        }
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            CaseService.options();
        }
    }

    //this function is written to update the table.
    public void updateCase() throws ChoiceInvalidException {
        int caseId;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter updated Client ID: ");
        caseModel.setClientId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Updated Case Number: ");
        caseModel.setCaseNum(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Updated Description: ");
        caseModel.setDes(sc.nextLine());
        System.out.print("Enter Updated Status: ");
        caseModel.setStatus(sc.nextLine());
        System.out.print("Enter Updated Open Date(YYYY-MM-DD): ");
        caseModel.setOpenDate(sc.nextLine());
        System.out.print("Enter Updated Close Date(YYYY-MM-DD): ");
        caseModel.setCloseDate(sc.nextLine());
        System.out.print("Enter the Case Id that has to be updated: ");
        caseId = sc.nextInt();
        String query = "Update cases set Client_id = ? , Case_num = ? , Description = ? , Status = ? , Open_date= ? , Close_date = ? where Case_id = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,caseModel.getClientId());
            pst.setInt(2,caseModel.getCaseNum());
            pst.setString(3,caseModel.getDes());
            pst.setString(4,caseModel.getStatus());
            pst.setString(5,caseModel.getOpenDate());
            pst.setString(6,caseModel.getCloseDate());
            pst.setInt(7,caseId);
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            CaseService.options();
        }
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            CaseService.options();
        }

    }
    //we can delete certatin rows using this function.
    public void deleteCase() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter case number: ");
        caseModel.setCaseNum(sc.nextInt());
        String query = "delete from cases where Case_num = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,caseModel.getCaseNum());
            int rows = pst.executeUpdate();
            System.out.println(rows+" Deleted");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            CaseService.options();
        }
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            CaseService.options();
        }
    }
    //this function is written to view all data in the table.
    public void viewAllCases() throws ChoiceInvalidException {
        String query = "select * from cases";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();
            while(rs.getInt(1)!=0) {
                System.out.print(rs.getInt(1)+"  ");
                System.out.print(rs.getInt(2)+"  ");
                System.out.print(rs.getInt(3)+"  ");
                System.out.print(rs.getString(4)+"  ");
                System.out.print(rs.getString(5)+"  ");
                System.out.print(rs.getString(6)+"  ");
                System.out.println(rs.getString(7)+"  ");
                rs.next();
            }
            con.close();
        }catch (Exception e){
            System.out.println("End Of Table");
        }
        try {
            CaseService.options();
        }
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            CaseService.options();
        }
    }
}

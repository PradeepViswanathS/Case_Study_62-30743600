package com.cts.dao.ipml;

import com.cts.exceptions.ChoiceInvalidException;
import com.cts.model.ClientModel;
import com.cts.service.ClientService;
import com.cts.util.Databaseconnectiondetails;

import java.sql.*;
import java.util.Scanner;

public class Clientdao {

    Databaseconnectiondetails databaseConnections = new Databaseconnectiondetails();
    ClientModel clientModel = new ClientModel();


    public void addClient() throws ChoiceInvalidException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Client ID: ");
        clientModel.setClientId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter client name: ");
        clientModel.setName(sc.nextLine());
        System.out.print("Enter client Number: ");
        clientModel.setContact(sc.nextLine());
        System.out.print("Enter Email Id: ");
        clientModel.setEmail(sc.nextLine());
        System.out.print("Enter Address: ");
        clientModel.setAddress(sc.nextLine());
        String query = "insert into clients values(?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,clientModel.getClientId());
            pst.setString(2,clientModel.getName());
            pst.setString(3,clientModel.getContact());
            pst.setString(4, clientModel.getEmail());
            pst.setString(5,clientModel.getAddress());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            ClientService.options();
        }
        catch(ChoiceInvalidException E){
            System.out.println(E.getMessage());
            ClientService.options();
        }
    }
    //this function is written to view particular data.
    public void viewClients() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        clientModel.setName(sc.nextLine());
        String query = "select * from clients where Name = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,clientModel.getName());
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.print(rs.getInt(1)+"  ");
            System.out.print(rs.getString(2)+"  ");
            System.out.print(rs.getString(3)+"  ");
            System.out.print(rs.getString(4)+"  ");
            System.out.println(rs.getString(5)+"  ");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            ClientService.options();
        }
        catch(ChoiceInvalidException E){
            System.out.println(E.getMessage());
            ClientService.options();
        }
    }
    //this function is written to update the table.
    public void updateClient() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Client ID: ");
        clientModel.setClientId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Updated client name: ");
        clientModel.setName(sc.nextLine());
        System.out.print("Enter Updated client Number: ");
        clientModel.setContact(sc.nextLine());
        System.out.print("Enter Updated Email Id: ");
        clientModel.setEmail(sc.nextLine());
        System.out.print("Enter Updated Address: ");
        clientModel.setAddress(sc.nextLine());
        String query = "Update clients set Name = ? , Contact = ? , Email = ? , Address = ? where Client_id = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,clientModel.getName());
            pst.setString(2,clientModel.getContact());
            pst.setString(3,clientModel.getEmail());
            pst.setString(4,clientModel.getAddress());
            pst.setInt(5,clientModel.getClientId());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            ClientService.options();
        }
        catch(ChoiceInvalidException E){
            System.out.println(E.getMessage());
            ClientService.options();
        }

    }
    //we can delete certatin rows using this function.
    public void deleteClient() throws ChoiceInvalidException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter client Name: ");
        clientModel.setName(sc.nextLine());
        String query = "delete from clients where Name = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,clientModel.getName());
            int rows = pst.executeUpdate();
            System.out.println(rows+" Deleted");
            con.close();
        }
        catch (SQLIntegrityConstraintViolationException e){
            System.out.println("There are cases that are not closed for this client in cases table. Please close them to delete this client.");

        }
        catch (Exception e){

            System.out.println(e);
        }
        try {
            ClientService.options();
        }
        catch(ChoiceInvalidException E){
            System.out.println(E.getMessage());
            ClientService.options();
        }
    }
    //this function is written to view all data in the table.
    public void viewAllClient() throws ChoiceInvalidException {
        String query = "select * from clients";
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
                System.out.println(rs.getString(5) + "  ");
                rs.next();
            }
            con.close();
        }catch (Exception e){
            System.out.println("End Of Table");
        }
        try {
            ClientService.options();
        }
        catch(ChoiceInvalidException E){
            System.out.println(E.getMessage());
            ClientService.options();
        }
    }
}

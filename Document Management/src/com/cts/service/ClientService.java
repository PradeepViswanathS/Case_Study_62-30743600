package com.cts.service;

import com.cts.dao.ipml.Clientdao;
import com.cts.exceptions.ChoiceInvalidException;
import com.cts.main.Main;

import java.util.Scanner;

public class ClientService {
    public static void options() throws ChoiceInvalidException {
        int option;
        Clientdao clientDao =new Clientdao();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add new clients");
        System.out.println("2. View client details");
        System.out.println("3. Update client information");
        System.out.println("4. Delete client");
        System.out.println("5. View All clients");
        System.out.println("6. Exit");
        option = sc.nextInt();
        if(option>6){
            throw new ChoiceInvalidException("Enter valid input!!");
        }
        else {
            switch (option) {
                case 1:
                    clientDao.addClient();
                    break;
                case 2:
                    clientDao.viewClients();
                    break;
                case 3:
                    clientDao.updateClient();
                    break;
                case 4:
                    clientDao.deleteClient();
                    break;
                case 5:
                    clientDao.viewAllClient();
                    break;
                case 6:
                    try {
                        Main.begin();
                    }
                    catch(ChoiceInvalidException E){
                        System.out.println(E.getMessage());
                        Main.begin();
                    }
                    break;
                default:
                    System.out.println("Error");
                    options();
            }
        }
    }
}

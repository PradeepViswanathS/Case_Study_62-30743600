package com.cts.service;

import com.cts.dao.ipml.Documentdao;
import com.cts.exceptions.ChoiceInvalidException;
import com.cts.main.Main;

import java.util.Scanner;

public class DocumentService {
    public static void options() throws ChoiceInvalidException {
        int option;
        Documentdao documentDao = new Documentdao();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Upload new documents");
        System.out.println("2. View document details");
        System.out.println("3. Update document details");
        System.out.println("4. Delete documents");
        System.out.println("5. View all documents");
        System.out.println("6. Exit");
        option = sc.nextInt();
        if(option>6){
            throw new ChoiceInvalidException("Enter valid input!!");
        }
        else{
        switch(option){
            case 1:
                documentDao.addDoc();
                break;
            case 2:
                documentDao.viewDoc();
                break;
            case 3:
                documentDao.updateDoc();
                break;
            case 4:
                documentDao.deleteDoc();
                break;
            case 5:
                documentDao.viewAllDoc();
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

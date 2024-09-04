package com.cts.main;

import com.cts.exceptions.ChoiceInvalidException;
import com.cts.service.CaseService;
import com.cts.service.ClientService;
import com.cts.service.DocumentService;

import java.util.Scanner;

public class Main {
    //compile and run this main function to start the application.
    public static void main(String[] args) throws ChoiceInvalidException {
        try {
            begin();
        }
        catch (ChoiceInvalidException E){
            System.out.println(E.getMessage());
            begin();
        }

    }
    public static void begin() throws ChoiceInvalidException {
        int choice; //choice variable is used to get the choice from the user.
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Document Management-----------");
        System.out.println("1. Document Management");
        System.out.println("2. Client Management");
        System.out.println("3. Case Management");
        System.out.println("4. Close Application");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        if(choice > 4){
            throw new ChoiceInvalidException("Enter Valid Input!!");
        }

        //Switch case is used to navigate through the console.

        switch (choice){
          case 1:
              try{
                  DocumentService.options();}
              catch (ChoiceInvalidException E){
                  System.out.println(E.getMessage());
                  DocumentService.options();
              }
              break;
          case 2:
              try {
                  ClientService.options();
              }
              catch(ChoiceInvalidException E){
                  System.out.println(E.getMessage());
                  ClientService.options();
              }
              break;
          case 3:
              try {
                  CaseService.options();
              }
              catch (ChoiceInvalidException E){
                  System.out.println(E.getMessage());
                  CaseService.options();
              }
              break;
          case 4:
              System.out.println("-------------Application Closed-------------");
              break;
          default:
              System.out.println("Error");
              begin();
      }

    }
}



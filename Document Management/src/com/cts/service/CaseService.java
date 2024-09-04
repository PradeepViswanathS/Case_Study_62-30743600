package com.cts.service;

import com.cts.dao.ipml.Casedao;
import com.cts.exceptions.ChoiceInvalidException;
import com.cts.main.Main;

import java.util.Scanner;

public class CaseService {
    public static void options() throws ChoiceInvalidException {
        int option;
       Casedao caseDao = new Casedao();

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Create new cases");
        System.out.println("2. View case details");
        System.out.println("3. Update case information");
        System.out.println("4. Close case");
        System.out.println("5. View all cases");
        System.out.println("6. Exit");
        option = sc.nextInt();
        if(option>6){
            throw new ChoiceInvalidException("Enter valid input!!");
        }
        else {
            switch (option) {
                case 1:
                    caseDao.addCase();
                    break;
                case 2:
                    caseDao.viewCases();
                    break;
                case 3:
                    caseDao.updateCase();
                    break;
                case 4:
                    caseDao.deleteCase();
                    break;
                case 5:
                    caseDao.viewAllCases();
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

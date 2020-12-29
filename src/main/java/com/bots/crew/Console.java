package com.bots.crew;

import com.bots.crew.entity.Department;
import com.bots.crew.service.DepartmentService;
import com.bots.crew.service.LectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Console implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(Console.class);
    private final Scanner sc = new Scanner(System.in);
    private LectorService lectorService;
    private DepartmentService departmentService;


    @Autowired
    public Console(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    @Override
    public void run(String... args) throws Exception {
        menu();
    }

    private void menu() throws InterruptedException {
        int choose;
        String var;

        System.out.println("Choose command: \n" +
                "1. Who is head of department {department_name}\n" +
                "2. Show {department_name} statistics.\n" +
                "3. Show the average salary for the department {department_name}.\n" +
                "4. Show count of employee for {department_name}.\n" +
                "5  Global search by {template}.");

        if (sc.hasNextInt()) {
            choose = sc.nextInt();
        } else {
            choose = -1;
        }
        sc.nextLine();

        System.out.println("Enter the variable");
        var = sc.nextLine();

        switch (choose) {
            case 1:
                departmentService.getDepartmentHeadName(var);
                break;
            case 2:
                lectorService.getStatistic(var);
                break;
            case 3:
                lectorService.getAvgSalary(var);
                break;
            case 4:
                lectorService.getEmployeeCount(var);
                break;
            case 5:
                lectorService.search(var);
                departmentService.search(var);
                break;
            default:
                System.out.println("You entered wrong command");
        }
        Thread.sleep(3000);
        menu();
    }


}

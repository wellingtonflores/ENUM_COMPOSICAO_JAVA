package Exercicio1.app;

import Exercicio1.entities.Department;
import Exercicio1.entities.HourContract;
import Exercicio1.entities.Worker;
import Exercicio1.entities.enums.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        String depart = sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Level: ");
        String level = sc.nextLine();
        System.out.println("Base salary: ");
        double base_salary = sc.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), base_salary, new Department(depart));

        System.out.println("How many contracts to this worker? ");
        int contracts = sc.nextInt();

        for(int i = 0; i < contracts; i++){
            System.out.println("Enter contract #" + (i + 1) + " data:");
            System.out.println("Date (DD/MM/YYYY): ");
            String dateString = sc.next();
            LocalDate contractDate = LocalDate.parse(dateString, dtf);
            System.out.println("Value per hour: ");
            double value_per_hour = sc.nextDouble();
            System.out.println("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, hours, value_per_hour);
            worker.addContract(contract);
        }

        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + month + "/" + year + ": " + worker.income(month, year));
        sc.close();
    }
}

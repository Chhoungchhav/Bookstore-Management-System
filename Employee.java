package Bookstore_Management;

import java.time.Year;

public class Employee {
    private int employeeID, startYear, workYear, currentYear;
    private String name, emailAddress, position, startDate, year;
    private double maxSalary, salary;

    

    public Employee(int employeeID, String name, String emailAddress, String startDate, double salary){
        this.employeeID = employeeID;
        this.name = name;
        this.emailAddress = emailAddress;
        this.startDate = startDate;

        this.currentYear = Year.now().getValue();
        
        String dateParts[] = this.startDate.split("/");
        year = dateParts[2];

        startYear = Integer.parseInt(year);

        this.workYear = currentYear - startYear;
    }
    public void setSalary(double salary){
        if (workYear >= 10){
            this.maxSalary = salary*1.75;
        }

        else if (workYear >= 5){
            this.maxSalary = salary*1.5;
        }

        else if (workYear >= 3){
            this.maxSalary = salary*1.25;
        }

        else {
            this.maxSalary = salary;
        }
    }

    public int getEmployeeID(){
        return employeeID;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return emailAddress;
    }

    public double getSalary(){
        return maxSalary;
    }


    
}

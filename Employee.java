package Bookstore_Management;

import java.time.Year;

public class Employee {
    private int employeeID, startYear, workYear, currentYear;
    private String name, emailAddress, position, startDate, year;
    private double maxSalary, salary;

    

    public Employee(int employeeID, String name, String emailAddress, String startDate){
        this.employeeID = employeeID;
        this.name = name;
        this.emailAddress = emailAddress;
        this.startDate = startDate;

        this.currentYear = Year.now().getValue();
        
        String dateParts[] = this.startDate.split("/");
        year = dateParts[2];

        startYear = Integer.parseInt(year);

        this.workYear = currentYear - startYear;

        if (this.position.equals("manager")) {
            this.maxSalary = 400;
        }
        else if (this.position.equals("seller")){
            this.maxSalary = 200;
        }
    }

    public void setSalary(){
        if (workYear >= 10){
            salary = maxSalary;
        }

        else if (workYear >= 5){
            salary = maxSalary * 0.9;
        }

        else if (workYear >= 3){
            salary = maxSalary * 0.8;
        }

        else {
            salary = maxSalary * 0.7;
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
        return salary;
    }


    
}

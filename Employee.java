package Bookstore_Management;

import java.time.Year;

public class Employee {
    private int employeeID, startYear, workYear, currentYear;
    private String name, emailAddress, password, startDate, year;
    private double maxSalary, salary;

    

    public Employee(int employeeID, String name, String password, String emailAddress, String startDate){
        this.employeeID = employeeID;
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.startDate = startDate;

        this.currentYear = Year.now().getValue();
        
        String dateParts[] = this.startDate.split("-");
        year = dateParts[2];

        startYear = Integer.parseInt(year);

        this.workYear = currentYear - startYear;
    }

    public Employee(int employeeID, String password){
        this.employeeID = employeeID;
        this.password = password;
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

    @Override
    public boolean equals(Object obj) {
        Employee e1 = (Employee) obj;
       
        if( this.employeeID == e1.employeeID && this.password.equals(e1.password) )
        {
            return true;
        }
        return false;
    }
}

public class Manager extends Employee {
    final String position = "manager";
   private double salary = 350;
    
    public Manager(int employeeID, String name,String password, String emailAddress, String startDate){
        super(employeeID, name, password, emailAddress, startDate);
    }

    @Override
    public double getSalary() {
        return super.getSalary() * this.salary;
    }


    @Override
    public String toString() {
        String tmp = super.toString() + ", position: " + this.position;

        return tmp;
    }
    
    
}

package src.main.java;
public class Engineer extends Employee {

  public Engineer(int id, double monthlySalary) {
    super(id, monthlySalary);           
  }

  public double payAmount() {
    
    return getMonthlySalary();   
  }
  
  public String toString() {
    String s =      "Engineer, " + "id: " + getId() + ", " + "monthly salary: "
                            + getMonthlySalary();
    if (getManager()!=null) {
            s = s + ", " + "manager: " + getManager().getId();
    }
    s = s + ".\n";
    return s;
  }

}

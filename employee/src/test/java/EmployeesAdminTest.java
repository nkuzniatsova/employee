package src.test.java;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.Employee;
import src.main.java.EmployeesAdmin;
import src.main.java.Engineer;
import src.main.java.Manager;
import src.main.java.Salesman;

class EmployeesAdminTest {

  private static EmployeesAdmin empAdmin; 
  private static ArrayList<Employee> employees;  
  private static String employeesStr; // = ""; //To save String representation of employees for testing purposes
  
  @BeforeEach
  void setUp() throws Exception {
//Initial setUp, add some employees
    
    empAdmin = new EmployeesAdmin();
    employees = new ArrayList<Employee>();
    employeesStr = "";
    empAdmin.addEgineer(1, 1000.00);
    empAdmin.addEgineer(2, 2000.00);
    empAdmin.addSalesman(3, 3000.00, 300.00);
    empAdmin.addSalesman(4, 4000.00, 400.00);
    empAdmin.addManager(5, 5000.00, 500.00);
    empAdmin.addManager(6, 6000.00, 600.00); 
    
    employees = empAdmin.getEmployees();  //To save some typework replace empAdmin.getEmployees() with employees 
  }
  
  /** Verify that method addEngineer(), addSalesman(), addManager() works correct - 
   * for all employees correct data created
   **/
  @Test
  void verifyEmployeesDataTest() {
   
    assertTrue(employees.size() == 6);
    assertTrue(employees.get(0) instanceof Engineer);
    assertTrue(employees.get(1) instanceof Engineer);
    assertTrue(employees.get(0).getId() == 1);
    assertTrue(employees.get(1).getId() == 2);
    assertEquals(1000.00, employees.get(0).getMonthlySalary(), 0.0001);
    assertEquals(2000.00, employees.get(1).getMonthlySalary(), 0.0001);
    
    assertTrue(employees.get(2) instanceof Salesman);
    assertTrue(employees.get(3) instanceof Salesman);
    assertTrue(employees.get(2).getId() == 3);
    assertTrue(employees.get(3).getId() == 4);
    assertEquals(3000.00, employees.get(2).getMonthlySalary(), 0.0001);
    assertEquals(4000.00, employees.get(3).getMonthlySalary(), 0.0001);
    assertEquals(300.00, ((Salesman) employees.get(2)).getCommission(), 0.0001);
    assertEquals(400.00, ((Salesman) employees.get(3)).getCommission(), 0.0001);
    
    assertTrue(employees.get(4) instanceof Manager);
    assertTrue(employees.get(5) instanceof Manager);
    assertTrue(employees.get(4).getId() == 5);
    assertTrue(employees.get(5).getId() == 6);
    assertTrue(Math.abs(employees.get(4).getMonthlySalary() - 5000.00) <= 0.0001);
    assertTrue(Math.abs(employees.get(5).getMonthlySalary() - 6000.00) <= 0.0001);
    assertEquals(500.00, ((Manager) employees.get(4)).getBonus(), 0.0001);
    assertEquals(600.00, ((Manager) employees.get(5)).getBonus(), 0.0001);            
  }
  
  /** Verify it is not possible to add employee with already existing id */
  @Test
  public void addEmployeeTest() {
    
    assertTrue(empAdmin.addEgineer(7, 2200.00));
    assertFalse(empAdmin.addEgineer(1, 2300.00));
    assertTrue(empAdmin.addSalesman(8, 5200.00, 520));
    assertFalse(empAdmin.addSalesman(1, 5200.00, 520));
    assertTrue(empAdmin.addManager(9, 8200.00, 820));
    assertFalse(empAdmin.addManager(5, 8200.00, 820));
  }

  /** Verify that method getHighestId() works correct - the highest id will be returned */
  @Test
  void getHighestIdTest() {
  
    assertTrue(empAdmin.getHighestId() == 6);    
    empAdmin.getEmployees().remove(5);
    assertTrue(empAdmin.getHighestId() == 5);
    empAdmin.getEmployees().clear();
    assertTrue(empAdmin.getHighestId() == -1);      
  }
  
  /** Verify that method calcTotalPayAmount() works correct */
  @Test
  void calcTotalPayAmountTest() {
    
	assertEquals(22800.00, empAdmin.calcTotalPayAmount(), 0.0001);
    empAdmin.getEmployees().remove(2);
    empAdmin.getEmployees().remove(3);
    assertEquals(14000.00, empAdmin.calcTotalPayAmount(), 0.0001);
    empAdmin.getEmployees().clear();
    assertEquals(0.00, empAdmin.calcTotalPayAmount(), 0.0001);   
  }
  
  /** Verify that method toString() works correct - the correct string representation 
   * for all employee types is shown
   **/
  @Test
  void toStringTest() {
    
    employeesStr = employees.get(0).toString() + employees.get(1).toString() + employees.get(2).toString() + employees.get(3).toString() + employees.get(4).toString() + employees.get(5).toString(); 
    assertEquals(employeesStr, empAdmin.toString());   
    empAdmin.setManager(1,4);
    empAdmin.setManager(2,5);
    empAdmin.setManager(4,5);
    //works also with Manager
    employees = empAdmin.getEmployees();
    employeesStr = employees.get(0).toString() + employees.get(1).toString() + employees.get(2).toString() + employees.get(3).toString() + employees.get(4).toString() + employees.get(5).toString(); 
    assertEquals(employeesStr, empAdmin.toString());
    empAdmin.getEmployees().clear();
    assertEquals("", empAdmin.toString());     
  }
  
  /** Verify that method setManager() works correct */
  @Test
  void setManagerTest() {
    
    assertTrue(empAdmin.setManager(1,5));
    assertTrue(empAdmin.setManager(2,6));
    assertTrue(empAdmin.setManager(4,5));
    assertFalse(empAdmin.setManager(1,3)); //Set Salesman as Manager
    assertFalse(empAdmin.setManager(2,1)); //Set Engineer as Manager
    assertFalse(empAdmin.setManager(4,2)); //Set Salesman as Manager
    assertFalse(empAdmin.setManager(1,10)); //Not existing id
  }
  
}

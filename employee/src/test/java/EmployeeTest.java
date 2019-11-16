package src.test.java;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import src.main.java.Employee;
import src.main.java.Engineer;
import src.main.java.Manager;
import src.main.java.Salesman;

/**Test class contains tests for class Employee and it subclasses Engineer, Salesman, Manager*/
class EmployeeTest extends TestCase {
  private static Engineer empEngineer;
  private static Salesman empSalesman;
  private static Manager empManager;

  @BeforeEach
  protected void setUp() throws Exception {   
    super.setUp();
    empEngineer = new Engineer(1, 5000.00);
    empSalesman = new Salesman(2, 6000.00, 600.00);
    empManager = new Manager(3, 7000.00, 770.00);
  }
  

  @AfterEach
  protected void tearDown() throws Exception {
    super.tearDown();
  }
  
  /**Test Employee data correctness and toString() method - correct representation of employee data will be shown
   **/
  @Test
  void employeeDataTest() {     
    
    assertEquals("Engineer, id: 1, monthly salary: 5000.0.\n", empEngineer.toString());
    assertEquals("Salesman, id: 2, monthly salary: 6000.0, commission: 600.0.\n", empSalesman.toString());
    assertEquals("Manager, id: 3, monthly salary: 7000.0, bonus: 770.0.\n", empManager.toString());
    
    //Test now with manager added
    empEngineer.setManager(empManager);
    empSalesman.setManager(empManager);
    empManager.setManager(empManager);    
    assertEquals("Engineer, id: 1, monthly salary: 5000.0, manager: 3.\n", empEngineer.toString());
    assertEquals("Salesman, id: 2, monthly salary: 6000.0, commission: 600.0, manager: 3.\n", empSalesman.toString());
    assertEquals("Manager, id: 3, monthly salary: 7000.0, bonus: 770.0, manager: 3.\n", empManager.toString());
    empManager.setManager(empEngineer);
    
  }
  
  /** Test that method setManager works correct for all types of Employees*/
  @Test
  void setManagerTest( ) {
    
    assertFalse(empEngineer.setManager(empSalesman));
    assertFalse(empSalesman.setManager(empEngineer));
    assertFalse(empManager.setManager(empSalesman));
    assertTrue(empEngineer.setManager(empManager));
    assertTrue(empSalesman.setManager(empManager));
    assertTrue(empManager.setManager(empManager));    
  }
  
  /** Test that payAmount() method works correct for different types of Employees */
  @Test
  void payAmountTest() {
	assertEquals(5000.00, empEngineer.payAmount(), 0.0001);
	assertEquals(6600.00, empSalesman.payAmount(), 0.0001);
	assertEquals(7770.00, empManager.payAmount(), 0.0001);
  }
  
  /** Test that hashCode() method works correct for different types of Employees */
  @Test
  void hashCodeTest() {
    assertEquals(empEngineer.hashCode(), 1);
    assertEquals(empSalesman.hashCode(), 2);
    assertEquals(empManager.hashCode(), 3);
  }

  /** Test that equals() method works correct for different types of Employees */
  @Test
  void equalsTest() {
    assertFalse(empEngineer.equals(empManager));
    assertFalse(empEngineer.equals(empSalesman));
    assertFalse(empManager.equals(empSalesman));
    Employee salesman = new Salesman(1, 6100.00, 610.00);
    assertTrue(empEngineer.equals(salesman));
  }
  
}

package src.main.java;
public class EmployeesAdminMain {

	private EmployeesAdmin es = null;
	
	public void init() {
	   es = new EmployeesAdmin();
	   es.addEgineer(1, 1000.00); 
	   es.addEgineer(2, 2000.00);
	   es.addEgineer(1, 3000.00);
	   es.addSalesman(3, 4000.00, 100.00);
	   es.addManager(4, 5000.00, 1000.00);
	   
	   es.setManager(1,4);
           es.setManager(2,4);
           es.setManager(3,4);            
	}
	
	public void testEmployees() {	                           
       System.out.println(es.toString());
	}
	
	public static void main(String[] args) {
	 EmployeesAdminMain te = new EmployeesAdminMain();	
	 te.init();
	 te.testEmployees();
	}

}

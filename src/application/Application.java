package application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.Department;
import controller.Employee;

public class Application {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();

		Department dept1 = new Department(1001, "Sales", "New Delhi");
		Department dept2 = new Department(1002, "HR Department", "Noida");
		Department dept3 = new Department(1003, "Cyber Security", "Greater Noida");
		Department dept4 = new Department(1004, "Software", "Ohkla");

		Employee emp1 = new Employee(dept1, 1, "Kukil Bora", "Sales Manager", 12356, 350000.0);
		Employee emp2 = new Employee(dept1, 1, "Divyanshu Shukla", "Sales Manager", 1251356, 450000.0);
		Employee emp3 = new Employee(dept1, 1, "Reena Choudhary", "Sales Executive", 7812356, 850000.0);
		Employee emp4 = new Employee(dept1, 1, "Tower Of Hanoi", "Sales Manager", 8512356, 350000.0);
		
		Employee emp5 = new Employee(dept2, 1, "Anubhav Sisodia", "Personnel Assistant", 982356, 600000.0);
		Employee emp6 = new Employee(dept2, 1, "Adeeb Amer", "Business Partner", 9812356, 650000.0);
		Employee emp7 = new Employee(dept2, 1, "Abdulla Khan", "HR Generalist", 7812356, 250000.0);
		Employee emp8 = new Employee(dept2, 1, "Utkarsh Chor", "Branch Manager", 12987356, 150000.0);
		
		Employee emp9 = new Employee(dept3, 1, "Reshab Joshi", "CTO", 12378756, 850000.0);
		Employee emp10 = new Employee(dept3, 1, "Manshi Tanwar", "BM", 1235776, 650000.0);
		Employee emp11 = new Employee(dept3, 1, "Sonu Paswan", "BE", 12357786, 450000.0);
		Employee emp12 = new Employee(dept3, 1, "Rameshwar Paswan", "BH", 12357886, 300000.0);
		
		Employee emp13 = new Employee(dept4, 1, "Samad Khan", "Java Developer", 8512356, 550000.0);
		Employee emp14 = new Employee(dept4, 1, "Abdul Hetawat", "Sotware Developer", 5812356, 650000.0);
		Employee emp15 = new Employee(dept4, 1, "Navinder Singh", "Senior Engineer", 5712356, 950000.0);
		Employee emp16 = new Employee(dept4, 1, "Ankush Dhiman", "Java Developer", 6212356, 150000.0);
		
//		emp.setId(1);
//		emp.setName("Navinder Singh");
//		emp.setDesignation("Head Executive");
//		emp.setContact(99546509);
//		emp.setSalary(25000.0);
//		emp.setDept(dept0);

		Transaction tx = session.beginTransaction();
		session.save(dept1);
		session.save(dept2);
		session.save(dept3);
		session.save(dept4);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		session.save(emp7);
		session.save(emp8);
		session.save(emp9);
		session.save(emp10);
		session.save(emp11);
		session.save(emp12);
		session.save(emp13);
		session.save(emp14);
		session.save(emp15);
		session.save(emp16);
		tx.commit();
		session.close();
		fact.close();
	}
}

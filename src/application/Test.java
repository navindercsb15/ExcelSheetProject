
package application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		
		
//		Person p = new Person(1, "Navinder", "Tezpur");
//		Person p2 = new Person(2, "Rishab", "Noida");
//		Person p3 = new Person(3, "Kukil", "New Delhi");
//		
//		HashMap<Long, Object> obj = new HashMap<Long, Object>();
// 		
//		obj.put(1L, p);
//		obj.put(2L, p2);
//		obj.put(3L, p3);
//		
//		for (HashMap.Entry<Long, Object> string : obj.entrySet()) {
//			Person per =(Person)string.getValue();
//			System.out.println("Key:"+string.getKey());
//			System.out.println("Person Id:"+per.getId());
//			System.out.println("Person Name :"+per.getName());
//			System.out.println("Persom City: "+per.getCity());
//			System.out.println("-----------------------------------------");
//		}
		
			
	Session session = new Configuration().addResource("hibernate.hbm.xml").buildSessionFactory().openSession();
	Company c = new Company("amazon1", "a1mazon", "Delhi");
	Student s = new Student("mansi", "Mansi", "Barielly");
	
	Transaction tx = session.beginTransaction();
	session.save(c);
	session.save(s);
	tx.commit();
	session.getSessionFactory().close();
	
	
	
//	Map<String, String> list = new LinkedHashMap<>();
//	
//	list.put("1", "Navinder");
//	
//	for (Map.Entry<String, String> e : list.entrySet()) {
//		System.out.println(e.getKey());
//		System.out.println();
//	}
		
		
		
		
	}
}

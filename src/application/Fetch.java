package application;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import controller.Department;
import controller.Employee;
import sendmail.SendMail;

public class Fetch {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Department.class).addAnnotatedClass(Employee.class);
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();

		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from controller.Department");
		@SuppressWarnings("unchecked")
		List<Department> dept = query.list();

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		
		System.out.println(dept.size());
		XSSFSheet sales = workbook.createSheet("Sales");
		XSSFSheet HR_Department = workbook.createSheet("HR Department");
		XSSFSheet cyber = workbook.createSheet("Cyber Security");
		XSSFSheet software = workbook.createSheet("Software");
		Font font = sales.getWorkbook().createFont();
		font.setFontName ( "Arial" );
	    font.setBoldweight ( Font.COLOR_RED);
	    font.setColor ( HSSFColor.WHITE.index );
	    final CellStyle style = sales.getWorkbook ().createCellStyle ();
	    style.setFont ( font );
	    style.setFillForegroundColor ( HSSFColor.BLACK.index );
	    style.setFillPattern ( PatternFormatting.DIAMONDS );
		
		Map<String, Object[]> data1 = new LinkedHashMap<String, Object[]>();
		Map<String, Object[]> data2 = new LinkedHashMap<String, Object[]>();
		Map<String, Object[]> data3 = new LinkedHashMap<String, Object[]>();
		Map<String, Object[]> data4 = new LinkedHashMap<String, Object[]>();
		data1.put("0", new Object[] { "Employee_Id", "Name", "Designation" ,"Contact", "Salary" ,"Department"});
		data2.put("0", new Object[] { "Employee_Id", "Name", "Designation" ,"Contact", "Salary" ,"Department"});
		data3.put("0", new Object[] { "Employee_Id", "Name", "Designation" ,"Contact", "Salary" ,"Department"});
		data4.put("0", new Object[] { "Employee_Id", "Name", "Designation" ,"Contact", "Salary" ,"Department"});
		
		
		for (Department d : dept) {
			Set<Employee> emp = d.getEmployees();
			for (Employee e : emp) {
				if(d.getId()==1001) {
				data1.put(Integer.toString(e.getId()), new Object[] {e.getId(), e.getName(), e.getDesignation(), e.getContact(),e.getSalary(),d.getId()});
			}
				else if(d.getId()==1002) {
					data2.put(Integer.toString(e.getId()), new Object[] {e.getId(), e.getName(), e.getDesignation(), e.getContact(),e.getSalary(),d.getId()});
				}
				else if(d.getId()==1003) {
					data3.put(Integer.toString(e.getId()), new Object[] {e.getId(), e.getName(), e.getDesignation(), e.getContact(),e.getSalary(),d.getId()});
				}
				else if(d.getId()==1004) {
					data4.put(Integer.toString(e.getId()), new Object[] {e.getId(), e.getName(), e.getDesignation(), e.getContact(),e.getSalary(),d.getId()});
				}
			}
		}
		System.out.println(data1);
		int rownum = 0;
		int cellnum;
		Set<String> keyset = data1.keySet();
		for (String key : keyset) {
			Row row = sales.createRow(rownum++);
			Object[] objArr = data1.get(key);
			cellnum= 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				}
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
			}
		}
		
		rownum = 0;
		Set<String> keyset1 = data2.keySet();
		for (String key : keyset1) {
			Row row = HR_Department.createRow(rownum++);
			Object[] objArr = data2.get(key);
			cellnum= 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
			}
		}
		rownum = 0;
		Set<String> keyset2 = data3.keySet();
		for (String key : keyset2) {
			Row row = cyber.createRow(rownum++);
			Object[] objArr = data3.get(key);
			cellnum= 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
			}
		}
		rownum = 0;
		Set<String> keyset3 = data4.keySet();
		for (String key : keyset3) {
			Row row = software.createRow(rownum++);
			Object[] objArr = data4.get(key);
			cellnum= 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
				else if (obj instanceof Long)
					cell.setCellValue((Long) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("d:/EmployeeDetails.xls"));
			workbook.write(out);
			out.close();
			JOptionPane.showMessageDialog(null, "ExcelSheet Successfully Generated", "Message" ,1, null);
			int choice = JOptionPane.showConfirmDialog(null, "Do You want to mail the ExcelSheet?");
			System.out.println(choice);
			if(choice==0) {
			String email = JOptionPane.showInputDialog("Enter Your Email Id");
			SendMail.send_mail("d:/EmployeeDetails.xls", email);
			JOptionPane.showMessageDialog(null, "Attachment of the Excelsheet has been sent to Your Email Id : "+email, "Message" ,1, null);
			}
			else {
				JOptionPane.showMessageDialog(null, "Program Terminated", "Message" ,1, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		fact.close();
		
	}
}

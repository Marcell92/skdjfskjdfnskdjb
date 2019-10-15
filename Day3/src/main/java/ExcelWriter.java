import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExcelWriter {

	public static void ExcelGenerator() throws IOException, InvalidFormatException {

		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Employees");
		
		String[] columns = {"Name", "Passwd"};
		
		List<Employee> employees =  new ArrayList<Employee>();
		
		Row headerRow = sheet.createRow(0);
		
		employees.add(new Employee ("Marci", Password.getpasswd()));
		employees.add(new Employee ("Nabeel", Password.getpasswd()));
		
        
        for(int i = 0; i < columns.length; i++) {
        	
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
		
        int rowNum = 1;
        
        for (Employee employee : employees) {
        	
        	Row row = sheet.createRow(rowNum++);
        	
        	row.createCell(0).setCellValue(employee.getName());
        	
        	row.createCell(1).setCellValue(employee.getPasswd());
        	
 
        }
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\MyFolder\\employees.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		workbook.close();
	}
}

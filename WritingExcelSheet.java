package programming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
class Student{
	public int rollNo;
	public String name;
	
	public Student(int rollNo, String name)
	{
		this.rollNo = rollNo;
		this.name = name;
		
	}
}
public class ExcelSheetWrighting {

	public static void main(String[] args) throws IOException {
		File file = new File(System.getProperty("user.dir")+"/DataFolder/Sample2.xlsx");
		System.out.println(file.exists());
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet  = wb.getSheetAt(0);
		fis.close();
		Row row =sheet.createRow(3);
		row.createCell(2).setCellValue("hi");
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		fos.close();
		
		
		
		
		
		
	}
}

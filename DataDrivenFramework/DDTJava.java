package DataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDTJava {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\A579096\\Desktop\\Selenium\\LoginDetails.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
	XSSFSheet sheet=wb.getSheet("loginSheet");
	for(int i=1;i<sheet.getLastRowNum();i++)
	{
		XSSFRow row=sheet.getRow(i);
		XSSFCell cell=sheet.getRow(i).getCell(1);
		cell.setCellType(CellType.STRING);
		
		
		
		/*String value=cell.getStringCellValue();
		System.out.println("value of cell is "+value);
		
		int rowCount=wb.getSheet("loginSheet").getLastRowNum();
		System.out.println("row count is "+rowCount);
		
		int cellCount=wb.getSheet("loginSheet").getRow(3).getLastCellNum();
		System.out.println("column number"+cellCount);  */
		
		
		
	}
		
		
		
		
	}

}

package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Excel
{
	public static String data;
	public static Cell c;
	public static XSSFCell cell;
	
	public static String importDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\KOLONIZERDELL\\Desktop\\kolonizer\\automation_testing_crm\\Excel\\Test data for CRM.xlsx");
		Sheet s=WorkbookFactory.create(file).getSheet(sheet);
				
				 c = s.getRow(row).getCell(cell);
				 CellType dataType=c.getCellType();

					if (dataType==CellType.STRING)
					{
						data=c.getStringCellValue();
					
					}
					else if (dataType==CellType.NUMERIC)
					{
						double dataDouble=c.getNumericCellValue();
						data = String.valueOf(dataDouble);
						
					}
					else if (dataType==CellType.BLANK)
					{
						System.out.println("NULL");
					}
					
					return data;
		}
	
	public static void exportData(String sheetName, int rowNumber, int cellNumber, String data) throws Exception 
	{
//		String excelPath = "C:\\Users\\KOLONIZERDELL\\Desktop\\kolonizer\\CRM\\Stock_Market\\Excel\\SHARES.xlsx";
		File file = new File("C:\\Users\\KOLONIZERDELL\\Desktop\\kolonizer\\CRM\\Stock_Market\\Excel\\SHARES.xlsx");		

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb =new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		XSSFRow row=sheet.getRow(rowNumber);
	
		if (row==null)
		{
		     cell=sheet.createRow(rowNumber).createCell(cellNumber);
		     cell.setCellValue(data);
		    
		}
		else
		{
			cell = row.getCell(cellNumber);
			if (cell==null)
			{
				cell=row.createCell(cellNumber);
				cell.setCellValue(data);
			}
			else
			{
				cell.setCellValue(data);
			}
					
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		
		fos.close();
		wb.close();
		
	}
}

		
		
	
		
	



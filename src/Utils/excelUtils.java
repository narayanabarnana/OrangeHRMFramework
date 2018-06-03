package Utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {


	public excelUtils() {
		System.out.println("Excel Utility booting completed");}
	

	
	@SuppressWarnings({ "deprecation", "static-access" })
	public String[][] getCellData(String filepath,String filename,String sheetName) throws Exception
	{
		File file = new File (filepath+"//"+filename);
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=null;
		
		String fileExtensionName=filename.substring(filename.indexOf("."));
		if (fileExtensionName.equalsIgnoreCase(".xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
		}
		else if (fileExtensionName.equalsIgnoreCase(".xls"))
		{
			workbook=new HSSFWorkbook(fis);
		}
		Sheet sheet= workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		  int cellcount = sheet.getRow(0).getLastCellNum();
		  String data[][] = new String[rowcount][cellcount];
		
		  for (int i = 1; i <= rowcount; i++) {
		   
			  Row r = sheet.getRow(i);
		   
		  for (int j = 0; j<cellcount; j++) {
		   
			   Cell c = r.getCell(j);
		try {
			if (c.getCellType() == c.CELL_TYPE_STRING) {

		
		      data[i - 1][j] = c.getStringCellValue();
		} 
		else
		 {
		      data[i - 1][j] = String.valueOf(c.getNumericCellValue());
		}
		} catch (Exception e) {
		     e.printStackTrace();
		}}}
		  return data;

	}
	
	
}

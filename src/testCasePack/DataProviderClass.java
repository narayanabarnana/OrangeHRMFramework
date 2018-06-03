package testCasePack;

import java.util.Properties;
import org.testng.annotations.DataProvider;
import Utils.CommonConfig;
import Utils.excelUtils;

public class DataProviderClass  {
	public excelUtils read;
	public Properties configProperty;
	public String dataSheet_filepath;


	public DataProviderClass() throws Exception
	{
		configProperty=CommonConfig.getProperty("//Users//agnibhaghosh//Downloads//GIT//src//Configuration//config.properties");	
		dataSheet_filepath=configProperty.getProperty("Data_filepath");
		read = new excelUtils();

	}
	
	
	@DataProvider(name="getData")
	public String[][] getExcelData() throws Exception{
	
		String filename="BDMApplication.xlsx";
		String sheetName="search_shipment";
	return read.getCellData( dataSheet_filepath, filename,sheetName);
	}
	 

}

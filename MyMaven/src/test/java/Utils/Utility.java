package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void saveScreenShot(WebDriver driver,int testId) throws IOException {
		Date date=new Date();
		
		String time = date.toString().replace(":","_");

		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File d=new File("C:/Users/hp/OneDrive/Desktop/New folder/FailTestCase"+testId+" "+time+".jpg");
		
		FileHandler.copy(s, d);
		
	}

	
	public static String getDataFromDataSheet(WebDriver driver,int row,int cell) throws EncryptedDocumentException, IOException {
		String data;
		
		FileInputStream excel = new FileInputStream("C:/Users/hp/OneDrive/Desktop/Amazon_id.XLSX");

		Sheet outData = WorkbookFactory.create(excel).getSheet("Sheet1");
		
		try {
			
			data=outData.getRow(row).getCell(cell).getStringCellValue();
			
		}
		catch(IllegalStateException e) {
			
			long value=(long) outData.getRow(row).getCell(cell).getNumericCellValue();
					
			
			 data=(""+value);
			
		}
		
		return data;
		
	}


}

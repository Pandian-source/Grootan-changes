package Grootan;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import Xpath.xpathdetails;

public class Junierengineer extends Browser  {

	@Test
	public void Engineer () throws IOException, InterruptedException, InvalidFormatException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		File file = new File (Exceldata);
		FileInputStream inputStream = new FileInputStream(file); 
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);	
		@SuppressWarnings("unused")
		CreationHelper createHelper = wb.getCreationHelper();
		XSSFSheet sheet = wb.getSheet("JuniorEngineers");

		PageFactory.initElements(driver,xpathdetails.class);

		xpathdetails.team.click();

		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

		Class<?> Beforexpath = Class.forName("Xpath.xpathdetails");
		Field Beforexpathfield = Beforexpath.getDeclaredField("beforeXpath");
		Beforexpathfield.setAccessible(true);
		Object object = Beforexpathfield.get(new xpathdetails());
		String result = (String)object;

		Class<?> Afterxpath = Class.forName("Xpath.xpathdetails");
		Field afterxapthfield = Afterxpath.getDeclaredField("afterXpath");
		afterxapthfield.setAccessible(true);
		Object Path = afterxapthfield.get(new xpathdetails());
		String Finalpath = (String)Path;
		
		List<WebElement> name = xpathdetails.juniercount;
		System.out.println("Name count is = "+ name.size());
		int namecount = name.size();

		for (int i=1; i<=namecount; i++)
		{

			XSSFRow rowValue = sheet.createRow(i);
			{

                String actualXpath = result+i+Finalpath;
                String Element = driver.findElement(By.xpath(actualXpath)).getText();
				System.out.println(Element);
				rowValue.createCell(0).setCellValue(Element);
				rowValue.createCell(1).setCellValue(Element +" "+"Name printed successfully");
           }
	  }
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		
	}

}






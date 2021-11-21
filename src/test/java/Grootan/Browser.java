package Grootan;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Browser {

	public static String Exceldata = "./Exceldata/Excel Report.xlsx";
	public static WebDriver driver;


	@BeforeSuite
	public void browser() throws IOException
	{
		File file = new File (Exceldata);
		FileInputStream inputStream = new FileInputStream(file); 
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);	
		@SuppressWarnings("unused")
		CreationHelper createHelper = wb.getCreationHelper();
		XSSFSheet sheet = wb.getSheet("configuration");
		String browsertest = (sheet.getRow(1).getCell(0).getStringCellValue());
		System.out.println(browsertest);
		if(browsertest.equalsIgnoreCase("chrome"))
		{  
			try
			{
				System.setProperty("webdriver.chrome.driver" , "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				String fSize = (sheet.getRow(1).getCell(2).getStringCellValue());
				Dimension fDmn = new Dimension(Integer.valueOf(fSize.split("\\*")[0]), Integer.valueOf(fSize.split("\\*")[1]));
				driver.manage().window().setSize(fDmn);
				driver.get((sheet.getRow(1).getCell(1).getStringCellValue()));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				System.out.println("Chrome browser started");
			}
			catch (Exception e)
			{
				System.out.println(e.getStackTrace());
			}  
		}
		else if(browsertest.equalsIgnoreCase("IE"))
		{ 
			try
			{   
				System.setProperty("webdriver.ie.driver" , "./Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				String fSize = (sheet.getRow(1).getCell(2).getStringCellValue());
				Dimension fDmn = new Dimension(Integer.valueOf(fSize.split("\\*")[0]), Integer.valueOf(fSize.split("\\*")[1]));
				driver.manage().window().setSize(fDmn);
				driver.get((sheet.getRow(1).getCell(1).getStringCellValue()));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				System.out.println("IE browser started");
			}
			catch (Exception e)
			{
				System.out.println(e.getStackTrace());
			}  
		}

		else if(browsertest.equalsIgnoreCase("Firefox"))
		{
			try
			{
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				String fSize = (sheet.getRow(1).getCell(2).getStringCellValue());
				Dimension fDmn = new Dimension(Integer.valueOf(fSize.split("\\*")[0]), Integer.valueOf(fSize.split("\\*")[1]));
				driver.manage().window().setSize(fDmn);
				driver.get((sheet.getRow(1).getCell(1).getStringCellValue()));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				System.out.println("Firefox browser started");
			}
			catch (Exception e)
			{
				System.out.println(e.getStackTrace());
			}  
		} } 
	@AfterSuite
	public void closebrowser()
	{
		driver.close();
		System.out.println("Browser has closed");
	}

}





















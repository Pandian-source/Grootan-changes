package Grootan;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Xpath.xpathdetails;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Imagecompare extends Browser {
	
	@SuppressWarnings("unused")
	@Test
	public void comparison () throws IOException, InterruptedException
	{
		File Directory = new File ("Comparison");
		Directory.mkdir();
		File file = new File (Exceldata);
		FileInputStream inputStream = new FileInputStream(file); 
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);	
		@SuppressWarnings("unused")
		CreationHelper createHelper = wb.getCreationHelper();
		XSSFSheet sheet = wb.getSheet("TSR");

		
		PageFactory.initElements(driver,xpathdetails.class);

		xpathdetails.team.click();
		WebDriverWait wait =new WebDriverWait(driver,100);
		WebElement CTOIMAGEVisible = wait.until(ExpectedConditions.visibilityOf(xpathdetails.CTOimage));
		Screenshot CTOIMAGE = new AShot().takeScreenshot(driver,CTOIMAGEVisible);
		ImageIO.write(CTOIMAGE.getImage(),"png",new File("./Comparison/CTO.png"));
		File CTOPATH= new File ("./Comparison/CTO.png");
		String CTO = CTOPATH.getAbsolutePath();
		
		
		WebElement HRIMAGEVisible = wait.until(ExpectedConditions.visibilityOf(xpathdetails.HRimage));
		Screenshot HRIMAGE = new AShot().takeScreenshot(driver,HRIMAGEVisible);
		ImageIO.write(HRIMAGE.getImage(),"png",new File("./Comparison/HR.png"));
		File HRPATH = new File ("./Comparison/HR.png");
		String HR = HRPATH.getAbsolutePath();
		
		if(CTOPATH.exists())
		{
			if (HRPATH.exists())
			{
			System.out.println("Image File captured ");
		}}
		else
		{
			System.out.println("Image file not captured ");
		}
		
		BufferedImage expectedImage = ImageIO.read(new File("./Comparison/CTO.png"));
		BufferedImage actualImage = HRIMAGE.getImage();
		ImageDiffer imDiff = new ImageDiffer();
		ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
		for (int i=15; i<=15; i++)
		{
		   XSSFRow rowValue = sheet.createRow(i);
		    {
		   if(diff.hasDiff()==true)
		     {
			   rowValue.createCell(0).setCellValue("Images are not same");
			   rowValue.createCell(1).setCellValue("FAIL");
			   rowValue.createCell(2).setCellValue(CTO);
			 }
		   else
		   {
			   rowValue.createCell(0).setCellValue("Images are same");
			   rowValue.createCell(1).setCellValue("PASS");
			   rowValue.createCell(2).setCellValue(CTO);
		   }}}
		   FileOutputStream outputStream = new FileOutputStream (file);
		   wb.write(outputStream);	 
	}
}
		
		

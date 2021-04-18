package Grootan;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Xpath.xpathdetails;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Grootancode extends Browser {

	@Test
	public void headers () throws IOException, InterruptedException
	{
		for (int i=0; i<=1; i++)
		{
			File file = new File (Exceldata);
			FileInputStream inputStream = new FileInputStream(file); 
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);	
			@SuppressWarnings("unused")
			CreationHelper createHelper = wb.getCreationHelper();
			XSSFSheet sheet = wb.getSheet("TSR");

			PageFactory.initElements(driver,xpathdetails.class);

			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
			xpathdetails.Home.click();
			Screenshot Home = new AShot().takeScreenshot(driver);

			if(i==0)
			{
				File Directory = new File ("Folder 1");
				Directory.mkdir();
				ImageIO.write(Home.getImage(),"png",new File("./Folder 1/Home.png"));
				File f1 = new File ("./Folder 1/Home.png");
				String Homepathone = f1.getAbsolutePath();
				if(f1.exists())
				{
					XSSFCell HOM1 = sheet.createRow(1).createCell(0);
					HOM1.setCellValue("Home label clicked and taken screenshot");
					XSSFCell HOM2 = sheet.getRow(1).createCell(1);
					HOM2.setCellValue("Pass");
					XSSFCell HOM3 = sheet.getRow(1).createCell(2);
					HOM3.setCellValue(Homepathone);
				}
				else
				{
					XSSFCell HOM1 = sheet.createRow(1).createCell(0);
					HOM1.setCellValue("Home label not clicked");
					XSSFCell HOM2 = sheet.getRow(1).createCell(1);
					HOM2.setCellValue("Fail");
					XSSFCell HOM3 = sheet.getRow(1).createCell(2);
					HOM3.setCellValue(Homepathone);
				}
			}
			else if(i==1)
			{
				File Directory = new File ("Folder 2");
				Directory.mkdir();
				ImageIO.write(Home.getImage(),"png",new File("./Folder 2/Home.png"));
				BufferedImage actualImage = Home.getImage();
				File f1 = new File ("./Folder 2/Home.png");
				String Homepathtwo = f1.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Home.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell HOM1 = sheet.createRow(8).createCell(0);
					HOM1.setCellValue("Images are not same");
					XSSFCell HOM2 = sheet.getRow(8).createCell(1);
					HOM2.setCellValue("FAIL");
					XSSFCell HOM3 = sheet.getRow(8).createCell(2);
					HOM3.setCellValue(Homepathtwo);
				}
				else
				{
					XSSFCell HOM1 = sheet.createRow(8).createCell(0);
					HOM1.setCellValue("Images are same");
					XSSFCell HOM2 = sheet.getRow(8).createCell(1);
					HOM2.setCellValue("PASS");
					XSSFCell HOM3 = sheet.getRow(8).createCell(2);
					HOM3.setCellValue(Homepathtwo);
				}
			}
			xpathdetails.Service.click();
			Screenshot Service = new AShot().takeScreenshot(driver);
			if(i==0)
			{
				ImageIO.write(Service.getImage(),"png",new File("./Folder 1/Service.png"));
				File f2 = new File ("./Folder 1/Service.png");
				String Servicepath = f2.getAbsolutePath();
				if(f2.exists())
				{
					XSSFCell SER1 = sheet.createRow(2).createCell(0);
					SER1.setCellValue("Service label clicked and taken screenshot");
					XSSFCell SER2 = sheet.getRow(2).createCell(1);
					SER2.setCellValue("Pass");
					XSSFCell SER3 = sheet.getRow(2).createCell(2);
					SER3.setCellValue(Servicepath);
				}
				else
				{
					XSSFCell SER1 = sheet.createRow(2).createCell(0);
					SER1.setCellValue("Service label not clicked");
					XSSFCell SER2 = sheet.getRow(2).createCell(1);
					SER2.setCellValue("Fail");
					XSSFCell SER3 = sheet.getRow(2).createCell(2);
					SER3.setCellValue(Servicepath);
				}	
			}
			if(i==1)
			{
				ImageIO.write(Service.getImage(),"png",new File("./Folder 2/Service.png"));
				BufferedImage actualImage = Service.getImage();
				File f2 = new File ("./Folder 2/Service.png");
				String Servicepath = f2.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Service.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell SER = sheet.createRow(9).createCell(0);
					SER.setCellValue("Images are not same");
					XSSFCell SER2 = sheet.getRow(9).createCell(1);
					SER2.setCellValue("FAIL");
					XSSFCell SER3 = sheet.getRow(9).createCell(2);
					SER3.setCellValue(Servicepath);
				}
				else
				{
					XSSFCell SER = sheet.createRow(9).createCell(0);
					SER.setCellValue("Images are same");
					XSSFCell SER2 = sheet.getRow(9).createCell(1);
					SER2.setCellValue("PASS");
					XSSFCell SER3 = sheet.getRow(9).createCell(2);
					SER3.setCellValue(Servicepath);
				}
			}
			xpathdetails.Opensource.click();
			Screenshot Opensource = new AShot().takeScreenshot(driver);
			if(i==0)
			{
				ImageIO.write(Opensource.getImage(),"png",new File("./Folder 1/Opensource.png"));
				File f3 = new File ("./Folder 1/Opensource.png");
				String openpath = f3.getAbsolutePath();
				if(f3.exists())
				{
					XSSFCell OPN1 = sheet.createRow(3).createCell(0);
					OPN1.setCellValue("Opensurce label clicked and taken screenshot");
					XSSFCell OPN2 = sheet.getRow(3).createCell(1);
					OPN2.setCellValue("Pass");
					XSSFCell OPN3 = sheet.getRow(3).createCell(2);
					OPN3.setCellValue(openpath);
				}
				else
				{
					XSSFCell OPN1 = sheet.createRow(3).createCell(0);
					OPN1.setCellValue("Opensurce label not clicked");
					XSSFCell OPN2 = sheet.getRow(3).createCell(1);
					OPN2.setCellValue("Fail");
					XSSFCell OPN3 = sheet.getRow(3).createCell(2);
					OPN3.setCellValue(openpath);
				}	
			}
			else if(i==1)
			{
				ImageIO.write(Opensource.getImage(),"png",new File("./Folder 2/Opensource.png"));
				BufferedImage actualImage = Opensource.getImage();
				File f3 = new File ("./Folder 2/Opensource.png");
				String openpath = f3.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Opensource.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell OPN = sheet.createRow(10).createCell(0);
					OPN.setCellValue("Images are not same");
					XSSFCell OPN2 = sheet.getRow(10).createCell(1);
					OPN2.setCellValue("FAIL");
					XSSFCell OPN3 = sheet.getRow(10).createCell(2);
					OPN3.setCellValue(openpath);
				}
				else
				{
					XSSFCell OPN = sheet.createRow(10).createCell(0);
					OPN.setCellValue("Images are same");
					XSSFCell OPN2 = sheet.getRow(10).createCell(1);
					OPN2.setCellValue("PASS");
					XSSFCell OPN3 = sheet.getRow(10).createCell(2);
					OPN3.setCellValue(openpath);
				}
			}

			String parent = driver.getWindowHandle();
			xpathdetails.Blog.click();
			Set<String>Windows = driver.getWindowHandles();
			for(String child:Windows)
			{
				if(!parent.equalsIgnoreCase(child))
				{
					driver.switchTo().window(child);
				}
			}
			Screenshot Blog = new AShot().takeScreenshot(driver);
			if(i==0)
			{
				ImageIO.write(Blog.getImage(),"png",new File("./Folder 1/Blog.png"));
				File f4 = new File ("./Folder 1/Blog.png");
				String Blogpath = f4.getAbsolutePath();
				if(f4.exists())
				{
					XSSFCell BLG1 = sheet.createRow(4).createCell(0);
					BLG1.setCellValue("Blog label clicked and taken screenshot");
					XSSFCell BLG2 = sheet.getRow(4).createCell(1);
					BLG2.setCellValue("Pass");
					XSSFCell BLG3 = sheet.getRow(4).createCell(2);
					BLG3.setCellValue(Blogpath);
				}
				else
				{
					XSSFCell BLG1 = sheet.createRow(4).createCell(0);
					BLG1.setCellValue("Opensurce label not clicked");
					XSSFCell BLG2 = sheet.getRow(4).createCell(1);
					BLG2.setCellValue("Fail");
					XSSFCell BLG3 = sheet.getRow(4).createCell(2);
					BLG3.setCellValue(Blogpath);
				}	
				driver.close();
				driver.switchTo().window(parent);
			}
			else if(i==1)
			{
				ImageIO.write(Blog.getImage(),"png",new File("./Folder 2/Blog.png"));
				BufferedImage actualImage = Blog.getImage();
				File f4 = new File ("./Folder 2/Blog.png");
				String Blogpath = f4.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Blog.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell BLG = sheet.createRow(11).createCell(0);
					BLG.setCellValue("Images are not same");
					XSSFCell BLG2 = sheet.getRow(11).createCell(1);
					BLG2.setCellValue("FAIL");
					XSSFCell BLG3 = sheet.getRow(11).createCell(2);
					BLG3.setCellValue(Blogpath);
				}
				else
				{
					XSSFCell BLG = sheet.createRow(11).createCell(0);
					BLG.setCellValue("Images are same");
					XSSFCell BLG2 = sheet.getRow(11).createCell(1);
					BLG2.setCellValue("PASS");
					XSSFCell BLG3 = sheet.getRow(11).createCell(2);
					BLG3.setCellValue(Blogpath);
				}
                driver.close();
				driver.switchTo().window(parent);
			}

			xpathdetails.team.click();
			Screenshot team = new AShot().takeScreenshot(driver);
			if(i==0)
			{
				ImageIO.write(team.getImage(),"png",new File("./Folder 1/Team.png"));
				File f5 = new File ("./Folder 1/Team.png");
				String Teampath = f5.getAbsolutePath();
				if(f5.exists())
				{
					XSSFCell TEAM1 = sheet.createRow(5).createCell(0);
					TEAM1.setCellValue("Team label clicked and taken screenshot");
					XSSFCell TEAM2 = sheet.getRow(5).createCell(1);
					TEAM2.setCellValue("Pass");
					XSSFCell TEAM3 = sheet.getRow(5).createCell(2);
					TEAM3.setCellValue(Teampath);
				}
				else
				{
					XSSFCell TEAM1 = sheet.createRow(5).createCell(0);
					TEAM1.setCellValue("Team label not clicked");
					XSSFCell TEAM2 = sheet.getRow(5).createCell(1);
					TEAM2.setCellValue("Fail");
					XSSFCell TEAM3 = sheet.getRow(5).createCell(2);
					TEAM3.setCellValue(Teampath);
				}	
			}
			else if(i==1)
			{
				ImageIO.write(team.getImage(),"png",new File("./Folder 2/Team.png"));
				BufferedImage actualImage = team.getImage();
				File f5 = new File ("./Folder 2/Team.png");
				String Teampath = f5.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Team.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell TEAM1 = sheet.createRow(12).createCell(0);
					TEAM1.setCellValue("Images are not same");
					XSSFCell TEAM2 = sheet.getRow(12).createCell(1);
					TEAM2.setCellValue("FAIL");
					XSSFCell TEAM3 = sheet.getRow(12).createCell(2);
					TEAM3.setCellValue(Teampath);
				}
				else
				{
					XSSFCell TEAM1 = sheet.createRow(12).createCell(0);
					TEAM1.setCellValue("Images are same");
					XSSFCell TEAM2 = sheet.getRow(12).createCell(1);
					TEAM2.setCellValue("PASS");
					XSSFCell TEAM3 = sheet.getRow(12).createCell(2);
					TEAM3.setCellValue(Teampath);
				}
			}
            xpathdetails.Careers.click();
			Screenshot Careers = new AShot().takeScreenshot(driver);
			if(i==0)
			{
				ImageIO.write(Careers.getImage(),"png",new File("./Folder 1/Careers.png"));
				File f6 = new File ("./Folder 1/Careers.png");
				String careerspath = f6.getAbsolutePath();
				if(f6.exists())
				{
					XSSFCell CARR1 = sheet.createRow(6).createCell(0);
					CARR1.setCellValue("Careers label clicked and taken screenshot");
					XSSFCell CARR2 = sheet.getRow(6).createCell(1);
					CARR2.setCellValue("Pass");
					XSSFCell CARR3 = sheet.getRow(6).createCell(2);
					CARR3.setCellValue(careerspath);
				}
				else
				{
					XSSFCell CARR1 = sheet.createRow(6).createCell(0);
					CARR1.setCellValue("Careers label not clicked");
					XSSFCell CARR2 = sheet.getRow(6).createCell(1);
					CARR2.setCellValue("Fail");
					XSSFCell CARR3 = sheet.getRow(6).createCell(2);
					CARR3.setCellValue(careerspath);
				}	
			}
			else if(i==1)
			{
				ImageIO.write(Careers.getImage(),"png",new File("./Folder 2/Careers.png"));
				BufferedImage actualImage = Careers.getImage();
				File f6 = new File ("./Folder 2/Careers.png");
				String careerspath = f6.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Careers.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell CAR = sheet.createRow(13).createCell(0);
					CAR.setCellValue("Images are not same");
					XSSFCell CAR2 = sheet.getRow(13).createCell(1);
					CAR2.setCellValue("FAIL");
					XSSFCell CAR3 = sheet.getRow(13).createCell(2);
					CAR3.setCellValue(careerspath);
				}
				else
				{
					XSSFCell CAR = sheet.createRow(13).createCell(0);
					CAR.setCellValue("Images are same");
					XSSFCell CAR2 = sheet.getRow(13).createCell(1);
					CAR2.setCellValue("PASS");
					XSSFCell CAR3 = sheet.getRow(13).createCell(2);
					CAR3.setCellValue(careerspath);
				}
			}
            xpathdetails.Contactus.click();
			Screenshot Contactus = new AShot().takeScreenshot(driver);
			if(i==0)
			{
				ImageIO.write(Contactus.getImage(),"png",new File("./Folder 1/Contactus.png"));
				File f7 = new File ("./Folder 1/Contactus.png");
				String Contactuspath = f7.getAbsolutePath();
				if(f7.exists())
				{
					XSSFCell CON = sheet.createRow(7).createCell(0);
					CON.setCellValue("Contactus label clicked and taken screenshot");
					XSSFCell CON2 = sheet.getRow(7).createCell(1);
					CON2.setCellValue("Pass");
					XSSFCell CON3 = sheet.getRow(7).createCell(2);
					CON3.setCellValue(Contactuspath);
				}
				else
				{
					XSSFCell CON = sheet.createRow(7).createCell(0);
					CON.setCellValue("Contactus label not clicked");
					XSSFCell CON2 = sheet.getRow(7).createCell(1);
					CON2.setCellValue("Fail");
					XSSFCell CON3 = sheet.getRow(7).createCell(2);
					CON3.setCellValue(Contactuspath);
				}	

			}
			else if(i==1)
			{
				ImageIO.write(Contactus.getImage(),"png",new File("./Folder 2/Contactus.png"));
				BufferedImage actualImage = Contactus.getImage();
				File f7 = new File ("./Folder 2/Contactus.png");
				String Contactuspath = f7.getAbsolutePath();
				BufferedImage expectedImage = ImageIO.read(new File("./Folder 1/Contactus.png"));
				ImageDiffer imDiff = new ImageDiffer();
				ImageDiff diff = imDiff.makeDiff(actualImage, expectedImage);
				if(diff.hasDiff()==true)
				{
					XSSFCell CON = sheet.createRow(14).createCell(0);
					CON.setCellValue("Images are not same");
					XSSFCell CON2 = sheet.getRow(14).createCell(1);
					CON2.setCellValue("FAIL");
					XSSFCell CON3 = sheet.getRow(14).createCell(2);
					CON3.setCellValue(Contactuspath);
				}
				else
				{
					XSSFCell CON = sheet.createRow(14).createCell(0);
					CON.setCellValue("Images are same");
					XSSFCell CON2 = sheet.getRow(14).createCell(1);
					CON2.setCellValue("PASS");
					XSSFCell CON3 = sheet.getRow(14).createCell(2);
					CON3.setCellValue(Contactuspath);
				}
			 }
			FileOutputStream outputStream = new FileOutputStream (file);
			wb.write(outputStream);	
			}
	     }
}  
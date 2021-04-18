package Xpath;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class xpathdetails 
{
	
	@SuppressWarnings("unused")
	private String beforeXpath = "(//h5[contains(.,'Junior Engineer')])[";
	
	@SuppressWarnings("unused")
	private String afterXpath = "]/preceding::h3[1]";
	
	@FindBy(how=How.XPATH, using="//a[@href='/team']")
	public static WebElement team;
	
	@FindBy(how=How.XPATH, using="(//h5[contains(.,'Junior Engineer')])")
	public static List<WebElement> juniercount;
	
    @FindBy(how=How.XPATH, using="(//h5[contains(.,'Junior Engineer')])")
	public static WebElement junierengineers;
	
    @FindBy(how=How.XPATH, using="//img[@src='/img/testimonials/lokesh.jpg']")
	public static WebElement CTOimage;
	
    @FindBy(how=How.XPATH, using="//img[@src='/img/testimonials/sasi.jpg']")
	public static WebElement HRimage;
	
	@FindBy(how=How.XPATH, using="//a[@aria-current='page']")
   	public static WebElement Home;
	
	@FindBy(how=How.XPATH, using="//a[@href='/#built-tech']")
   	public static WebElement Service;
	
	@FindBy(how=How.XPATH, using="//a[@href='/opensource']")
   	public static WebElement Opensource;
	
	@FindBy(how=How.XPATH, using="//a[@href='https://blog.grootan.com']")
   	public static WebElement Blog;
	
	@FindBy(how=How.XPATH, using="//a[@href='/careers']")
   	public static WebElement Careers;
	
	@FindBy(how=How.XPATH, using="//a[@href='/contactus']")
   	public static WebElement Contactus;
	
	
}

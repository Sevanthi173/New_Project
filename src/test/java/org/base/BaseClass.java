package org.base;

import java.awt.AWTException;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.List;

//import org.adactin.SearchHotel;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver chromeBrowser() {
		return driver=new ChromeDriver();
		}
	public static WebDriver BrowserLauch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();}
		else if(bname.equalsIgnoreCase("edge")) {
			  WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				}
		else if(bname.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			    driver=new FirefoxDriver();
			}
		return driver;	}
	public static WebDriver chromeDriver() {
		return driver=new ChromeDriver();
		}
	public static WebDriver edgeDriver() {
		return driver=new EdgeDriver();
}
	public static  String urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		}
	public static String getcurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		

	}
	public static String getAttribute(WebElement e,String value) {
		String attribute = e.getAttribute(value);
		return attribute;}
	public static  void implicilyWait() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);}
	
	public static  void sendkeys(WebElement e,String value) {
		e.sendKeys(value);}
	public static  void click(WebElement e) {
		e.click();}
	
	public static  String getText(WebElement e) {
		String text = e.getText();
		return text;}
	public static String getAttributeValue(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;}
	public static boolean isenabled(WebElement e) {
		boolean enabled = e.isEnabled();
		return enabled;}
	public static boolean isdisplayed(WebElement e) {
		boolean displayed = e.isDisplayed();
		return displayed;}
	public static boolean isselected(WebElement e) {
		boolean selected = e.isSelected();
		return selected;
	}
	//select
	public static  void selectByIndex(WebElement e,int a) {
		Select s=new Select(e);
		s.selectByIndex(a);}
	public static  void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);}
	public static void selctByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByVisibleText(value);}
	private void deselctByindex(WebElement e,int a) {
		Select s=new Select(e);
		s.deselectByIndex(a);}
	private void deselctByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);}
	
	private void deselectByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByVisibleText(value);
		}
	
	public static List<String> getOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		List<String> li=new ArrayList<String>();
		for(WebElement x:options) {
			String text = x.getText();
			li.add(text);
}
		return li;
	}
	public static List<WebElement> getAllSelectedOptions(WebElement e) {
	Select s=new Select(e);
	List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	return allSelectedOptions;}
	//action class
	public static  void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
		a.click(e).perform();}
	public static void movetoElements(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();;}
	public static void dragAnddrop(WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();;}
	public static void clickandhold(WebElement e) {
		Actions a=new Actions(driver);
		a.clickAndHold(e).perform();
		a.contextClick(e).perform();}
	//Alert
	public static void accept() {
		Alert a=driver.switchTo().alert();
		a.accept();
		a.dismiss();}
	public static void alertSendkeys(String value) {
		Alert a=driver.switchTo().alert();
		a.sendKeys(value);}
	public static String alertGetText() {
		Alert a=driver.switchTo().alert();
		String text = a.getText();
		return text;}
	//robot
	public static void keypress() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);}
	public static void keyrelease() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void clear(WebElement e) {
		e.clear();}
	//screenshot
	public static void getScreenshot(WebElement e) throws IOException {
	 File srcFile = e.getScreenshotAs(OutputType.FILE);
	 long filename = System.currentTimeMillis();
	 File destFile=new File("C:\\Users\\Admin\\eclipse-workspace\\MavenNewProject_sep2023\\Screenshot");
		FileUtils.copyFile(srcFile, destFile);}
	
	
	
	public static  void refresh() {
		driver.navigate().refresh();}
	
	
	public static String getWindowHandle(WebElement e) {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;}
	//DataDriven
	public static String ExcelRead(String filename,String Sheet,int row,int c) throws IOException {
		File f=new File("C:\\Users\\Admin\\eclipse-workspace\\JUnit_11Am_Sep_2023\\src\\test\\resources\\EXCEL\\Model-Excel.xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(st);
	    Sheet s = w.getSheet("sheet1");
	    Row r = s.getRow(row);
	    Cell cell = r.getCell(c);
	    int Type = cell.getCellType();
	    String value=null;
	   if(Type==1) {
	    	 value = cell.getStringCellValue();
	    	
	    }
	    else {
	    	if(DateUtil.isCellDateFormatted(cell)) {
	    		Date dateCellValue = cell.getDateCellValue();
	    		SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
	    		 value = sd.format(dateCellValue);
	    		
	    	}
	    	else {
	    		double numericCellValue = cell.getNumericCellValue();
	    		long num=(long)numericCellValue;
	    		 value = String.valueOf(num);
	    		
	    	}
	     }
	return value;}
	public static void Date(int a) {
		Date d=new Date();
		int seconds = d.getSeconds();}

	public static void close() {
		driver.close();}
	public static void quit() {
		driver.quit();}

}

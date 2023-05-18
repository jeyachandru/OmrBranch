package org.com;

import java.awt.AWTException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample {
	
	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sanka\\eclipse-workspace\\OmrBranchHotelBooking\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// LoginPage
		WebElement txtusername = driver.findElement(By.id("email"));
		txtusername.sendKeys("jchandran9420@gmail.com");

		WebElement txtpassword = driver.findElement(By.id("pass"));
		txtpassword.sendKeys("Jchandran@1994");

		WebElement btnlogin = driver.findElement(By.xpath("//button[text()='Login']"));
		btnlogin.click();

		// SelectState
		WebElement selectstate = driver.findElement(By.id("state"));
		Select slt = new Select(selectstate);
		slt.selectByValue("Tamil Nadu");

		// SelectCity
		WebElement selectcity = driver.findElement(By.id("city"));
		Select slt1 = new Select(selectcity);
		slt1.selectByIndex(1);

		// SelectRoomType
		WebElement selectroom = driver.findElement(By.id("room_type"));
		Select sltroom = new Select(selectroom);
		sltroom.selectByValue("Standard");
		sltroom.selectByValue("Deluxe");
		sltroom.selectByValue("Suite");
		sltroom.selectByValue("Luxury");

		// SelectDate
		WebElement selectindate = driver.findElement(By.name("check_in"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('Value','2023-07-10')", selectindate);
		
		WebElement selectoutdate = driver.findElement(By.name("check_out"));
		js.executeScript("arguments[0].setAttribute('Value','2023-07-15')", selectoutdate);

		// SelectNo.OfRooms
		WebElement selectNoofRoom = driver.findElement(By.id("no_rooms"));
		Select slt3 = new Select(selectNoofRoom);
		slt3.selectByIndex(4);

		// SelectNo.OfAdults
		WebElement selectNoofadults = driver.findElement(By.id("no_adults"));
		Select slt4 = new Select(selectNoofadults);
		slt4.selectByIndex(2);

		// SelectNoofChilderns
		WebElement noofchildren = driver.findElement(By.id("no_child"));
		noofchildren.sendKeys("2");

		// clickSearchButton
		driver.switchTo().frame(0);
		WebElement clicksearch = driver.findElement(By.id("searchBtn"));
		js.executeScript("arguments[0].click()", clicksearch);
		
		
		WebElement element = driver.findElement(By.xpath("//label[text()='Name Ascending']"));
		element.click();

		WebElement element2 = driver.findElement(By.id("hotellist"));
		String text = element2.getText();
		System.out.println(text);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		WebElement radiobtn = driver.findElement(By.xpath("//label[contains(text(),'Price low to high')]"));
//		radiobtn.click();
//		Thread.sleep(3000);
		
	
	}	
	
	
	
}

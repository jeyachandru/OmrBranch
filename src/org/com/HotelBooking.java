package org.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HotelBooking {

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

		WebElement radiobtn = driver.findElement(By.xpath("//label[contains(text(),'Price low to high')]"));
		radiobtn.click();
		Thread.sleep(3000);
		
		List<WebElement> hotelprice = driver.findElements(By.xpath("//strong[@class='total-prize']"));
		
		for (WebElement webElement : hotelprice) {	
			System.out.println(webElement.getText());
		}
		System.out.println("prices are in ascending");

		
		
		
		WebElement btncontinue = driver.findElement(By.xpath("(//a[text()='Continue'])[1]"));
		js.executeScript("arguments[0].click()", btncontinue);

		Alert alt = driver.switchTo().alert();
		alt.accept();

		// BookingPage
		WebElement bookingmyself = driver.findElement(By.id("own"));
		js.executeScript("arguments[0].click()", bookingmyself);

		WebElement selectgender = driver.findElement(By.name("title"));
		Select slt5 = new Select(selectgender);
		slt5.selectByValue("Mr");

		WebElement txtfirstname = driver.findElement(By.id("first_name"));
		txtfirstname.sendKeys("Jeyachandran");

		WebElement txtlastname = driver.findElement(By.id("last_name"));
		txtlastname.sendKeys("Shanmugam");

		WebElement txtphoneNo = driver.findElement(By.id("user_phone"));
		txtphoneNo.sendKeys("8667282728");

		WebElement txtemail = driver.findElement(By.name("email"));
		txtemail.sendKeys("jchandran@gmail.com");

		WebElement btnNext = driver.findElement(By.id("step1next"));
		js.executeScript("arguments[0].click()", btnNext);

		WebElement selectbed = driver.findElement(By.id("bed"));
		js.executeScript("arguments[0].click()", selectbed);

		WebElement otherrequest = driver.findElement(By.id("other_request"));
		otherrequest.sendKeys("Double Bed");

		WebElement btntoNext = driver.findElement(By.id("step2next"));
		js.executeScript("arguments[0].click()", btntoNext);

		// SelectPaymentType
		WebElement selectpayment = driver.findElement(By.xpath("//div[@class='credit-card pm']"));
		js.executeScript("arguments[0].click()", selectpayment);

		WebElement selectcardtype = driver.findElement(By.id("payment_type"));
		Select slt6 = new Select(selectcardtype);
		slt6.selectByValue("debit_card");

		WebElement selectcard = driver.findElement(By.id("card_type"));
		Select slt7 = new Select(selectcard);
		slt7.selectByValue("visa");

		WebElement selectmonth = driver.findElement(By.id("card_month"));
		Select slt8 = new Select(selectmonth);
		slt8.selectByValue("08");

		WebElement selectyear = driver.findElement(By.id("card_year"));
		Select slt9 = new Select(selectyear);
		slt9.selectByValue("2030");

		WebElement txtname = driver.findElement(By.id("card_name"));
		txtname.sendKeys("Jeyachandran Shanmugam");

		WebElement txtcvv = driver.findElement(By.id("cvv"));
		txtcvv.sendKeys("123");

		WebElement cardno = driver.findElement(By.id("card_no"));
		cardno.sendKeys("5555555555552222");

		WebElement btnsubmit = driver.findElement(By.id("submitBtn"));
		btnsubmit.click();

		// BookingConformationPage

		Thread.sleep(5000);
		WebElement confirmcode = driver
				.findElement(By.xpath("//*[@id=\"page-wrapper\"]/section/div/div/div/div/div/div/h2/strong"));

		String text3 = confirmcode.getText();
		System.out.println(text3);

		Actions act = new Actions(driver);
		act.doubleClick(confirmcode).perform();

		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_C);

		// ViewBookedHotelPage

		WebElement clickbooking = driver.findElement(By.xpath("//button[text()='My Booking']"));
		clickbooking.click();

		WebElement clicksearch2 = driver.findElement(By.name("search"));
		clicksearch2.click();

		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);

		WebElement btnedit = driver.findElement(By.xpath("//button[@type='submit']"));
		btnedit.click();

		WebElement editdate = driver.findElement(By.name("check_in"));
		js.executeScript("arguments[0].setAttribute('value','2023-04-15')", editdate);

		WebElement cnfmbutton = driver.findElement(By.xpath("//button[text()='Confirm']"));
		cnfmbutton.click();

		WebElement alertmsg = driver.findElement(By.xpath("//li[@class='alertMsg']"));
		String text = alertmsg.getText();
		System.out.println(text);

		WebElement btncancel = driver.findElement(By.xpath("//a[text()='Cancel']"));
		btncancel.click();

		alt.accept();

		WebElement alertmsg2 = driver.findElement(By.xpath("//li[text()='Your booking cancelled successfully']"));
		String text2 = alertmsg2.getText();
		System.out.println(text2);

	}

}

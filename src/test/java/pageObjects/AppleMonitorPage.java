package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class AppleMonitorPage extends BasePage{
		
		//constructor
		public AppleMonitorPage(WebDriver driver) {
			super(driver);
			
		}
		
		//locators
		@FindBy(xpath = "//h1[normalize-space()='Apple Cinema 30\"']")
		WebElement productNameHeader;
		
		@FindBy(xpath = "//input[@value='10']")
		WebElement checkbox3;
		
		@FindBy(xpath = "//input[@value='11']")
		WebElement checkbox4;
		
		@FindBy(xpath = "//input[@id='input-option208']")
		WebElement textInputBox;
		
		@FindBy(xpath = "//select[@id='input-option217']")  //use Select class for dropdowns
		WebElement dropdownMenu;
		
		@FindBy(xpath = "//textarea[@id='input-option209']")
		WebElement textArea;
		
		@FindBy(xpath = "//i[@class='fa fa-upload']")
		WebElement fileUploadButton;
		
		@FindBy(xpath = "//input[@id='input-option219']")
		WebElement dateInputBox;
		
		@FindBy(xpath = "//input[@id='input-option221']")
		WebElement timeInputBox;
		
		@FindBy(xpath = "//input[@id='input-option220']")
		WebElement dateTimeInputBox;
		
		@FindBy(xpath = "//div[@class='input-group date']//i[@class='fa fa-calendar']")
		WebElement datePickerIcon;
		
		@FindBy(xpath = "//div[@class='input-group time']//button[@type='button']")
		WebElement timePickerIcon;
		
		@FindBy(xpath = "//div[@class='input-group datetime']//button[@type='button']")  
		WebElement dateTimePickerIcon;
		
		@FindBy(xpath = "//input[@id='input-quantity']")
		WebElement quantityInputBox;
		
		@FindBy(xpath = "//button[@id='button-cart']")
		WebElement addToCartButton;
		
		//actions
		public String getProductName() {
			return productNameHeader.getText();
		}
		
		public void selectCheckbox3() {
			if (!checkbox3.isSelected()) {
				checkbox3.click();
			}
		}
		
		public void selectCheckbox4() {
			if (!checkbox4.isSelected()) {
				checkbox4.click();
			}
		}
		
		public void enterTextInput(String text) {
			textInputBox.clear();
			textInputBox.sendKeys(text);
		}
		
		public void selectFromDropdown(String option) {
			Select select = new Select(dropdownMenu);
			select.selectByVisibleText(option);
		}
		
		public void enterTextArea(String text) {
			textArea.clear();
			textArea.sendKeys(text);
		}
		
		public void clickFileUpload() {
			fileUploadButton.sendKeys("E:\\Veeva Prep\\Pavan Kumar Sir Udemy pdfs\\1- Selenium\\Sel-0\\Day1.pdf");
			//file upload handling would require additional code to interact with the OS file dialog, which is beyond Selenium's capabilities. You would typically use a tool like AutoIt or Robot class for that.
		}
		
		public void enterDate(String date) {
			dateInputBox.clear();
			dateInputBox.sendKeys(date);
		}
		
		public void enterTime(String time) {
			timeInputBox.clear();
			timeInputBox.sendKeys(time);
		}
		
		public void enterDateTime(String dateTime) {
			dateTimeInputBox.clear();
			dateTimeInputBox.sendKeys(dateTime);
		}
		
		public void clickDatePicker() {
			datePickerIcon.click();
			// Additional code would be needed to select a date from the date picker widget
			
		}
		
		public void clickTimePicker() {
			timePickerIcon.click();
			// Additional code would be needed to select a time from the time picker widget
		}
		
		public void clickDateTimePicker() {
			dateTimePickerIcon.click();
			// Additional code would be needed to select a date and time from the date-time picker widget
		}
		
		public void enterQuantity(int quantity) {
			quantityInputBox.clear();
			quantityInputBox.sendKeys(String.valueOf(quantity));
		}
		
		public void clickAddToCart() {
			addToCartButton.click();
		}
		
		
		
}



/* Additonal code may look like this for date picker interaction:
  import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DatePickerExample {

    WebDriver driver;

    public void selectDate(String targetMonth,
                           String targetYear,
                           String targetDay) {

        // Open calendar icon
        driver.findElement(By.xpath("//button[contains(@class,'calendar')]")).click();

        while (true) {

            // Get displayed month and year
            String monthYear =
                    driver.findElement(By.xpath("//div[contains(@class,'datepicker')]//th[@class='datepicker-switch']"))
                          .getText();

            String[] arr = monthYear.split(" ");
            String displayedMonth = arr[0];
            String displayedYear = arr[1];

            // Stop when month and year match
            if (displayedMonth.equals(targetMonth) &&
                displayedYear.equals(targetYear)) {
                break;
            }

            // Decide whether to go next or previous
            // Example logic (can be improved using Date comparison)
            if (Integer.parseInt(displayedYear) > Integer.parseInt(targetYear)) {

                // click previous arrow
                driver.findElement(By.xpath("//th[@class='prev']")).click();

            } else if (Integer.parseInt(displayedYear) < Integer.parseInt(targetYear)) {

                // click next arrow
                driver.findElement(By.xpath("//th[@class='next']")).click();

            } else {
                // same year, compare month manually
                driver.findElement(By.xpath("//th[@class='prev']")).click();
            }
        }

        // Select day
        driver.findElement(By.xpath("//td[not(contains(@class,'old')) and not(contains(@class,'new')) and text()='"
                + targetDay + "']")).click();
    }

    public static void main(String[] args) {

        DatePickerExample obj = new DatePickerExample();

        obj.driver = new ChromeDriver();
        obj.driver.manage().window().maximize();
        obj.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        obj.driver.get("YOUR_URL_HERE");

        obj.selectDate("February", "2011", "20");
    }
}
*/

package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private static final String email_input_id = "email";
    private static final String password_input_id = "password";
    private static final String continue_button_xpath = "//button[text()='Continue']";
    private static final String submit_button_xpath = "//button[text()='Submit']";


    public static void open_login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://gs-app-qa.bullioninternational.info/login-email");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_input_id)));
    }

    public static void enter_valid_email_address() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_input_id)));
        driver.findElement(By.id(email_input_id)).sendKeys("ppregression@gbi.co");
    }

    public static void click_continue_button() throws InterruptedException {
        driver.findElement(By.xpath(continue_button_xpath)).click();
    }
    public static void enter_valid_password() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password_input_id)));
        driver.findElement(By.id(password_input_id)).sendKeys("Test22@@");
    }


    public static void enter_valid_2FA_code() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='react-code-input']/input[1]")));
        for (int i = 1; i <= 6; i++) {

            String elementXPath = String.format("//div[@class='react-code-input']/input[%d]", i);

            WebElement inputElement = driver.findElement(By.xpath(elementXPath));

            inputElement.sendKeys("0");

            Thread.sleep(500);
        }
    }
    public static void click_submit_button() throws InterruptedException {
        driver.findElement(By.xpath(submit_button_xpath)).click();
    }
    public static void wait_portfolio_page_load() throws InterruptedException {
        wait.until(ExpectedConditions.urlContains("/portfolio"));    }

    public static boolean isUrlEndingWith(String suffix) {
        return driver.getCurrentUrl().endsWith(suffix);
    }
}

package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    public static WebDriver driver;

    public static String hamburger_menu_xpath = "//*[@id=\"menuToggle\"]/input";
    public static String singIn_link_text = "Sign In Portal";
    public static String product_link_xpath = "//*[@id=\"menu\"]/a[3]/li";
    public static String about_link_xpath = "//*[@id=\"menu\"]/a[4]/li";
    public static String our_team_link_xpath = "//*[@id=\"menu\"]/a[5]/li";
    public static String contact_link_xpath = "//*[@id=\"menu\"]/a[6]/li";

    public static void click_on_hamburger_menu() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();

    }
}

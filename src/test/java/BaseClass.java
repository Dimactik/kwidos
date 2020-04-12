import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseClass {
    WebDriver driver;

    @BeforeMethod
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void browserQuit(){
        driver.quit();
    }
}

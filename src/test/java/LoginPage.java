import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {

    String url = "https://kwidos.tk/auth/login";
    String email = "email";
    String password = "password";
    String button = "//button[contains(text(), 'SIGN IN')]";
    String expectedUrl = "https://kwidos.tk/";
    String emailErrorMessage = "//div[contains(text(), 'Email is required')]";
    String passwordErrorMessage = "//div[contains(text(), 'Password is required')]";

    @Test
    public void loginSuccess() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.id(email)).sendKeys("ccqyzdtryugrspfddo@awdrt.com");
        driver.findElement(By.id(password)).sendKeys("Qwerty12");
        driver.findElement(By.xpath(button)).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

    }

    @Test
    public void notExistingEmail() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.id(email)).sendKeys("");
        driver.findElement(By.id(password)).sendKeys("Qwerty12");
        driver.findElement(By.xpath(button)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(emailErrorMessage)).isDisplayed());
    }

    @Test
    public void emptyCredential() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.id(email)).sendKeys("");
        driver.findElement(By.id(password)).sendKeys("");
        driver.findElement(By.xpath(button)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(emailErrorMessage)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(passwordErrorMessage)).isDisplayed());
    }
}

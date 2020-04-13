import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupPage extends BaseClass {

    String url = "https://kwidos.tk/auth/register/consumer";
    String firstName = "[formcontrolname='firstName']";
    String lastName = "[formcontrolname='lastName']";
    String phone = "[formcontrolname='phone']";
    String email = "[formcontrolname='email']";
    String password = "[formcontrolname='password']";
    int randomInt = (int)(Math.random() * 5000+1);
    String checkboxTermsOfUse = "//p-checkbox[@class='ng-untouched ng-pristine ng-invalid']";
    String createAccountBtn = ".btn.btn-fill.btn-danger.btn-wd";
    String errorEmailMessage = "//small[contains(text(), 'Please enter your Email address')]";



   @Test
    public void signupSuccess() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(firstName)).sendKeys("Test");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(lastName)).sendKeys("Testov");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(phone)).sendKeys("1111111111");
        driver.findElement(By.cssSelector(email)).sendKeys("testik"+"+"+randomInt+"@gmail.com");
        driver.findElement(By.cssSelector(password)).sendKeys(randomInt+"1A!asaas");
        driver.findElement(By.xpath(checkboxTermsOfUse)).click();
        driver.findElement(By.cssSelector(createAccountBtn)).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://kwidos.tk/auth/login");
    }

   @Test
    public void signupWrongCred() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(firstName)).sendKeys("Test");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(lastName)).sendKeys("Testov");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(phone)).sendKeys("1111111111");
        driver.findElement(By.cssSelector(email)).sendKeys("hjjjh");
        driver.findElement(By.cssSelector(password)).sendKeys(randomInt+"1A!asaas");
        driver.findElement(By.xpath(checkboxTermsOfUse)).click();
        driver.findElement(By.cssSelector(createAccountBtn)).click();

        Assert.assertTrue(driver.findElement(By.xpath(errorEmailMessage)).isDisplayed());
    }


    @Test
    public void emptyCredentials() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(firstName)).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(lastName)).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(phone)).sendKeys("1111111111");
        driver.findElement(By.cssSelector(email)).sendKeys("hjjjh");
        driver.findElement(By.cssSelector(password)).sendKeys(randomInt+"1A!asaas");
        driver.findElement(By.xpath(checkboxTermsOfUse)).click();
        driver.findElement(By.cssSelector(createAccountBtn)).click();

        Assert.assertFalse(driver.findElement(By.cssSelector(createAccountBtn)).isEnabled());



    }
}

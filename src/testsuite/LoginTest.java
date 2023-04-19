package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl= "http://the-internet.herokuapp.com/login";
    @Before
    public void setBaseUrl(){
        openBrowser(baseUrl);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    public void varifyuserSholdLoginSuccessfullyWithValidCredentials(){

   driver.findElement(By.id("username")).sendKeys("tomsmith");//Find username field and enter valid username
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");//Find password field and enter valid password
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();// Find Login button and click on it
    String expectedMessage = "Secure Area";// Expected message given in requirement
    String actualMessage = driver.findElement(By.xpath("//h2[contains(text(),' Secure Area')]")).getText();// Finding Secure Area text element and getting the text
        Assert.assertEquals("User was not logged in successfully",expectedMessage, actualMessage);// Validating actual and expected message
}

    @Test
    public void verifyTheUsernameErrorMessage() {

        driver.findElement(By.id("username")).sendKeys("tomsmith1");//Find username field and enter invalid username
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!"); //Find password field and enter valid password
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();// Find Login button and click on it
        String expectedMessage = "Your username is invalid!";// Expected message given in requirement
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText().substring(0, 25);// Finding Error text element and getting the text removing last two unwanted characters
        Assert.assertEquals("Unable to verify User Name error message.",expectedMessage, actualMessage);// Validating actual and expected message
    }

    @Test
    public void verifyThePasswordErrorMessage() {

        driver.findElement(By.id("username")).sendKeys("tomsmith");// Find username field and enter valid username
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");//Find password field and enter invalid password
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();// Find Login button and click on it
        String expectedMessage = "Your password is invalid!";// Expected message given in requirement
        String actualMessage = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText().substring(0, 25);// Finding Error text element and getting the text removing last two unwanted characters
        Assert.assertEquals("Password error message was not verified.", expectedMessage, actualMessage);// Validating actual and expected message

    }


}

package org.example.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInTest {
    @Test
    public void logInVerification() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Login");
        driver.findElement(By.xpath("//*[@id=\"wpName1\"]")).sendKeys("InfuseTestUser");
        driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]")).sendKeys("4nsbFv4_F8r-@.N");
        driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();
        String row = driver.findElement(By.xpath("//*[@id=\"pt-userpage-2\"]/a/span")).getText();
        Assert.assertEquals(row , "InfuseTestUser", "User is wrong");
        driver.close();
        driver.quit();
    }
}

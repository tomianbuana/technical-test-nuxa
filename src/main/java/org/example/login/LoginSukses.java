package org.example.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class LoginSukses {
    public static void run() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://stg-app.nexmedis.com/");
        Thread.sleep(2000);

        //Mengisi kolom id organisasi
        driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("official_nexmedis");
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/main/div[2]/div/form/button")).click();
        Thread.sleep(1000);

        //Mengisi kolom Login berhasil
        driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("qa-rec@nexmedis.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password1234");
        driver.findElement(By.xpath("//*[@id=\"app\"]/main/main/div[2]/div/form/button")).click();
        Thread.sleep(1000);


        if(!Objects.equals(driver.getCurrentUrl(), "https://stg-app.nexmedis.com/channel/merchants/list")) {
            driver.quit();
            throw new Exception("Login gagal");
        }

        driver.quit();
    }
}

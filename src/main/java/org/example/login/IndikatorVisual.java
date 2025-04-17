package org.example.login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class IndikatorVisual {
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
        WebElement passinput =  driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passinput.sendKeys("password1234");

        if(!Objects.equals(passinput.getAttribute("type"), "password")){
            driver.quit();
            throw new Exception("Password seharusnya disembunyikan");
        }

        driver.findElement(By.xpath("//*[@id=\"app\"]/main/main/div[2]/div/form/div[2]/div/a/img")).click();

        if(!Objects.equals(passinput.getAttribute("type"), "text")){
            driver.quit();
            throw new Exception("password seharusnya terlihat");
        }
        driver.quit();
    }
}


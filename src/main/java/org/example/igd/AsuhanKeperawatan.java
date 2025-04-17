package org.example.igd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AsuhanKeperawatan {
    private WebDriver driver;

    public AsuhanKeperawatan() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void run() throws Exception {
        try {
            this.login();
            this.registerPasien();
            this.addAsuhanPerawat();
//            this.deletePasien();

        } finally {
            this.driver.quit();
        }
    }

    public void login() throws Exception {
        this.driver.get("https://stg-app.nexmedis.com/");
        Thread.sleep(2000);

        //Mengisi kolom id organisasi
        this.driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("official_nexmedis");
        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/main/div[2]/div/form/button")).click();
        Thread.sleep(1000);

        //Mengisi kolom Login berhasil
        this.driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("qa-rec@nexmedis.com");
        this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password1234");
        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/main/div[2]/div/form/button")).click();
        Thread.sleep(2000);

        var errorEl = driver.findElements(By.xpath("//*[@id=\"app\"]/main/div"));
        if(errorEl.isEmpty()) {
            throw new Exception("Login tidak gagal");
        }
    }

    // Ke Tab IGD
    public void registerPasien() throws InterruptedException {
        Thread.sleep(2000);

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/main/div[2]/div/div/div[3]/a/div")).click();
        Thread.sleep(1000);

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/header/div/header/div[1]/div[3]/a")).click();
        Thread.sleep(1000);

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/main/div/div/div[2]/div[2]/div[1]/input")).sendKeys("Test QA tom");
        Thread.sleep(1000);

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/main/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr/td[8]/img[2]")).click();
        Thread.sleep(1000);

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div/div[3]/a[3]")).click();
        Thread.sleep(1000);


        //Mengisi data IGD
        this.driver.findElement(By.cssSelector("input.vs__search[placeholder='Pilih Ranjang'")).click();
        this.driver.findElement(By.xpath("//li[text()=\"Ranjang 4\"]")).click();

        this.driver.findElement(By.cssSelector("input.vs__search[placeholder='Pilih Kesadaran Pasien'")).click();
        this.driver.findElement(By.xpath("//li[text()=\"Sopor\"]")).click();

        this.driver.findElement(By.cssSelector("input.vs__search[placeholder='Pilih DPJP (Penanggung Jawab)'")).click();
        this.driver.findElement(By.xpath("//li[text()=\"Agra Yuda\"]")).click();

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div/div[4]/form/div/div[1]/div/button")).click();

        Thread.sleep(2000);
    }

    public void addAsuhanPerawat() {
        
    }

    // Delete Pasien dari IGD
    public void deletePasien() throws InterruptedException {
        this.driver.findElement(By.xpath("//*[@id=\"app\"]/header/div/header/div[1]/div[7]/a")).click();

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div[2]/div/div/div[1]/input")).sendKeys("Test QA tom");
        Thread.sleep(1000);

        this.driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[1]/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[7]/img[2]")).click();

        this.driver.findElement(By.xpath("//*[@id=\"modal-confirm\"]/div/div[1]/textarea")).sendKeys("Test QA tom");
        Thread.sleep(1000);

        this.driver.findElement(By.xpath("//*[@id=\"modal-confirm\"]/div/div[2]/button[2]")).click();
    }
}

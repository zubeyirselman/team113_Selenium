package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locator_findElement {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon sayfasina gidin
        driver.get("https://amazon.com");
        // arama kutusuna Nutella yazdirip
        /*
            Test otomasyonu yaparak bir web elementi kullanmak istersek 2 seye ihtiyacimiz var.
            1- o web elementi benzersiz olarak tarif edebilecegimiz bir locator
            2- bu locator' i soyleyedigimizde bize web elementi bulup getirecek method

            ornegin amazon sitesindeki arama kutusunun unique tarif edicisi olarak
            id= "twotabsearchtextbox" kullanabiliriz.
         */
          WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        //data turu   objenin adi        =  findElement: webelementi bulan method
        //                                  By: webelementi bulacagimiz locator' in turunu yazdigimiz method
        //                                  twotabsearchtextbox: unique tarif icin id attribute degeri

        /*
            findElement() methodu verdigimiz locator turu ve o locator icin verdigimiz degere gore
            webelementi arar.
            locator icin verdigimiz deger hataliysa veya
            locator stratejisinde hata yaptiysak
            aranan webelementi implicitlyWait olarak tanimladigimiz
            maximum sure boyunca arar
            bulamadigi icin "NoSuchElementException" firlatir ve
            kalan kodlari calistirmaz
         */

        aramaKutusuElementi.sendKeys("Nutella");
        // istenen webelemente istenen yaziyi gonderir.

        // Enter tusuna basarak arama yapin
        aramaKutusuElementi.submit();
        // istenen webelementi uzerinde enter tusuna basar

        Thread.sleep(5000);
        driver.close();


    }
}

package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        /*
           Selenium 4.7 versiyonu ile kendi driver' ini sisteme ekledi
           Kodlar calismaya basladiginda biz driver icin yol gostermezsek
           Selenium kendi driver' ini devreye sokuyor

           Ama baslangicta driver ayari aradigi icin biraz yavas calisiyor

           driver.manage().window().istenen ayar ile window' umuzu istedigimiz boyuta getirebilir
           veya window' un konum ve buyukluk bilgilerine ulasabiliriz

           Biz genelde bir teste baslamadan once window' u maximize yapmayi tercih ederiz
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /*
            implicitlyWait bir websayfasi acilincaya veya
            aradigimiz elementler bulununcaya kadar
            driver'in bekleyecegi maximum sureyi belirler
         */
        driver.get("https://amazon.com");

        System.out.println("Baslangicta konum: " + driver.manage().window().getPosition()); // (10, 10)
        System.out.println("Baslangicta boyut: " + driver.manage().window().getSize()); // (1050, 708)

        Thread.sleep(1000);
        driver.manage().window().maximize();
        System.out.println("Maximize konum: " + driver.manage().window().getPosition()); // (-8, -8)
        System.out.println("Maximize boyut: " + driver.manage().window().getSize()); // (1382, 744)

        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum: " + driver.manage().window().getPosition()); // (0, 0)
        System.out.println("Fullscreen boyut: " + driver.manage().window().getSize()); // (1366, 768)

        Thread.sleep(1000);
        driver.manage().window().minimize();
        System.out.println("Minimize konum: " + driver.manage().window().getPosition()); // (10, 10)
        System.out.println("Minimize boyut: " + driver.manage().window().getSize()); // (1050, 708)

        // pencereyi istedigimiz boyut ve konuma getirelim

        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));
        System.out.println("Istedigimiz konum: " + driver.manage().window().getPosition()); // (50, 50)
        System.out.println("Istedigimiz boyut: " + driver.manage().window().getSize()); // (516, 500)


        Thread.sleep(2000);
        driver.close();
    }
}

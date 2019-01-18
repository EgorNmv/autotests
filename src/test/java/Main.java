import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String [] args) throws InterruptedException {
        //"C:\\Users\\ПК\\IdeaProjects\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver","C:/Users/EG/IdeaProjects/nnnaaa/chromedriver.exe");
        //Test_1();
        Test_2();
    }

    public static void Test_1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://els-rc.naumen.ru");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("otolstykh@naumen.ru");
        driver.findElement(By.id("password")).sendKeys("qwer1234");
        driver.findElement(By.id("loginbutton")).click();
        driver.findElement(By.cssSelector("a[href='/organizations']")).click();
        driver.findElement(By.xpath("//a[text()='250']")).click();
        driver.findElement(By.linkText("«Казанский исламский университет»")).click();
        driver.findElement(By.cssSelector("a[class='btn btn-primary m-l-15 m-t-5 m-b-20 btn-sm']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span.input-group-addon.dropdown-toggle")).click();
        driver.findElement(By.linkText("Предоставление лицензии")).click();
        driver.findElement(By.cssSelector("input[value='rs_101']")).click();
        driver.findElement(By.id("ogrn")).clear();
        driver.findElement(By.id("ogrn")).sendKeys("0000000000000");
        driver.findElement(By.id("inn")).clear();
        driver.findElement(By.id("inn")).sendKeys("0000000000");
        driver.findElement(By.id("kpp")).clear();
        driver.findElement(By.id("kpp")).sendKeys("000000000");
        driver.findElement(By.xpath("//button[text()='Завершить регистрацию заявления']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Ок']")).click();
        driver.findElement(By.xpath("//a[text()=' Завершить регистрацию\n" +
                "                                    ']")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();

    }

    public static void Test_2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://els-rc.naumen.ru");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("otolstykh@naumen.ru");
        driver.findElement(By.id("password")).sendKeys("qwer1234");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".nav li:nth-child(8) a")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//span[text()='Администрирование']")).click();
        driver.findElement(By.cssSelector("a[href='/admin/systemactions']")).click();
        driver.findElement(By.id("nominative")).sendKeys("Люди");
        driver.findElement(By.cssSelector(".btn.btn-primary.get-declensions")).click();
        String genitive= driver.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText() ;
        String dative= driver.findElement(By.cssSelector("tr:nth-child(3) td:nth-child(2)")).getText() ;
        Assert.assertTrue(genitive.equals("Людей"),"Родительный падеж определяется неверно");
        Assert.assertTrue(dative.equals(("Людям")),"Дательный падеж определяется неверно");
        //driver.navigate().refresh();
    }
}

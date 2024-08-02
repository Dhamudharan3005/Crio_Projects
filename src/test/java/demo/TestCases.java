package demo;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases  {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
 
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }
  
   

       @Test
    public void testCase01() throws InterruptedException{
       Wrappers wrap=new Wrappers(driver);
       SoftAssert softAssert = new SoftAssert();
       boolean status;
       Duration dur=Duration.ofSeconds(30);
       WebDriverWait wait = new WebDriverWait(driver,dur);

       status=wrap.navigate2page("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
       
       softAssert.assertTrue(status,"Page not redirected");
       status=wrap.typetxt("//input[@aria-labelledby='i1']","Crio Learner");
      
       softAssert.assertTrue(status,"Text not inserted in Name Box");
       long epoch = System.currentTimeMillis()/1000;
       
       status=wrap.typetxt("//textarea[@aria-describedby='i6 i7']", "I want to be the best QA Engineer! "+epoch);
      
       softAssert.assertTrue(status,"Text not inserted in reason Box");
       status=wrap.clickonbtn("//div[@class='bzfPab wFGF8']","0 - 2");
      
       softAssert.assertTrue(status,"Experience not choosen");
        String[] str={"Java","Selenium","TestNG"};
       status=wrap.clickonbtn("//div[@class='eBFwI']",str);
       
       softAssert.assertTrue(status, "Courses not selected");
       status=wrap.genderdropdown("Mr", "//div[@class='ry3kXd']/div[1]","//div[@class='OA0qNb ncFHed QXL7Te']//span[@class='vRMGwf oJeWuf']");
      
       softAssert.assertTrue(status,"Gender selection failed");
       status=wrap.typetxt("//input[@type='date']",7);
      
       softAssert.assertTrue(status,"failed while typing date");
       status=wrap.timetype("//div[@class='vEXS5c'][1]//input[@maxlength='2']","//div[@class='vEXS5c'][2]//input[@maxlength='2']");
       
       softAssert.assertTrue(status,"failed while typing time");
       status=wrap.clickonbtn("//span[text()='Submit']");
       
       softAssert.assertTrue(status, "failed to click submit button");
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vHW8K']")));
      String success=driver.findElement(By.xpath("//div[@class='vHW8K']")).getText();
      System.out.println(success);
       softAssert.assertAll();
 
    }
 
    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }

    
}
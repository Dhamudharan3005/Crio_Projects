package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class Wrappers {
    ChromeDriver driver;
   
    public Wrappers(ChromeDriver driver) {
        //TODO Auto-generated constructor stub
        this.driver=driver;
    }
    /*
     * Write your selenium wrappers here
     */
    public boolean navigate2page(String Url){
        try {
            driver.navigate().to(Url);
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            Thread.sleep(2000);
        String C_url=driver.getCurrentUrl();
        if(Url.equals(C_url)){
            return true;
        }
       return false;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while navigating to page"+e.getMessage());
            return false;
        }
        
    }
    public boolean typetxt(String xpath1,String txt2type){
        try {
            WebElement txtbox=driver.findElement(By.xpath(xpath1));
            if(txtbox.isDisplayed()){
                txtbox.click();
                txtbox.sendKeys(txt2type);
                System.out.println(txtbox.getText());
                // if(txtbox.getText().contains(txt2type)){
                    return true;
                // }
                
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while typing in text box"+e.getMessage());
            return false;
        }
       
    }

    


    public boolean clickonbtn(String xpath2,String value){
        try {
            List<WebElement> rdobtn=driver.findElements(By.xpath(xpath2));
        for (WebElement webElement : rdobtn) {
            if(webElement.getText().equals(value)){
                webElement.click();
                return true;
            }
        }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while clicking on button"+e.getMessage());
            return false;
        }
        
    }
    public boolean clickonbtn(String btnxpath){
        try {
            WebElement btn=driver.findElement(By.xpath(btnxpath));
       
            if(btn.isDisplayed()){
                btn.click();
                return true;
            }
        
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while clicking on button"+e.getMessage());
            return false;
        }
        
    }

    public boolean clickonbtn(String xpath3,String[] values){
        try {
            List<WebElement> chkboxes=driver.findElements(By.xpath(xpath3));
            int i=0;
            for (WebElement webElement : chkboxes) {
                for (String value: values) {
                    if(webElement.getText().equals(value)){
                        webElement.click();
                        i++;
                    }
                }
                
            } 
            if(i==values.length){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption clicking on button"+e.getMessage());
            return false;
        }
       
    }
    public boolean typetxt(String xpath5,String[] values){
        try {
            List<WebElement> chkboxes=driver.findElements(By.xpath(xpath5));
            int i=0;
            int a=chkboxes.size();
            int b=values.length;
            if(a==b){
               for (WebElement webElement : chkboxes) {
                    webElement.sendKeys(values[i]);
                    i++;
                    if(i>a-1){
                        return true;
                    }
               }
               
            }
                return false;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while typing text"+e.getMessage());
            return false;
        }
       
    }
    public boolean genderdropdown(String gendr,String xpath6,String optionxpath){
        try {
            WebElement gndr_drpdwn=driver.findElement(By.xpath(xpath6));
             JavascriptExecutor jse = (JavascriptExecutor) driver;
     jse.executeScript("arguments[0].scrollIntoView();", gndr_drpdwn);
     Duration dur=Duration.ofSeconds(30);
     WebDriverWait wait = new WebDriverWait(driver,dur);
        gndr_drpdwn.click();

        WebElement drpdwn=driver.findElement(By.xpath("//div[@jsname='V68bde']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jsname='V68bde']")));
        List<WebElement> drodwn=driver.findElements(By.xpath(optionxpath));
        
        for (WebElement webElement : drodwn) {
            
            if(webElement.getText().contains(gendr)){
                
                webElement.click();
              Thread.sleep(2000);
                return true;
            }
        }
    return false;
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while operating dropdown"+e.getMessage());
            return false;
        }
        
    }
    
    public boolean typetxt(String calenderxpath,int a){
        try {
            WebElement calender=driver.findElement(By.xpath(calenderxpath));
            
        LocalDate date=LocalDate.now();
        
        date=(date.minusDays(a));
        
        String s=date.toString();
        String[] str=s.split("-");
        String resdate=str[2];
        for(int i=1;i>=0;i--){
            resdate=resdate.concat(str[i]);
        }
        calender.sendKeys(resdate);
        return true;
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while typing text"+e.getMessage());
            return false;
        }
        
    }
    
    public boolean timetype(String hrxpath,String minxpath){
        try {
            WebElement clockhr=driver.findElement(By.xpath(hrxpath));
            WebElement clockmin=driver.findElement(By.xpath(minxpath));
            LocalTime time=LocalTime.now();
            String s=time.toString();
            String[] str=s.split(":");
            
            String hr=str[0];
            String min=str[1];
            clockhr.click();
            clockhr.sendKeys(hr);
           
            // Actions actions=new Actions(driver);
            // actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
            // clockmin.click();
            clockmin.sendKeys(min);
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Excemption while typing text"+e.getMessage());
            return false;
        }
       
    }
    public boolean matchtxt(String txtxpath,String txt){
        try {
            String acttxt=driver.findElement(By.xpath(txtxpath)).getText();
            if(acttxt.contains(txt)){
                return true;
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Excemption while matching text"+e.getMessage());
            return false;
        }
    }
   
   
}

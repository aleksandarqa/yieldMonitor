import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_yield {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080");

        driver.findElement(By.xpath("//button[contains(text(),'Manual Test')]")).click();

        for (int i = 1; i <= 5; i++) {

            WebElement serial = driver.findElement(By.id("serialNumber"));
            serial.clear();
            serial.sendKeys("AUTO_SN_" + i);

            WebElement part = driver.findElement(By.id("partNumber"));
            part.sendKeys("001PN001");

            WebElement status = driver.findElement(By.id("status"));

            if (i <= 3) {
                if (!status.isSelected()) status.click();
            } else {
                if (status.isSelected()) status.click();
            }

            driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

            Thread.sleep(500);
        }

        driver.findElement(By.xpath("//button[contains(text(),'Load Part Chart')]")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("partChart")).click();

        Thread.sleep(1000);

        String yieldText = driver.findElement(By.id("yieldDisplay")).getText();

        if (yieldText.contains("60")) {
            System.out.println("PASS - Yield is 60%");
        } else {
            System.out.println("FAIL - Expected 60% but got: " + yieldText);
        }

        driver.quit();
    }
}
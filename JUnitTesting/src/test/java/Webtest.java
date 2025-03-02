import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Webtest {
ChromeDriver chromeDriver;
@BeforeEach
public void setup() {
    chromeDriver = new ChromeDriver();
}

@Test
    public void DangKy(){
    chromeDriver.get("https://vitimex.com.vn/dang-ky.html");
    chromeDriver.findElement(By.id("name")).sendKeys("bao123");
    chromeDriver.findElement(By.id("phone")).sendKeys("01223456789");
    chromeDriver.findElement(By.id("email")).sendKeys("bao20042tk@gmail.com");
    chromeDriver.findElement(By.id("pass-regis")).sendKeys("bao111");
    chromeDriver.findElement(By.id("pass-confirm")).sendKeys("bao111");
    WebElement DangKy = chromeDriver.findElement(By.id("register-btn"));
    DangKy.click();
}

    @Test
    public void DangNhap() {
        chromeDriver.get("https://vitimex.com.vn/");
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;

        // Click vào nút "Đăng nhập"
        WebElement btnDangNhap = chromeDriver.findElement(By.xpath("//a[@data-bs-toggle='modal']"));
        js.executeScript("arguments[0].click();", btnDangNhap);

        // Chờ modal xuất hiện
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account")));

        // Điền thông tin đăng nhập
        chromeDriver.findElement(By.id("account")).sendKeys("bao20042tk@gmail.com");
        chromeDriver.findElement(By.id("pass")).sendKeys("bao111");

        // Click nút đăng nhập
        WebElement DangNhap = chromeDriver.findElement(By.id("signin-btn"));
        DangNhap.click();
    }

}

package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  private WebDriver driver;

  @BeforeEach
  public void createDriver() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Takashi Tazoe\\IdeaProjects\\selenium-project\\selenium\\111\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--remote-allow-origins=*")
    driver = new ChromeDriver(options);
  }

  @AfterEach
  public void quitDriver() {
    driver.close();
  }

  @Test
  public void testPageTitle() {
    // open the web url
    driver.get("http://codetoautomate.com/educative-selenium-demo/");

    // Click the element to activate the alert
    driver.findElement(By.id("alert-button")).click();

    // Wait for the alert to be displayed and switch to the alert popup
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

    // close the alert
    alert.dismiss();
    driver.close();
  }

//  @Test
//  public void testPageTransition() {
//    //指定したURLに遷移する
//    webDriver.get("https://saikeblog.com");
//
//    // 最大5秒間、ページが完全に読み込まれるまで待つ
////    webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//
//    // タブの「技術」要素を取得し、クリックする
//    WebElement webElement = webDriver.findElement(By.id("menu-item-37"));
//    webElement.click();
//
//    // 検証
//    assertEquals(webDriver.getTitle(), "技術 – さいけの技術ブログ");
//    assertEquals(webDriver.getCurrentUrl(), "https://saikeblog.com/category/%e6%8a%80%e8%a1%93/");
//  }
}
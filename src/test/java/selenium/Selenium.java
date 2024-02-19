package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();

    try {
      // Login
      getLoginButton(driver);
      // Perform actions after login
      Thread.sleep(5000);
      addDoctor(driver);
      // Logout
      Thread.sleep(5000);
      logout(driver);

    } finally {
      try {
        Thread.sleep(12000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // Close the browser window
      driver.quit();
    }
  }

  private static void addDoctor(WebDriver driver) {

    WebElement addDoctor = driver.findElement(By.xpath("(//button[normalize-space()='Add Doctor'])[1]"));
    addDoctor.click();

    WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
    WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
    WebElement specialization = driver.findElement(By.xpath("//input[@id='specialization']"));

    // Input the credentials
    name.sendKeys("kudez");
    email.sendKeys("kudezx@gmail.com");
    specialization.sendKeys("Cardiologist");

    WebElement addAll = driver.findElement(By.xpath("//button[normalize-space()='Add']"));

    addAll.click();
  }

  private static void getLoginButton(WebDriver driver) {
    // Open the website
    // driver.get("http://127.0.0.1:8081/e-health-app");
    driver.get("http://192.168.49.2:31000/e-health-app");

    // Maximize the browser window
    driver.manage().window().maximize();

    // Find the username and password fields by their HTML attributes
    WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Username ? ']"));
    WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));

    // Input the credentials
    usernameInput.sendKeys("Admin");
    passwordInput.sendKeys("123");

    // Find and click the login button
    WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    loginButton.click();

    // You can add additional steps here, such as verifying if the login was
    // successful
  }

  private static void logout(WebDriver driver) {
    // Find and click the logout button
    WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='SignOut']"));
    logoutButton.click();
  }
}

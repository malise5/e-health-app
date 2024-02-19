package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

  private WebDriver driver;

  @Before
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    // Login only once before any test
    login();
  }

  @After
  public void tearDown() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.quit();
  }

  @Test
  public void testLogin() {
    // String expectedURL = "http://127.0.0.1:8081/e-health-app/doctor";
    String expectedURL = "http://192.168.49.2:31000/e-health-app/doctor";

    Assert.assertTrue("URL path is not as expected", driver.getCurrentUrl().contains(expectedURL));

    // Perform additional test logic, e.g., testAddDoctor
    testAddDoctor();
  }

  // @Test
  public void testAddDoctor() {

    WebElement addedDoctor = addDoctor();

    // Verify that the doctor was added successfully
    Assert.assertNotNull("Doctor was not added successfully", addedDoctor);

    // Perform additional verifications based on the addedDoctor WebElement
    // we can check if the doctor's name, email, or other details are
    // correct
    String doctorName = addedDoctor.findElement(By.xpath("//td[normalize-space()='Halkano']")).getText();
    Assert.assertEquals("Doctor name is incorrect", "Halkano", doctorName);
  }

  private WebElement addDoctor() {

    WebElement addDoctor = driver.findElement(By.xpath("(//button[normalize-space()='Add Doctor'])[1]"));
    addDoctor.click();

    WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
    WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
    WebElement specialization = driver.findElement(By.xpath("//input[@id='specialization']"));

    // Input the credentials
    name.sendKeys("Halkano");
    email.sendKeys("kudezx@gmail.com");
    specialization.sendKeys("Cardiologist");

    WebElement addAll = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
    addAll.click();

    // Wait for the doctor addition process to complete (adjust this based on your
    // application)
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Dynamically locate the added doctor element
    WebElement addedDoctor = driver.findElement(By.xpath("//td[normalize-space()='Halkano']")); // Adjust the XPath

    return addedDoctor;

  }

  private void login() {
    // driver.get("http://127.0.0.1:8081/e-health-app");
    driver.get("http://192.168.49.2:31000/e-health-app");

    // Find the username and password fields by their HTML attributes
    WebElement usernameInput = driver.findElement(By.xpath("//input[@placeholder='Enter Username ? ']"));
    WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));

    // Input the credentials
    usernameInput.sendKeys("Admin");
    passwordInput.sendKeys("123");

    // Find and click the login button
    WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    loginButton.click();
  }
}

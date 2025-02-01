import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "/Users/girishshukla/Documents/chromedriver-mac-arm64/chromedriver");

            // Create a new instance of the ChromeDriver
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Navigate to the login page
            driver.get("https://demoqa.com/login");

            // Locate the username input box by its ID and check if it is displayed and enabled
            WebElement username = driver.findElement(By.id("userName"));
            if (username.isDisplayed() && username.isEnabled()) {
                // Enter the username
                username.sendKeys("girish123");
            }

            // Locate the password input box by its ID and check if it is displayed and enabled
            WebElement password = driver.findElement(By.id("password"));
            if (password.isDisplayed() && password.isEnabled()) {
                // Enter the password
                password.sendKeys("Password@123");
            }

            // Locate the login button by its ID and check if it is displayed and enabled
            WebElement login = driver.findElement(By.id("login"));
            if (login.isDisplayed() && login.isEnabled()) {
                // Click the login button
                login.click();
            }

            // Use WebDriverWait to wait for the element with id 'userName-value' to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
            WebElement userNameValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));

//            // Print statement to verify execution
//            System.out.println("herer");

            // Check if the displayed username matches the input username
            if (userNameValue.getText().equals("girish123")) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

            // Close the browser
            driver.quit();

        } catch (Exception e) {
            System.out.println("Check your Chrome version with Chrome Driver Version ");
            e.printStackTrace(); // Print the stack trace for debugging purposes
        }
    }
}

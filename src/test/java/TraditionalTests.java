import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraditionalTests {

    @Test
    public void openLoginPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/hackathon.html");
    }
}

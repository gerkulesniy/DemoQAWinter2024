import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class ProgressBarTest extends BaseTest{

    @Test
    public void progressBarTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/progress-bar");
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);

//        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//        webDriverWait.until(ExpectedConditions.attributeToBe(demoQAPages.getProgressBarPage().aria_valuenow, "aria-valuenow", "51"));
//        webDriverWait.pollingEvery(Duration.ofMillis(100));
//        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);

        String valueNow;

        while(true){
            valueNow = demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow");
            if (valueNow.equals("52")){
                webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);
                break;

            }
        }





        System.out.println(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
        Assert.assertEquals(valueNow, "52");
    }


}

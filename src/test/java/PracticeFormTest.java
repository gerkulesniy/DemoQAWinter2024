import com.demoqa.entities.PracticeFormEntity;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest{

    @Test
    public void practiceFormTest(){
        driver.get("https://demoqa.com/automation-practice-form");

        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();

        demoQAPages.getPracticeFormPage().fillUpPracticeForm(practiceFormEntity);


    }

    @Test
    public void CalendarTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        demoQAPages.getPracticeFormPage().selectDateMonthYear("30 June 2002");
        Thread.sleep(4000);
    }
}

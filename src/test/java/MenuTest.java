import com.demoqa.helper.WebElementActions;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest{

    @Test
    public void moveToElementTest()  {
        browserHelper.open("https://demoqa.com/menu#");
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
    }
}

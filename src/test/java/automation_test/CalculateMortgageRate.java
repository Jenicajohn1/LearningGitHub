package automation_test;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.ThreadContext;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.NavigationBar;
import utilities.DateUtils;


public class CalculateMortgageRate extends BaseClass{
    WebDriver driver;



    @BeforeMethod
    public void openbrowser () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    @Test
    public void calculateMonthlyPayment () {
        String date = DateUtils.returNextMonth();
        String[] dates = date.split("-");
        String month = dates[0];
        String year = dates[1];

        new NavigationBar(driver)
                .navigateToHome()
                .typeHomePrice("300000")
                .typeDownPayment("60000")
                .clickDownPaymentInDollar()
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectMonth(month)
                .typeYear(year)
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHoi("1000")
                .typeHoa("100")
                .selectLoanType("FHA")
                .selectBuyOrRefiOption("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("1,611.85");
    }

    @AfterMethod
    public void quitBrowser() {
        ActOn.browser(driver).close();
    }

}

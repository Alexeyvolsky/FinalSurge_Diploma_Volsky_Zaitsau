package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import modals.AddNewWorkoutModal;
import modals.OtherCalculators.CaloricNeedsModal;
import modals.OtherCalculators.PaceModal;
import modals.PrintWorkoutsModal;
import modals.QuickAddModal;
import modals.WorkoutCalculators.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
public abstract class BaseTest {
    protected final static String BASE_URL = "https://log.finalsurge.com/";
    protected final static String USERNAME = System.getenv().getOrDefault("EMAIL", PropertyReader.getProperty("finalSurge.username"));
    protected final static String PASSWORD = System.getenv().getOrDefault("PASSWORD", PropertyReader.getProperty("finalSurge.password"));
    protected final static String CARD_NUMBER=System.getenv().getOrDefault("CARD_NUMBER", PropertyReader.getProperty("finalSurge.cardNumber"));
    protected final static String EXPIRY_DATE=System.getenv().getOrDefault("EXPIRY_DATE", PropertyReader.getProperty("finalSurge.cardExpDate"));
    protected final static String CVC=System.getenv().getOrDefault("CVC", PropertyReader.getProperty("finalSurge.cardCVC"));

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DailyVitalsPage dailyVitalsPage;
    protected DashboardPage dashboardPage;
    protected WorkoutsPage workoutsPage;
    protected HeaderNavigatePage headerNavigate;
    protected WorkoutLibraryPage workoutLibraryPage;
    protected IntensityModal intensityModal;
    protected AddNewWorkoutModal addNewWorkoutModal;
    protected QuickAddModal quickAddModal;
    protected WorkoutDetailsPage workoutDetailsPage;
    protected WorkoutReportPage workoutReportPage;
    protected HansonsModal hansonsModal;
    protected McMillanModal mcMillanModal;
    protected TinmanModal tinmanModal;
    protected PalladinoModal palladinoModal;
    protected PaceModal paceCalculator;
    protected CaloricNeedsModal caloricNeedsModal;
    protected PrintWorkoutsModal printWorkoutsModal;
    protected SettingDetailsPage settingDetailsPage;
    protected PrintDetailsPage printDetailsPage;
    protected CalendarPage calendarPage;
    protected TrainingPlansPage trainingPlansPage;
    protected CoachPage coachPage;
    protected CheckoutPage checkoutPage;
    Faker faker = new Faker();

    @Parameters({"browser", "headless"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("Chrome") String browserName, @Optional("true") String headless, ITestContext testContext) throws Exception{
        if (browserName.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless.equals("false"))    {
                options.addArguments("--headless");
            }
            WebDriverManager.chromedriver().setup();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headless.equals("false"))    {
                options.addArguments("--headless");
            }
            WebDriverManager.firefoxdriver().setup();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        dailyVitalsPage = new DailyVitalsPage(driver);
        dashboardPage = new DashboardPage(driver);
        workoutsPage = new WorkoutsPage(driver);
        headerNavigate = new HeaderNavigatePage(driver);
        intensityModal = new IntensityModal(driver);
        addNewWorkoutModal = new AddNewWorkoutModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        workoutReportPage = new WorkoutReportPage(driver);
        workoutLibraryPage = new WorkoutLibraryPage(driver);
        quickAddModal = new QuickAddModal(driver);
        hansonsModal = new HansonsModal(driver);
        mcMillanModal = new McMillanModal(driver);
        tinmanModal = new TinmanModal(driver);
        palladinoModal = new PalladinoModal(driver);
        paceCalculator = new PaceModal(driver);
        caloricNeedsModal = new CaloricNeedsModal(driver);
        printWorkoutsModal = new PrintWorkoutsModal(driver);
        settingDetailsPage = new SettingDetailsPage(driver);
        printDetailsPage = new PrintDetailsPage(driver);
        calendarPage = new CalendarPage(driver);
        trainingPlansPage = new TrainingPlansPage(driver);
        coachPage = new CoachPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get(BASE_URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
}

package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import modals.*;
import modals.OtherCalculators.CaloricNeedsModal;
import modals.OtherCalculators.PaceModal;
import modals.WorkoutCalculators.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected final static String BASE_URL = "https://log.finalsurge.com/";
    protected final static String USERNAME = "aleksvolsky@gmail.com";
    protected final static String PASSWORD = "1234567890QwE";
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
    protected CopyMoveDeleteModal copyMoveDeleteModal;
    Faker faker = new Faker();

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BASE_URL);
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
        copyMoveDeleteModal = new CopyMoveDeleteModal(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

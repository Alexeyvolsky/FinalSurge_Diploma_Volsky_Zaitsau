package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import modals.AddNewWorkoutModal;
import modals.BaseModal;
import modals.OtherCalculators.CaloricNeedsModal;
import modals.OtherCalculators.PaceModal;
import modals.PrintWorkouts;
import modals.SettingModal;
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
    protected DashboardPage dashboardPage;
    protected WorkoutsPage workoutsPage;
    protected HeaderNavigatePage headerNavigate;
    protected WorkoutLibraryPage workoutLibraryPage;
    protected IntensityModal intensity;
    protected AddNewWorkoutModal addNewWorkoutModal;
    protected WorkoutDetailsPage workoutDetailsPage;
    protected WorkoutReportPage workoutReportPage;
    protected BaseModal baseModal;
    protected HansonsModal hansons;
    protected McMillanModal mcMillan;
    protected TinmanModal tinman;
    protected PalladinoModal palladino;
    protected PaceModal paceCalculator;
    protected CaloricNeedsModal caloricNeeds;
    protected PrintWorkouts printWorkouts;
    protected SettingDetailsPage settingDetailsPage;
    protected SettingModal settingModal;
    protected PrintDetailsPage printDetailsPage;

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
        dashboardPage = new DashboardPage(driver);
        workoutsPage = new WorkoutsPage(driver);
        headerNavigate = new HeaderNavigatePage(driver);
        intensity = new IntensityModal(driver);
        addNewWorkoutModal = new AddNewWorkoutModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        workoutReportPage = new WorkoutReportPage(driver);
        workoutLibraryPage = new WorkoutLibraryPage(driver);
        baseModal = new BaseModal(driver);
        hansons = new HansonsModal(driver);
        mcMillan = new McMillanModal(driver);
        tinman = new TinmanModal(driver);
        palladino = new PalladinoModal(driver);
        paceCalculator = new PaceModal(driver);
        caloricNeeds = new CaloricNeedsModal(driver);
        printWorkouts = new PrintWorkouts(driver);
        settingDetailsPage = new SettingDetailsPage(driver);
        settingModal = new SettingModal(driver);
        printDetailsPage = new PrintDetailsPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

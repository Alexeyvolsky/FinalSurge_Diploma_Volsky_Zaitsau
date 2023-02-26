package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import modals.AddNewWorkoutModal;
import modals.BaseModal;
import modals.OtherCalculators.CaloricNeeds;
import modals.OtherCalculators.PaceCalculator;
import modals.PrintWorkouts;
import modals.SettingModal;
import modals.WorkoutCalculators.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    protected HeaderNavigate headerNavigate;
    protected Intensity intensity;
    protected AddNewWorkoutModal addNewWorkoutModal;
    protected WorkoutDetailsPage workoutDetailsPage;
    protected WorkoutReportPage workoutReportPage;
    protected BaseModal baseModal;
    protected Hansons hansons;
    protected McMillan mcMillan;
    protected Tinman tinman;
    protected Palladino palladino;
    protected PaceCalculator paceCalculator;
    protected CaloricNeeds caloricNeeds;
    protected PrintWorkouts printWorkouts;
    protected SettingDetailsPage settingDetailsPage;
    protected SettingModal settingModal;
    protected PrintDetailsPage printDetailsPage;
    protected CalendarPage calendarPage;

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
        headerNavigate = new HeaderNavigate(driver);
        intensity = new Intensity(driver);
        addNewWorkoutModal = new AddNewWorkoutModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        workoutReportPage = new WorkoutReportPage(driver);
        baseModal = new BaseModal(driver);
        hansons = new Hansons(driver);
        mcMillan = new McMillan(driver);
        tinman = new Tinman(driver);
        palladino = new Palladino(driver);
        paceCalculator = new PaceCalculator(driver);
        caloricNeeds = new CaloricNeeds(driver);
        printWorkouts = new PrintWorkouts(driver);
        settingDetailsPage = new SettingDetailsPage(driver);
        settingModal = new SettingModal(driver);
        printDetailsPage = new PrintDetailsPage(driver);
        calendarPage = new CalendarPage(driver);
    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }
}

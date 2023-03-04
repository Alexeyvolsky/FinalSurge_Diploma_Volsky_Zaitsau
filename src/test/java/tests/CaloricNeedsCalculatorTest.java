package tests;

import enums.DistTypeCaloricNeeds;
import enums.Gender;
import enums.HeightType;
import enums.WeightType;
import io.qameta.allure.Description;
import models.OtherCalculators.CaloricNeedsCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

public class CaloricNeedsCalculatorTest extends BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickOtherCalculatorsButton();
        caloricNeedsModal.openIframeOtherCalculator();
    }

    @Description("Verify that CaloricNeeds calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positiveCaloricNeedsTest()  {
        CaloricNeedsCalculator caloricNeedsValue = CaloricNeedsCalculator.builder()
                .setWeight(String.valueOf(faker.number().numberBetween(30, 500))).setWeightType(WeightType.KG)
                .setHeight(String.valueOf(faker.number().numberBetween(120, 210))).setHeightType(HeightType.CENTIMETERS)
                .setAge(String.valueOf(faker.number().numberBetween(5, 99))).setGender(Gender.MALE)
                .setRunDistance(String.valueOf(faker.number().numberBetween(0, 500)))
                .setDistTypeCaloricNeeds(DistTypeCaloricNeeds.MILES).build();
        caloricNeedsModal.fillForm(caloricNeedsValue);
        caloricNeedsModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(caloricNeedsModal.isGreenBoxDisplay());
    }

    @Description("Verify that ValoricNeeds calculator correct work with bad data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class, dataProvider = "negativeCaloricNeedsList")
    public void negativeCaloricNeedsTest(CaloricNeedsCalculator caloricNeedsValue)  {
        caloricNeedsModal.fillForm(caloricNeedsValue);
        caloricNeedsModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(caloricNeedsModal.alertErrorMessageIsPresent());
    }

    @DataProvider(name = "negativeCaloricNeedsList")
    public Object [][] negativeCalculatorNeedsList()    {
        return new Object[][]   {
                {CaloricNeedsCalculator.builder().setWeight("4£$$").setWeightType(WeightType.LBS).setHeight("%$%$%")
                        .setHeightType(HeightType.CENTIMETERS).setAge("%$%$%").setGender(Gender.FEMALE)
                        .setRunDistance("%$%$").setDistTypeCaloricNeeds(DistTypeCaloricNeeds.KILOMETERS).build()},
                {CaloricNeedsCalculator.builder().setWeight("").setWeightType(WeightType.KG).setHeight("")
                        .setHeightType(HeightType.CENTIMETERS).setAge("").setGender(Gender.FEMALE)
                        .setRunDistance("").setDistTypeCaloricNeeds(DistTypeCaloricNeeds.KILOMETERS).build()},
                {CaloricNeedsCalculator.builder().setWeight(String.valueOf(faker.number().numberBetween(501, 1000)))
                        .setWeightType(WeightType.KG).setHeight(String.valueOf(faker.number().numberBetween(0, 50)))
                        .setHeightType(HeightType.CENTIMETERS).setAge(String.valueOf(faker.number().numberBetween(100, 1000)))
                        .setGender(Gender.FEMALE).setRunDistance(String.valueOf(faker.number().numberBetween(501, 1000)))
                        .setDistTypeCaloricNeeds(DistTypeCaloricNeeds.KILOMETERS).build()},
        };
    }
}

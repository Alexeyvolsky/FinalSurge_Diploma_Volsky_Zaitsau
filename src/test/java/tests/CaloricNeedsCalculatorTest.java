package tests;

import enums.DistTypeCaloricNeeds;
import enums.Gender;
import enums.HeightType;
import enums.WeightType;
import io.qameta.allure.Description;
import models.OtherCalculators.CaloricNeedsCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaloricNeedsCalculatorTest extends BaseTest  {

    @BeforeClass()
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickOtherCalculatorsButton();
        baseModal.openIframeOtherCalculator();
    }

    @Description("Verify that CaloricNeeds calculator counts data")
    @Test
    public void positiveCaloricNeedsTest()  {
        CaloricNeedsCalculator caloricNeedsValue = CaloricNeedsCalculator.builder()
                .setWeight(String.valueOf(faker.number().numberBetween(30, 500))).setWeightType(WeightType.KG)
                .setHeight(String.valueOf(faker.number().numberBetween(120, 210))).setHeightType(HeightType.CENTIMETERS)
                .setAge(String.valueOf(faker.number().numberBetween(5, 99))).setGender(Gender.MALE)
                .setRunDistance(String.valueOf(faker.number().numberBetween(0, 500)))
                .setDistTypeCaloricNeeds(DistTypeCaloricNeeds.MILES).build();
        caloricNeeds.fillForm(caloricNeedsValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Today's Caloric Needs"));
    }

    @Description("Verify that ValoricNeeds calculator correct work with bad data")
    @Test(dataProvider = "negativeCaloricNeedsList")
    public void negativeCaloricNeedsTest(CaloricNeedsCalculator caloricNeedsValue)  {
        caloricNeeds.fillForm(caloricNeedsValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.alertErrorMessageIsPresent());
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
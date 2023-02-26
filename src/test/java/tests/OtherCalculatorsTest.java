package tests;

import enums.*;
import models.OtherCalculators.CaloricNeeds;
import models.OtherCalculators.PaceCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OtherCalculatorsTest extends BaseTest  {

    @BeforeClass()
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickOtherCalculatorsButton();
        baseModal.openIframeOtherCalculator();
    }

    @Test
    public void positivePaceCalculatorTest()    {
        baseModal.clickPaceCalculatorButton();
        PaceCalculator paceCalculatorValue = PaceCalculator.builder().setRunDistance("10")
                .setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS).setHours("1").setMinutes("5")
                .setSeconds("43").build();
        paceCalculator.fillForm(paceCalculatorValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Pace Chart"));
    }

    // TODO: locator
    @Test
    public void positiveCaloricNeedsTest()  {
        CaloricNeeds caloricNeedsValue = CaloricNeeds.builder().setWeight("87").setWeightType(WeightType.KG)
                .setHeight("180").setHeightType(HeightType.CENTIMETERS).setAge("23").setGender(Gender.MALE)
                .setRunDistance("10").setDistTypeCaloricNeeds(DistTypeCaloricNeeds.MILES).build();
        caloricNeeds.fillForm(caloricNeedsValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Today's Caloric Needs"));
    }

    @Test(dataProvider = "negativePaceCalculatorList")
    public void negativePaceCalculatorTest(PaceCalculator paceCalculatorValue)    {
        baseModal.clickPaceCalculatorButton();
        paceCalculator.fillForm(paceCalculatorValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.alertErrorMessageIsPresent());
    }

    @Test(dataProvider = "negativeCaloricNeedsList")
    public void negativeCaloricNeedsTest(CaloricNeeds caloricNeedsValue)  {
        caloricNeeds.fillForm(caloricNeedsValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.alertErrorMessageIsPresent());
    }

    @DataProvider(name = "negativePaceCalculatorList")
    public Object [][] negativePaceCalculatorList() {
        return new Object[][]   {
                {PaceCalculator.builder().setRunDistance("%$%$").setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                        .setHours("%$%$%").setMinutes("%%$%$").setSeconds("%$$%$%").build()},
                {PaceCalculator.builder().setRunDistance("1000").setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                        .setHours("").setMinutes("13").setSeconds("").build()},
                {PaceCalculator.builder().setRunDistance("").setDistTypePaceCalculator(DistTypePaceCalculator.MILES)
                        .setHours("").setMinutes("").setSeconds("").build()},
                {PaceCalculator.builder().setRunDistance("10").setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                        .setHours("").setMinutes("").setSeconds("").build()},
        };
    }

    @DataProvider(name = "negativeCaloricNeedsList")
    public Object [][] negativeCalculatorNeedsList()    {
        return new Object[][]   {
                {CaloricNeeds.builder().setWeight("4£$$").setWeightType(WeightType.LBS).setHeight("1")
                        .setHeightType(HeightType.CENTIMETERS).setAge("£").setGender(Gender.FEMALE)
                        .setRunDistance("%$%$").setDistTypeCaloricNeeds(DistTypeCaloricNeeds.KILOMETERS).build()},
                {CaloricNeeds.builder().setWeight("").setWeightType(WeightType.KG).setHeight("")
                        .setHeightType(HeightType.CENTIMETERS).setAge("").setGender(Gender.FEMALE)
                        .setRunDistance("").setDistTypeCaloricNeeds(DistTypeCaloricNeeds.KILOMETERS).build()},
                {CaloricNeeds.builder().setWeight("100").setWeightType(WeightType.KG).setHeight("")
                        .setHeightType(HeightType.CENTIMETERS).setAge("81").setGender(Gender.FEMALE)
                        .setRunDistance("").setDistTypeCaloricNeeds(DistTypeCaloricNeeds.KILOMETERS).build()},
        };
    }
}
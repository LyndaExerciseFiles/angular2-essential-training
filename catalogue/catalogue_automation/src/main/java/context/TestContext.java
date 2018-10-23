package context;

import au.com.infomedia.epch.managers.PageObjectManager;
import au.com.infomedia.epch.managers.StepManager;
import au.com.infomedia.epch.managers.WebDriverManager;
import au.com.infomedia.epch.managers.testDataManagers.JsonDataReader;

import java.io.IOException;

public class TestContext {
    private static ThreadLocal<WebDriverManager> currentWebDriverManager = new ThreadLocal<>();

    private String featureName;
    private String scenarioName;

    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private StepManager stepManager;
    private ScenarioContext scenarioContext;

    private Object testData;


  public TestContext() {
    webDriverManager = new WebDriverManager();
    pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    scenarioContext = new ScenarioContext();
    currentWebDriverManager.set(webDriverManager);
    stepManager = new StepManager(this);
  }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public static WebDriverManager getCurrentWebDriverManager() {
        return currentWebDriverManager.get();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

  public StepManager getStepManager() {
    return stepManager;
  }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public Object getTestData() {
        return testData;
    }

    public void setTestData(String featureName) throws IOException {
        if (testData == null) {
            testData = JsonDataReader.readTestDataFile(featureName);
        }
    }
}

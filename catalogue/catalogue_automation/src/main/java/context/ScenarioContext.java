package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public <T> void setContext(String key, T value) {
        scenarioContext.put(key, value);
    }

    public <T> T getContext(String key){
        return (T) scenarioContext.get(key);
    }

    public Boolean isContains(String key){
        return scenarioContext.containsKey(key);
    }

}

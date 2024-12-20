package validation;

import importFile.Constants;
import importFile.ImportStrategyDownloads;

import java.util.HashMap;
import java.util.Map;

public class ImportValidStategyHelper {
    private static ImportValidStategyHelper instance;
    private final Map<Integer, ValidStrategy> validStrategyMap;

    public static ImportValidStategyHelper getInstance() {
        if (instance == null) {
            instance = new ImportValidStategyHelper();
        }
        return instance;
    }
    public ImportValidStategyHelper() {
        this.validStrategyMap = new HashMap<>();
        this.validStrategyMap.put(Constants.PERSON, new ValidPerson());
        //this.validStrategyMap
    }

       public ValidPerson resolveValidStrategy(Integer strategyID) {
        return (ValidPerson) this.validStrategyMap.get(strategyID);
    }
}

package importFile;

import importFile.downloadType.ImportFromConsole;
import importFile.downloadType.ImportFromFile;

import java.util.HashMap;
import java.util.Map;

public class ImportStrategyHelper {
    private static ImportStrategyHelper instance;
    private final Map<Integer, ImportStrategyDownloads> importStrategyDownloadsMap;

    public static ImportStrategyHelper getInstance() {
        if (instance == null) {
            instance = new ImportStrategyHelper();
        }
        return instance;
    }

    private ImportStrategyHelper() {
        this.importStrategyDownloadsMap = new HashMap<>();
        this.importStrategyDownloadsMap.put(Constants.IMPORT_FROM_FILE, new ImportFromFile());
        this.importStrategyDownloadsMap.put(Constants.IMPORT_FROM_CONSOLE, new ImportFromConsole());
    }

    public ImportStrategyDownloads resolveDownloadsStrategy(Integer strategyID) {
        return this.importStrategyDownloadsMap.get(strategyID);
    }
 }

package global;

public class Const {
    public static final int DEFAULT_TIMEOUT_SECONDS = 10;
    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String BROWSER_EDGE = "edge";
    public static final String CONFIG_FILE = System.getProperty("user.dir") + "\\config\\config.properties";
    public static final String DATA_FILE = System.getProperty("user.dir") + "\\data\\test-data.json";
    private static final String OBJECT_REPO_DIR = System.getProperty("user.dir") + "\\src\\main\\resources\\object-repo\\";
    public static final String PAGES_WAITING = OBJECT_REPO_DIR + "pages.waiting.properties";
    public static final String OBJ_LOGIN_PAGE = OBJECT_REPO_DIR + "login.properties";
    public static final String OBJ_HOME_PAGE = OBJECT_REPO_DIR + "home.properties";
}
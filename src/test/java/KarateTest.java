import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static com.intuit.karate.Runner.runFeature;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KarateTest extends TestBase {

    @Test
    void testSample() {
        Results results = Runner.path("classpath:external")
                .outputCucumberJson(true)
                .outputHtmlReport(false)
                .tags("~@ignore")
                .backupReportDir(false)
                .parallel(3);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount());
    }

    @Test
    void testParallel() {
        Results results = Runner.path("classpath:parallel")
                .outputCucumberJson(true)
                .outputHtmlReport(false)
                .tags("~@ignore")
                .backupReportDir(false)
                .parallel(10);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount());
    }

    @Test
    void testOrder() {
        Results results = Runner.path("classpath:order")
                .outputCucumberJson(true)
                .outputHtmlReport(false)
                .tags("~@ignore")
                .backupReportDir(false)
                .parallel(3);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount());
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

    @BeforeAll
    public void beforeAll() {
        runFeature("classpath:common/setup.feature", new HashMap<>(), true);
    }
//
//    @AfterAll
//    public void afterAll() {
//        runFeature("classpath:common/destroy-data.feature", new HashMap<>(), true);
//    }

}

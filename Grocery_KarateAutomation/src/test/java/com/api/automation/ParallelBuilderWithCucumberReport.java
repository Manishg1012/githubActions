package com.api.automation;
// 
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
// 
//import org.apache.commons.io.FileUtils;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
// 
//import com.intuit.karate.Results;
//import com.intuit.karate.Runner;
////import com.intuit.karate.junit5.Karate.Test;
//import com.intuit.karate.Runner.Builder;
// 
//import net.masterthought.cucumber.Configuration;
//import net.masterthought.cucumber.ReportBuilder;
// 
//public class ParallelBuilderWithCucumberReport {
//	@Test
//	public void executeKarateTest() {
// 
//		Results result = Runner.path("classpath:com/api/automation") .outputCucumberJson(true).parallel(5);
//		System.out.println("Total Feature => " + result.getFeaturesTotal());
//		System.out.println("Total Scenarios => " + result.getScenariosTotal());
//		System.out.println("Total Feature => " + result.getFailCount());
//		System.out.println("Scenario count =>" + result.getScenariosPassed());
//		generateCucumberReport(result.getReportDir());
//		Assertions.assertEquals(0, result.getFailCount(), "There are some Failed scenarios");
//	}
// 
//	private void generateCucumberReport(String reportDirLocation) {
//		File reportDir = new File(reportDirLocation);
//		Collection<File> jsonCollection = FileUtils.listFiles(reportDir, new String[] { "json" }, true);
//		List<String> jsonFiles = new ArrayList<String>();
//		jsonCollection.forEach(file -> jsonFiles.add(file.getAbsolutePath()));
// 
//		Configuration configuration = new Configuration(reportDir, "Karate Run");
//		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//		reportBuilder.generateReports();
// 
//	}
//}





 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
 
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
 
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
 
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import org.apache.commons.io.FileUtils;
 
public class ParallelBuilderWithCucumberReport {
    @Test
    public void executeKarateTest() {
        Results result = Runner.path("classpath:com/api/automation/master.feature") // Specify the path to your test runner file
                                 .outputCucumberJson(true)
                                 .parallel(5);
        System.out.println("Total Feature => " + result.getFeaturesTotal());
        System.out.println("Total Scenarios => " + result.getScenariosTotal());
        System.out.println("Failed Scenario count  => " + result.getFailCount());
        System.out.println("Passed Scenario count =>" + result.getScenariosPassed());
        generateCucumberReport(result.getReportDir());
        Assertions.assertEquals(0, result.getFailCount(), "There are some Failed scenarios");
    }
 
    private void generateCucumberReport(String reportDirLocation) {
        File reportDir = new File(reportDirLocation);
        Collection<File> jsonCollection = FileUtils.listFiles(reportDir, new String[] { "json" }, true);
        List<String> jsonFiles = new ArrayList<String>();
        jsonCollection.forEach(file -> jsonFiles.add(file.getAbsolutePath()));
 
        Configuration configuration = new Configuration(reportDir, "Karate Run");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
 
 
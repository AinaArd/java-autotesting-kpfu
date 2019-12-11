package tests;

import app.ApplicationManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Education;
import org.junit.Before;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestBase {
    protected static ApplicationManager applicationManager;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        applicationManager = getInstance();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() throws IOException {

        File file = new File("testData.txt");
        FileReader fileReader = new FileReader(file);
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            line = bufferedReader.readLine();
        }
        System.out.println(line);
        List<Education> string = Arrays.asList(mapper.readValue(line, Education[].class));

        return new Object[][]{{string.get(0).getDateStart(), string.get(0).getDateEnd(), string.get(0).getOrganization()},
                {string.get(1).getDateStart(), string.get(1).getDateEnd(), string.get(1).getOrganization()}};
    }

    protected ApplicationManager getInstance() {
        if (applicationManager == null) {
            applicationManager = new ApplicationManager();
        }
        return applicationManager;
    }

}

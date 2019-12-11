package tests;

import helpers.AuthBase;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, Test2.class, Test3.class})
public class TestSuite extends AuthBase {

    @AfterClass
    public static void tearDown() throws Exception {
        applicationManager.close();
    }
}

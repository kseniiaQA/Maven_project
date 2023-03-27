package tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ArticleTests;
import tests.OrientationTests;
import tests.SearchTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArticleTests.class,
        OrientationTests.class,
        SearchTests.class
})
public class TestSuite {
}

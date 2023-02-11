import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class TestBase {

    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    public void beforeAll() {

    }

    @AfterAll
    public void afterAll() {
    }

}


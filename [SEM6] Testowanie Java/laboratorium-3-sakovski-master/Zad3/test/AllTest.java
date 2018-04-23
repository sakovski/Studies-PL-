import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QuadraticFunctionCorrect.class, QuadraticFunctionError.class })
public class AllTest {
  
}

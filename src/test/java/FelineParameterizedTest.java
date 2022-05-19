import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int expected;
    private Feline feline;

    public FelineParameterizedTest(int expected) {
        this.expected = expected;
    }

    @Before
    public void setup(){
        feline = new Feline();
    }

    @Parameterized.Parameters
    public static Object[][] getParamData() {
        return new Object[][] {
                {1},
                {2},
                {3},
        };
    }

    @Test
    public void testGetKittens(){
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual);
    }
}

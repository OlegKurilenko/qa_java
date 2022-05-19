import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(feline, "Самец");
        when(feline.getKittens()).thenReturn(10);
        int actual = lion.getKittens();
        assertEquals(10, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actual = lion.getFood();
        assertEquals(expectedFood, actual);
    }

    @Test(expected = Exception.class)
    public void testLionSexException() throws Exception {
        lion = new Lion(feline, "Пол не определен");
    }
}

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Mock
    private Feline felineMock;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        assertEquals(felineMock.getKittens(), lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void exceptionTest() {
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = assertThrows(Exception.class, () -> new Lion("Cfvtw", felineMock)); //на английской раскладке "Самец"
        assertEquals(expectedMessage, exception.getMessage());
    }

}

import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;

public class BunTest {

    @Test
    public void getNameReturnRightName() {
        Bun bun = new Bun("Булочка c кунжутом", 27.5F);
        String actualResult = bun.getName();
        String expectedResult = "Булочка c кунжутом";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceReturnRightPrice() {
        Bun bun = new Bun("Булочка c кунжутом", 27.5F);
        float actualResult = bun.getPrice();
        float expectedResult = 27.5F;
        assertEquals(expectedResult, actualResult);
    }

}

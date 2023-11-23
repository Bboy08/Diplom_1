import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @InjectMocks
    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    private final IngredientType sauceType = IngredientType.SAUCE;
    private final String sauceName = "Mayonnaise";
    private final float saucePrice = 100F;
    private final String bunName = "Bread";
    private final float bunPrice = 50F;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(mockIngredient);
        assertTrue(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient mockIngredient2 = mock(Ingredient.class);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient.getPrice()).thenReturn(100f);
        burger.addIngredient(mockIngredient);
        assertEquals(300f, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        float totalPrice = (bunPrice * 2) + saucePrice;
        String receiptER = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bunName, sauceType.toString().toLowerCase(), sauceName, bunName, totalPrice);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIngredient.getType()).thenReturn(sauceType);
        Mockito.when(mockIngredient.getName()).thenReturn(sauceName);
        Mockito.when(mockIngredient.getPrice()).thenReturn(saucePrice);
        assertEquals(receiptER, burger.getReceipt());
    }

}

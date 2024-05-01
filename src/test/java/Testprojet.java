package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import monprojet.SommeArgent;
import monprojet.UniteDistincteException;

public class Testprojet {
    
	private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;
	
    private static int passage = 0;
    
	@BeforeEach
    public void setUp() {
		m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
      //  passage++;
        //System.out.println(passage + "ime passage avant exécution d'une méthode de test");
    }
	//@AfterEach
    //public void configAprés() {
      //  System.out.println(passage + "ime passage APRES exécution d'une méthode de test");
   // }
	
    @Test
    public void testAddition() {
    	try {
            SommeArgent actualSum = m12CHF.add(m14CHF);
            SommeArgent expectedSum = new SommeArgent(26, "CHF");
            assertEquals(expectedSum, actualSum);
        } catch (UniteDistincteException e) {
            fail("L'addition a échoué avec l'exception: " + e.getMessage());
        }
  
     }
    
    @Test
    public void testAdditionUniteDistincteException() {
            SommeArgent m12CHF = new SommeArgent(12, "CHF");
            SommeArgent m14USD = new SommeArgent(14, "USD");

            assertThrows(UniteDistincteException.class, () -> {
                m12CHF.add(m14USD);
            });
     }
    
    @Test
    public void testEquals() {
    
        assertFalse(m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new SommeArgent(12, "CHF"));
        assertFalse(m12CHF.equals(m14CHF));
        assertFalse(m14USD.equals(m14CHF));
    }
}

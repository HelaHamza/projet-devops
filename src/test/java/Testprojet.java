package test.java;

import org.junit.jupiter.api.Test;

import main.java.resources.SommeArgent;
import main.java.resources.PorteMonnaie;
import main.java.resources.UniteDistincteException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class Testprojet {

    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;

    @BeforeEach
    public void setUp() {
        m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
    }

    @Test
    public void testAdditionUniteDistincteException() {
        assertThrows(UniteDistincteException.class, () -> {
            m12CHF.add(m14USD);
        });
     }
    

    @Test
    public void testEquals() {
        assertNotNull(m12CHF); // Vérifier que m12CHF n'est pas null
        assertFalse(m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new SommeArgent(12, "CHF"));
        assertFalse(m12CHF.equals(m14CHF));
        assertFalse(m14USD.equals(m14CHF));
    }
}


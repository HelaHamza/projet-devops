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
        // Créer deux sommes d'argent avec des unités différentes
        SommeArgent m12CHF = new SommeArgent(12, "CHF");
        SommeArgent m14USD = new SommeArgent(14, "USD");

        // On s'attend à ce qu'une UniteDistincteException soit lancée lors de l'addition
        assertThrows(UniteDistincteException.class, () -> {
            m12CHF.add(m14USD);
        });
    }
    @Test
    public void testEquals() {
        // Création de deux porte-monnaie avec le même contenu
        PorteMonnaie porteMonnaie1 = new PorteMonnaie();
        PorteMonnaie porteMonnaie2 = new PorteMonnaie();
        porteMonnaie1.ajouteSomme(new SommeArgent(10, "EUR"));
        porteMonnaie1.ajouteSomme(new SommeArgent(20, "USD"));
        porteMonnaie2.ajouteSomme(new SommeArgent(10, "EUR"));
        porteMonnaie2.ajouteSomme(new SommeArgent(20, "USD"));

        // On s'attend à ce que les deux porte-monnaie soient égaux
        assertTrue(porteMonnaie1.equals(porteMonnaie2));

        // Ajouter une somme supplémentaire à porteMonnaie1
        porteMonnaie1.ajouteSomme(new SommeArgent(5, "EUR"));

        // On s'attend à ce que les deux porte-monnaie soient maintenant différents
        assertFalse(porteMonnaie1.equals(porteMonnaie2));
    }
    
    
    
    
    
}


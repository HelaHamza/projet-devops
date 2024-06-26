package test.java;

import org.junit.jupiter.api.Test;

import main.java.resources.SommeArgent;
import main.java.resources.UniteDistincteException;
import main.java.resources.PorteMonnaie;

import static org.junit.jupiter.api.Assertions.*;

public class TestPorteMonnaie {
	
    @Test
    public void testAjouteSomme() {
        PorteMonnaie porteMonnaie1 = new PorteMonnaie();
        PorteMonnaie porteMonnaie2 = new PorteMonnaie();

        // Ajouter 5 euros à porteMonnaie1
        porteMonnaie1.ajouteSomme(new SommeArgent(5, "EUR"));

        // Ajouter 5 autres euros à porteMonnaie1
        porteMonnaie1.ajouteSomme(new SommeArgent(5, "EUR"));
        
        // Ajouter 10 euros à porteMonnaie2
        porteMonnaie2.ajouteSomme(new SommeArgent(10, "EUR"));

        // On s'attend à ce que porteMonnaie1 et porteMonnaie2 soient égaux
        assertTrue(porteMonnaie1.equals(porteMonnaie2));
    }

    @Test
    public void testEquals() {
        PorteMonnaie porteMonnaie1 = new PorteMonnaie();
        PorteMonnaie porteMonnaie2 = new PorteMonnaie();

        // Ajouter 5 euros à porteMonnaie1
        porteMonnaie1.ajouteSomme(new SommeArgent(5, "EUR"));

        // Ajouter 7 dollars à porteMonnaie2
        porteMonnaie2.ajouteSomme(new SommeArgent(7, "USD"));

        // On s'attend à ce que porteMonnaie1 et porteMonnaie2 soient différents
        assertFalse(porteMonnaie1.equals(porteMonnaie2));
    }
    @Test
    public void testEqualsInstance() {
        // Créer deux instances de PorteMonnaie
        PorteMonnaie porteMonnaie1 = new PorteMonnaie();
        PorteMonnaie porteMonnaie2 = new PorteMonnaie();

        // Ajouter 5 euros à porteMonnaie1
        porteMonnaie1.ajouteSomme(new SommeArgent(5, "EUR"));

        // Ajouter 7 dollars à porteMonnaie2
        porteMonnaie2.ajouteSomme(new SommeArgent(7, "USD"));

        // On s'attend à ce que porteMonnaie1 et porteMonnaie2 soient différents
        assertFalse(porteMonnaie1.equals(porteMonnaie2));
    }
    @Test
    public void testAddition() {
        SommeArgent somme1 = new SommeArgent(10, "EUR");
        SommeArgent somme2 = new SommeArgent(20, "EUR");
        
        try {
            SommeArgent resultat = somme1.add(somme2);
            assertEquals(30, resultat.getQuantite());
            assertEquals("EUR", resultat.getUnite());
        } catch (UniteDistincteException e) {
            fail("Une exception d'unité distincte ne devrait pas être lancée ici");
        }
    
}}

package monprojet;
import org.junit.Test;
import static org.junit.Assert.*;

public class SommeArgent {
	private int quantite;
	private String unite;
	public SommeArgent(int amount, String currency)
	{ quantite = amount;
	  unite = currency;
	}
	public int getQuantite() {
	return quantite;
	}
	public String getUnite() {
	return unite;
	}
	public SommeArgent add(SommeArgent m) throws UniteDistincteException {
	    if (!this.unite.equals(m.unite)) {
	        throw new UniteDistincteException("Les sommes d'argent ont des unités différentes : " 
	                                             + this.unite + " et " + m.unite);
	    }
	    return new SommeArgent(getQuantite() + m.getQuantite(), getUnite());
	}
	@Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true; 
        if (anObject == null || getClass() != anObject.getClass()) return false; 
        SommeArgent other = (SommeArgent) anObject; 
        return quantite == other.quantite && unite.equals(other.unite); 
    }

    // Test method 
    public static void main(String[] args) {
        SommeArgent m1 = new SommeArgent(100, "USD");
        SommeArgent m2 = new SommeArgent(50, "USD");

        // test méthode equal
        System.out.println("m1 equals m1: " + m1.equals(m1)); //  true
        System.out.println("m1 equals m2: " + m1.equals(m2)); // false
        System.out.println("m2 equals m2: " + m2.equals(m2)); //   true

        // Testing addition
        SommeArgent sum;
		try {
			sum = m1.add(m2);
			 System.out.println("Sum of m1 and m2: " + sum.getQuantite() + " " + sum.getUnite()); // 150 USD
		} catch (UniteDistincteException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public String toString() {
        return quantite + " " + unite;
    }
}

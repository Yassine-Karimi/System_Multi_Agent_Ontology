package ma.enset.sma;

import jade.content.Predicate;
import jade.core.AID;

public class Disponible implements Predicate {
    private AID seller;
    private Product product;

    public AID getSeller() {
        return seller;
    }

    public void setSeller(AID seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

package ma.enset.sma;

import jade.content.AgentAction;
import jade.core.AID;

public class Sell implements AgentAction {
    private AID buyer;
    private Product product;

    public AID getBuyer() {
        return buyer;
    }

    public void setBuyer(AID buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

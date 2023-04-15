package ma.enset.sma;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.lang.xml.XMLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class SellerAgent extends Agent {
    private Ontology catalogOntology=CatalogOntology.getCatalogOntology();
    private XMLCodec codec= new XMLCodec();

    @Override
    protected void setup() {
      getContentManager().registerOntology(catalogOntology);
      getContentManager().registerLanguage(codec);

      Usb usb=new Usb();
      usb.setName("SAMSUNG A30");
      usb.setPrice(2500);
      usb.setCapacity(39999);

      Disponible disponible=new Disponible();
      disponible.setProduct(usb);
      disponible.setSeller(new AID("buyer",AID.ISLOCALNAME));

        ACLMessage message=new ACLMessage(ACLMessage.QUERY_IF);
        message.addReceiver(new AID("buyer",AID.ISLOCALNAME));
        message.setOntology(catalogOntology.getName());
        message.setLanguage(codec.getName());
        try {
            getContentManager().fillContent(message,disponible);
            send(message);
        } catch (Codec.CodecException e) {
            e.printStackTrace();
        } catch (OntologyException e) {
            e.printStackTrace();
        }
    }
}

package ma.enset.sma;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.lang.xml.XMLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BuyerAgentXML extends Agent {
    private Ontology catalogOntology=CatalogOntology.getCatalogOntology();
    private XMLCodec xmlCodec = new XMLCodec();

    @Override
    protected void setup() {
     getContentManager().registerOntology(catalogOntology);
     getContentManager().registerLanguage(xmlCodec);
        MessageTemplate messageTemplate=MessageTemplate.and
                (
                        MessageTemplate.MatchOntology(CatalogOntology.ONTOLOGY_NAME),
        MessageTemplate.MatchLanguage(xmlCodec.getName()));

        ACLMessage receivedMessage = blockingReceive(messageTemplate);
        try {
            Disponible disponible = (Disponible)getContentManager().extractContent(receivedMessage);
            System.out.println(disponible.getProduct().getName()+disponible.getProduct().getPrice());
        } catch (Codec.CodecException e) {
            e.printStackTrace();
        } catch (OntologyException e) {
            e.printStackTrace();
        }

    }
}

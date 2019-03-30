package za.co.reference.xpath.example2;

import javax.xml.xpath.XPathConstants;
import org.w3c.dom.*;

public class XPathReaderTest {
    
    public XPathReaderTest() {
    }
    
    public static void main(String[] args){
        
        XPathReader reader = new XPathReader("src\\com\\javabeat\\tips\\xpath\\projects.xml");
        
        // To get a xml attribute.
        String expression = "/projects/project[1]/@id";
        System.out.println(reader.read(expression, XPathConstants.STRING) + "\n");
        
        // To get a child element's value.'
        expression = "/projects/project[2]/name";
        System.out.println(reader.read(expression, XPathConstants.STRING) + "\n");
        
        // To get an entire node
        expression = "/projects/project[3]";
        NodeList thirdProject = (NodeList)reader.read(expression, XPathConstants.NODESET);
        traverse(thirdProject);
    }

    private static void traverse(NodeList rootNode){
        for (int index = 0; index < rootNode.getLength(); index ++){
            Node aNode = rootNode.item(index);
            if (aNode.getNodeType() == Node.ELEMENT_NODE){
                NodeList childNodes = aNode.getChildNodes();            
                if (childNodes.getLength() > 0){
                    System.out.println("Node Name-->" + aNode.getNodeName() + " , Node Value-->" +  
                    	aNode.getTextContent());
                }
                traverse(aNode.getChildNodes());                
            }
        }        
    }
}

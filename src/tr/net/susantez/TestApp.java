package tr.net.susantez;

import tr.net.susantez.dataMapping.Metadata;
import tr.net.susantez.service.MetadataReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by serkan.susantez on 4/11/2017.
 */
public class TestApp {

    public static void main(String[] args) {
        TestApp testApp = new TestApp();
        testApp.parse();
    }

    public void parse() {
        XMLStreamReader reader = null;
        try {
            File file = new File("c:\\metadata.xml");
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            reader = inputFactory.createXMLStreamReader(new FileInputStream(file));
            MetadataReader mr = new MetadataReader(reader);
            mr.parseMetadata();
            System.out.println(mr.getNameSpaceList());
        } catch (FileNotFoundException | FactoryConfigurationError | XMLStreamException ex) {
            ex.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (XMLStreamException t) {
                    t.printStackTrace();
                }
            }
        }
    }
}

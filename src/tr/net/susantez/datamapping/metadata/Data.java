package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/17/2017.
 * Represents DataDefinitionDictionary tag in ConceptWave Metadata.xml
 */
public class Data {
    private List<BasicObject> dataTypeDictionary;
    private List<Element> elementDictionary;

    public Data() {
        dataTypeDictionary = new ArrayList<>();
        elementDictionary = new ArrayList<>();
    }

    public List<BasicObject> getDataTypeDictionary() {
        return dataTypeDictionary;
    }

    public void setDataTypeDictionary(List<BasicObject> dataTypeDictionary) {
        this.dataTypeDictionary = dataTypeDictionary;
    }

    public List<Element> getElementDictionary() {
        return elementDictionary;
    }

    public void setElementDictionary(List<Element> elementDictionary) {
        this.elementDictionary = elementDictionary;
    }
}

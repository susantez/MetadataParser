package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/17/2017.
 * Represents DataDefinitionDictionary tag in ConceptWave Metadata.xml
 */
public class Data {
    private List<BasicObject> dataTypeDictionary;
    private List<BasicObject> elementTypeDictionary;

    public Data() {
        dataTypeDictionary = new ArrayList<>();
        elementTypeDictionary = new ArrayList<>();
    }

    public List<BasicObject> getDataTypeDictionary() {
        return dataTypeDictionary;
    }

    public void setDataTypeDictionary(List<BasicObject> dataTypeDictionary) {
        this.dataTypeDictionary = dataTypeDictionary;
    }

    public List<BasicObject> getElementTypeDictionary() {
        return elementTypeDictionary;
    }

    public void setElementTypeDictionary(List<BasicObject> elementTypeDictionary) {
        this.elementTypeDictionary = elementTypeDictionary;
    }
}

package tr.net.susantez.dataMapping.metadata;

/**
 * Created by serkan.susantez on 4/18/2017.
 * Represents the inner DataStructure element of DataStructure tag on ConceptWave metadata.xml
 */
public class DataStructureElement extends BasicObject {
    private String element;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}

package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/18/2017.
 */
public class DataStructure extends BasicObject {
    List<DataStructureElement> elements;

    public DataStructure () {
        elements = new ArrayList<>();
    }

    public List<DataStructureElement> getElements() {
        return elements;
    }

    public void setElements(List<DataStructureElement> elements) {
        this.elements = elements;
    }
}

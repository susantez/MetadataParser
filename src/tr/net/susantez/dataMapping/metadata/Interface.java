package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/18/2017.
 */
public class Interface extends BasicObject {
    List<Operation> operations;

    public Interface () {
        operations = new ArrayList<>();
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}

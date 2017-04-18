package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/18/2017.
 * Represents Permission tag (PermissionDictionary child) under on ConceptWave metadata.xml
 */
public class Permission extends BasicObject {
    private List<Action> actions;

    public Permission() {
        actions = new ArrayList<>();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}

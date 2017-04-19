package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/11/2017.
 * Represents the form item for metadata objects
 */
public class Form extends BasicObject {
    private List<String> finders;
    private List<Action> actions;

    public Form() {
        actions = new ArrayList<>();
        finders = new ArrayList<>();
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<String> getFinders() {
        return finders;
    }

    public void setFinder(List<String> finders) {
        this.finders = finders;
    }
}

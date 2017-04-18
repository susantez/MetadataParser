package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/11/2017.
 * Represents the action item for metadata objects
 */
public class Action extends BasicObject{
    private List<Script> scripts;

    public Action() {
        scripts = new ArrayList<>();
    }

    public List<Script> getScripts() {
        return scripts;
    }

    public void setScripts(List<Script> scripts) {
        this.scripts = scripts;
    }
}

package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/12/2017.
 */
public class Document extends BasicObject{
    private String lastUpdate;
    private String label;
    private String dbSchema;
    private String generatedKey;
    private List<Leaf> leafCollection;
    private List<Form> formCollection;
    private List<Action> actionCollection;

    public Document() {
        leafCollection = new ArrayList<>();
        formCollection = new ArrayList<>();
        actionCollection = new ArrayList<>();
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public void setGeneratedKey(String generatedKey) {
        this.generatedKey = generatedKey;
    }

    public List<Form> getFormCollection() {
        return formCollection;
    }

    public void setFormCollection(List<Form> formCollection) {
        this.formCollection = formCollection;
    }

    public List<Action> getActionCollection() {
        return actionCollection;
    }

    public void setActionCollection(List<Action> actionCollection) {
        this.actionCollection = actionCollection;
    }

    public List<Leaf> getLeafCollection() {
        return leafCollection;
    }

    public void setLeafCollection(List<Leaf> leafCollection) {
        this.leafCollection = leafCollection;
    }
}

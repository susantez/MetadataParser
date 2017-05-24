package tr.net.susantez.dataMapping.metadata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/18/2017.
 */
public class Order extends BasicObject {
    private List<String> orederItems;
    private List<Action> actions;

    public Order() {
        orederItems = new ArrayList<>();
        actions = new ArrayList<>();
    }

    public List<String> getOrederItems() {
        return orederItems;
    }

    public void setOrederItems(List<String> orederItems) {
        this.orederItems = orederItems;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}

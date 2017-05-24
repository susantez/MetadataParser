package tr.net.susantez.datamapping.metadata;

/**
 * Created by serkan.susantez on 4/18/2017.
 */
public class BasicObject {
    private String name;
    private String guid;
    private String nameSpace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = name;
        }
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        if (this.guid == null) {
            this.guid = guid;
        }
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        if (this.nameSpace == null) {
            this.nameSpace = nameSpace;
        }
    }
}

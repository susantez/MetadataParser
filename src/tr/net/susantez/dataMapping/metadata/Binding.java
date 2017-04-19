package tr.net.susantez.dataMapping.metadata;

/**
 * Created by serkan.susantez on 4/19/2017.
 */
public class Binding extends BasicObject {
    String interfaceObj;
    String script;

    public String getInterfaceObj() {
        return interfaceObj;
    }

    public void setInterfaceObj(String interfaceObj) {
        this.interfaceObj = interfaceObj;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}

package tr.net.susantez.dataMapping.metadata;

/**
 * Created by serkan.susantez on 4/11/2017.
 * Represents the mdScript item for metadata objects
 */
public class Script extends BasicObject{
    private String mdScript;
    private String params;

    public void setMdScript(String mdScript)
    {
        this.mdScript = mdScript;
    }

    public String getMdScript()
    {
        if ("".equals (this.mdScript)) {
            return null;
        }
        String function = "function " + this.getName() + "(" + this.params + ") {\n";
        function = function + this.mdScript;
        function = function + "\n}";
        return function;
    }

    public void setParams(String params)
    {
        this.params = params;
    }

    public String getParams()
    {
        return this.params;
    }
}

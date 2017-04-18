package tr.net.susantez.dataMapping.metadata;

/**
 * Created by serkan.susantez on 4/18/2017.
 */
public class Operation extends BasicObject {
    private String input;
    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

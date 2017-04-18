package tr.net.susantez.dataMapping;

import tr.net.susantez.dataMapping.metadata.*;
import tr.net.susantez.dataMapping.metadata.Process;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serkan.susantez on 4/12/2017.
 * Metadata Class that represents ConceptWave Metadata.xml
 */
public class Metadata {
    private List<NameSpace> nameSpaceDictionary;
    private List<Document> documentDictionary;
    private List<Script> scriptsDictionary;
    private List<Permission> permissionDictionary;
    private List<DataStructure> dataStructureDictionary;
    private List<ConversionMap> conversionMapDictionary;
    private List<Interface> interfaceDictionary;
    private List<Process> processDictionary;
    private List<Order> orderDictionary;
    private List<Finder> finderDictionary;
    private List<Menu> menuDictionary;
    private Data dataDictionary;


    public Metadata () {
        nameSpaceDictionary = new ArrayList<>();
        documentDictionary = new ArrayList<>();
        scriptsDictionary = new ArrayList<>();
        permissionDictionary = new ArrayList<>();
        dataStructureDictionary = new ArrayList<>();
        conversionMapDictionary = new ArrayList<>();
        interfaceDictionary = new ArrayList<>();
        processDictionary = new ArrayList<>();
        orderDictionary = new ArrayList<>();
        finderDictionary = new ArrayList<>();
        menuDictionary = new ArrayList<>();
        dataDictionary = new Data();
    }

    public List<NameSpace> getNameSpaceDictionary() {
        return nameSpaceDictionary;
    }

    public void setNameSpaceDictionary(List<NameSpace> nameSpaceDictionary) {
        this.nameSpaceDictionary = nameSpaceDictionary;
    }

    public List<Document> getDocumentDictionary() {
        return documentDictionary;
    }

    public void setDocumentDictionary(List<Document> documentDictionary) {
        this.documentDictionary = documentDictionary;
    }

    public List<Script> getScriptsDictionary() {
        return scriptsDictionary;
    }

    public void setScriptsDictionary(List<Script> scriptsDictionary) {
        this.scriptsDictionary = scriptsDictionary;
    }

    public Data getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(Data dataDictionary) {
        this.dataDictionary = dataDictionary;
    }

    public List<Permission> getPermissionDictionary() {
        return permissionDictionary;
    }

    public void setPermissionDictionary(List<Permission> permissionDictionary) {
        this.permissionDictionary = permissionDictionary;
    }

    public List<DataStructure> getDataStructureDictionary() {
        return dataStructureDictionary;
    }

    public void setDataStructureDictionary(List<DataStructure> dataStructureDictionary) {
        this.dataStructureDictionary = dataStructureDictionary;
    }

    public List<ConversionMap> getConversionMapDictionary() {
        return conversionMapDictionary;
    }

    public void setConversionMapDictionary(List<ConversionMap> conversionMapDictionary) {
        this.conversionMapDictionary = conversionMapDictionary;
    }

    public List<Interface> getInterfaceDictionary() {
        return interfaceDictionary;
    }

    public void setInterfaceDictionary(List<Interface> interfaceDictionary) {
        this.interfaceDictionary = interfaceDictionary;
    }

    public List<Process> getProcessDictionary() {
        return processDictionary;
    }

    public void setProcessDictionary(List<Process> processDictionary) {
        this.processDictionary = processDictionary;
    }

    public List<Order> getOrderDictionary() {
        return orderDictionary;
    }

    public void setOrderDictionary(List<Order> orderDictionary) {
        this.orderDictionary = orderDictionary;
    }

    public List<Finder> getFinderDictionary() {
        return finderDictionary;
    }

    public void setFinderDictionary(List<Finder> finderDictionary) {
        this.finderDictionary = finderDictionary;
    }

    public List<Menu> getMenuDictionary() {
        return menuDictionary;
    }

    public void setMenuDictionary(List<Menu> menuDictionary) {
        this.menuDictionary = menuDictionary;
    }
}

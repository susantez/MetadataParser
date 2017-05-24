package tr.net.susantez.util;

/**
 * Created by serkan.susantez on 4/11/2017.
 */
public class Constants {

    public enum ElementType
    {
        PERMISSIONDICTIONARY("PermissionDictionary"),  PERMISSION("Permission"),
        DOCUMENTDICTIONARY("DocumentDictionary"), DOCUMENT("Document"),
        DATADEFINITIONDICTIONARY("DataDefinitionDictionary"),
        DATATYPEDICTIONARY("DataTypeDictionary"), DATATYPE("DataType"),
        ELEMENTTYPEDICTIONARY("ElementTypeDictionary"), ELEMENTTYPE("ElementType"),
        CONVERSIONMAPDICTIONARY("ConversionMapDictionary"), CONVERSIONMAP("ConversionMap"),
        SCRIPTDICTIONARY("ScriptDictionary"), SCRIPT("Script"),
        DATASTRUCTUREDICTIONARY("DataStructureDictionary"), DATASTRUCTURE("DataStructure"),
        NAMESPACEDICTIONARY("NameSpaceDictionary"), NAMESPACE("NameSpace"),
        INTERFACEDICTIONARY("InterfaceDictionary"), INTERFACE("Interface"),
        PROCESSDICTIONARY("ProcessDictionary"), PROCESS("Process"),
        ORDERDICTIONARY("OrderDictionary"), ORDER("Order"),
        FINDERDICTIONARY("FinderDictionary"), FINDER("Finder"),
        BINDINGDICTIONARY("BindingDictionary"), BINDING("Binding"),
        MENUDICTIONARY("UserInterfaceDictionary"), MENU("Menu");

        private final String name;

        public String getName()
        {
            return this.name;
        }

        ElementType(String name)
        {
            this.name = name;
        }
    }

    public static final String const_script = "script";
    public static final String const_name = "name";
    public static final String const_label = "label";
    public static final String const_namespace = "namespace";
    public static final String const_actions = "actions";
    public static final String const_action = "action";
    public static final String const_form = "form";
    public static final String const_operation = "operation";
    public static final String const_operationList = "operationList";
    public static final String const_guid = "guid";
    public static final String const_targetNameSpace = "targetNameSpace";
    public static final String const_qualified = "qualified";
    public static final String const_formCollection = "formCollection";
    public static final String const_leaf = "leaf";
    public static final String const_dataItem = "dataItem";
    public static final String const_element = "element";
    public static final String const_target = "target";
    public static final String const_source = "source";
    public static final String const_input = "input";
    public static final String const_output = "output";
    public static final String const_orderItem = "orderItem";
    public static final String const_baseObject = "baseObject";
    public static final String const_finder = "finder";
    public static final String const_menu = "menu";
    public static final String const_reference = "reference";
    public static final String const_worklist = "worklist";
    public static final String const_interface = "interface";
    public static final String const_parameter = "parameter";

    public static final String EXCEPTION_EOF = "Premature end of file";
}

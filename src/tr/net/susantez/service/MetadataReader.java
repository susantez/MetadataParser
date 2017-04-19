package tr.net.susantez.service;

import tr.net.susantez.dataMapping.*;
import tr.net.susantez.dataMapping.metadata.*;
import tr.net.susantez.dataMapping.metadata.Process;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static tr.net.susantez.util.Constants.*;

/**
 * Created by serkan.susantez on 4/11/2017.
 * Reader Class to read and parse xml metadata file into MetadataElement
 */
public class MetadataReader {
    private Metadata md = new Metadata();
    private XMLStreamReader reader;

    public MetadataReader(XMLStreamReader reader) {
        this.reader = reader;
    }

    private String nextStartEvent(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                return reader.getLocalName();
            }
        }
        return null;
    }

    public void parseMetadata() throws XMLStreamException {
        if (reader == null) {return;}

        while (reader.hasNext()) {
            String elementName = nextStartEvent(reader);
            if (ElementType.NAMESPACEDICTIONARY.getName().equals(elementName)) {
                readNamespaces(reader);
            } else if (ElementType.DOCUMENTDICTIONARY.getName().equals(elementName)) {
                readDocuments(reader);
            } else if (ElementType.SCRIPTDICTIONARY.getName().equals(elementName)) {
                readMDScripts(reader);
            } else if (ElementType.DATADEFINITIONDICTIONARY.getName().equals(elementName)) {
                readDataDictionary(reader);
            } else if (ElementType.PERMISSIONDICTIONARY.getName().equals(elementName)) {
                readPermissionDictionary(reader);
            } else if (ElementType.DATASTRUCTUREDICTIONARY.getName().equals(elementName)) {
                readDataStructureDictionary(reader);
            } else if (ElementType.CONVERSIONMAPDICTIONARY.getName().equals(elementName)){
                readConversionMapDictionary(reader);
            } else if (ElementType.INTERFACEDICTIONARY.getName().equals(elementName)) {
                readInterfaceDictionary(reader);
            } else if (ElementType.PROCESSDICTIONARY.getName().equals(elementName)) {
                readProcessDictionary(reader);
            } else if (ElementType.ORDERDICTIONARY.getName().equals(elementName)){
                readOrderDictionary(reader);
            } else if (ElementType.FINDERDICTIONARY.getName().equals(elementName)) {
                readFinderDictionary(reader);
            } else if (ElementType.MENUDICTIONARY.getName().equals(elementName)) {
                readMenuDictionary(reader);
            } else if (ElementType.BINDINGDICTIONARY.getName().equals(elementName)) {
                readBindngDictionary(reader);
            }
        }
    }

    private void readBindngDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.BINDING.getName().equals(elementName)) {
                    md.getBindingDictionary().add(readBinding(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.BINDINGDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Binding readBinding(XMLStreamReader reader) throws XMLStreamException {
        Binding binding = new Binding();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    binding.setName(readCharacters(reader));
                } else if(const_guid.equals(elementName)) {
                    binding.setGuid(readCharacters(reader));
                } else if(const_namespace.equals(elementName)) {
                    binding.setNameSpace(readCharacters(reader));
                } else if(const_script.equals(elementName)) {
                    binding.setScript(readCharacters(reader));
                } else if(const_interface.equals(elementName)) {
                    binding.setInterfaceObj(readCharacters(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.BINDING.getName().equals(reader.getLocalName())) {
                return binding;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readMenuDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.MENU.getName().equals(elementName)) {
                    md.getMenuDictionary().add(readMenu(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.MENUDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Menu readMenu(XMLStreamReader reader) throws XMLStreamException {
        Menu menu = new Menu();
        int depth = 1;
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    menu.setName(readCharacters(reader));
                } else if(const_guid.equals(elementName)) {
                    menu.setGuid(readCharacters(reader));
                } else if(const_namespace.equals(elementName)) {
                    menu.setNameSpace(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(menu.getActions(), reader);
                } else if (const_worklist.equals(elementName)) {
                    menu.getWorklist().add(readCharacters(reader));
                } else if (ElementType.MENU.getName().equals(elementName)){
                    depth++;
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.MENU.getName().equals(reader.getLocalName()) &&
                    --depth == 0) {
                return menu;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readFinderDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.FINDER.getName().equals(elementName)) {
                    md.getFinderDictionary().add(readFinder(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.FINDERDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Finder readFinder(XMLStreamReader reader) throws XMLStreamException {
        Finder finder = new Finder();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    finder.setName(readCharacters(reader));
                } else if(const_guid.equals(elementName)) {
                    finder.setGuid(readCharacters(reader));
                } else if(const_namespace.equals(elementName)) {
                    finder.setNameSpace(readCharacters(reader));
                } else if(const_input.equals(elementName)) {
                    finder.setInput(readCharacters(reader));
                } else if(const_output.equals(elementName)) {
                    finder.setOutput(readCharacters(reader));
                } else if(const_menu.equals(elementName)) {
                    finder.setMenu(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(finder.getActions(), reader);
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.FINDER.getName().equals(reader.getLocalName())) {
                return finder;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readOrderDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.ORDER.getName().equals(elementName)) {
                    md.getOrderDictionary().add(readOrder(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.ORDERDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Order readOrder(XMLStreamReader reader) throws XMLStreamException {
        Order order = new Order();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    order.setName(readCharacters(reader));
                } else if(const_guid.equals(elementName)) {
                    order.setGuid(readCharacters(reader));
                } else if(const_namespace.equals(elementName)) {
                    order.setNameSpace(readCharacters(reader));
                } else if(const_orderItem.equals(elementName)) {
                    order.getOrederItems().add(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(order.getActions(), reader);
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.ORDER.getName().equals(reader.getLocalName())) {
                return order;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readProcessDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.PROCESS.getName().equals(elementName)) {
                    md.getProcessDictionary().add(readProcess(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.PROCESSDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Process readProcess(XMLStreamReader reader) throws XMLStreamException {
        Process process = new Process();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    process.setName(readCharacters(reader));
                } else if(const_guid.equals(elementName)) {
                    process.setGuid(readCharacters(reader));
                } else if(const_namespace.equals(elementName)) {
                    process.setNameSpace(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                        readDocumentActions(process.getActions(), reader);
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.PROCESS.getName().equals(reader.getLocalName())) {
                return process;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readInterfaceDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.INTERFACE.getName().equals(elementName)) {
                    md.getInterfaceDictionary().add(readInterface(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.INTERFACEDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Interface readInterface(XMLStreamReader reader) throws XMLStreamException {
        Interface mdInterface = new Interface();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    mdInterface.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    mdInterface.setGuid(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    mdInterface.setNameSpace(readCharacters(reader));
                } else if (const_operationList.equals(elementName)) {
                    mdInterface.setOperations(readOperations(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.INTERFACE.getName().equals(reader.getLocalName())) {
                return mdInterface;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private List<Operation> readOperations(XMLStreamReader reader) throws XMLStreamException {
        List<Operation> operations = new ArrayList<>();
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_operation.equals(elementName)) {
                    operations.add(readOperation(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    const_operationList.equals(reader.getLocalName())) {
                return operations;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private Operation readOperation(XMLStreamReader reader) throws XMLStreamException {
        Operation operation = new Operation();
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    operation.setName(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    operation.setNameSpace(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    operation.setGuid(readCharacters(reader));
                } else if (const_input.equals(elementName)){
                    operation.setInput(readCharacters(reader));
                } else if (const_output.equals(elementName)) {
                    operation.setOutput(readCharacters(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    const_operation.equals(reader.getLocalName())) {
                return operation;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readConversionMapDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.CONVERSIONMAP.getName().equals(elementName)) {
                    md.getConversionMapDictionary().add(readConversionMap(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.CONVERSIONMAPDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private ConversionMap readConversionMap(XMLStreamReader reader) throws XMLStreamException {
        ConversionMap conversionMap = new ConversionMap();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    conversionMap.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    conversionMap.setGuid(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    conversionMap.setNameSpace(readCharacters(reader));
                } else if (const_source.equals(elementName)) {
                    conversionMap.setSource(readCharacters(reader));
                } else if (const_target.equals(elementName)) {
                    conversionMap.setTarget(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(conversionMap.getActions(), reader);
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.CONVERSIONMAP.getName().equals(reader.getLocalName())) {
                return conversionMap;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readDataStructureDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.DATASTRUCTURE.getName().equals(elementName)) {
                    md.getDataStructureDictionary().add(readDataStructure(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.DATASTRUCTUREDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private DataStructure readDataStructure(XMLStreamReader reader) throws XMLStreamException {
        DataStructure dataStructure = new DataStructure();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    dataStructure.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    dataStructure.setGuid(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    dataStructure.setNameSpace(readCharacters(reader));
                } else if (ElementType.DATASTRUCTURE.getName().equals(elementName)) {
                    dataStructure.getElements().add(readDataStructureElement(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.DATASTRUCTURE.getName().equals(reader.getLocalName())) {
                return dataStructure;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private DataStructureElement readDataStructureElement(XMLStreamReader reader) throws XMLStreamException {
        DataStructureElement dataStructure = new DataStructureElement();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    dataStructure.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    dataStructure.setGuid(readCharacters(reader));
                } else if (const_element.equals(elementName)) {
                    dataStructure.setElement(readCharacters(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.DATASTRUCTURE.getName().equals(reader.getLocalName())) {
                return dataStructure;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readPermissionDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.PERMISSION.getName().equals(elementName)) {
                    md.getPermissionDictionary().add(readPermission(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.PERMISSIONDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Permission readPermission(XMLStreamReader reader) throws XMLStreamException {
        Permission permission = new Permission();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    permission.setName(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(permission.getActions(), reader);
                }

            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.PERMISSION.getName().equals(reader.getLocalName())) {
                return permission;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readDataDictionary(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.DATATYPEDICTIONARY.getName().equals(elementName)) {
                    md.getDataDictionary().setDataTypeDictionary(readDataTypes(reader));
                } else if (ElementType.ELEMENTTYPEDICTIONARY.getName().equals(elementName)) {
                    md.getDataDictionary().setElementDictionary(readElementTypes(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.DATADEFINITIONDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private List<BasicObject> readDataTypes(XMLStreamReader reader) throws XMLStreamException {
        List<BasicObject> dataTypes = new ArrayList<>();
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.DATATYPE.getName().equals(elementName)) {
                    dataTypes.add(readBasicObject(reader, ElementType.DATATYPE.getName()));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.DATATYPEDICTIONARY.getName().equals(reader.getLocalName())) {
                return dataTypes;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private List<Element> readElementTypes(XMLStreamReader reader) throws XMLStreamException {
        List<Element> elementTypes = new ArrayList<>();
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.ELEMENTTYPE.getName().equals(elementName)) {
                    elementTypes.add(readElement(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.ELEMENTTYPEDICTIONARY.getName().equals(reader.getLocalName())) {
                return elementTypes;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private Element readElement(XMLStreamReader reader) throws XMLStreamException {
        Element element = new Element();
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    element.setName(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    element.setNameSpace(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    element.setGuid(readCharacters(reader));
                } else if (const_reference.equals(elementName)) {
                    element.setFinder(readCharacters(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT
                    && ElementType.ELEMENTTYPE.getName().equals(reader.getLocalName())) {
                return element;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private BasicObject readBasicObject(XMLStreamReader reader, String tag) throws XMLStreamException {
        BasicObject object = new BasicObject();
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    object.setName(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    object.setNameSpace(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    object.setGuid(readCharacters(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT && tag.equals(reader.getLocalName())) {
                return object;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readMDScripts(XMLStreamReader reader) throws XMLStreamException {
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.SCRIPT.getName().equals(elementName)) {
                    md.getScriptsDictionary().add(readScript(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.SCRIPTDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Script readScript(XMLStreamReader reader) throws XMLStreamException {
        Script script = new Script();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_script.equals(elementName)) {
                    script.setMdScript(readCharacters(reader));
                } else if (const_name.equals(elementName)) {
                    script.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    script.setGuid(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    script.setNameSpace(readCharacters(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    ElementType.SCRIPT.getName().equals(reader.getLocalName())) {
                return script;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readDocuments(XMLStreamReader reader) throws XMLStreamException {
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.DOCUMENT.getName().equals(elementName)) {
                    md.getDocumentDictionary().add(readDocument(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.DOCUMENTDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private Document readDocument(XMLStreamReader reader)throws XMLStreamException {
        Document doc = new Document();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    doc.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    doc.setGuid(readCharacters(reader));
                } else if (const_namespace.equals(elementName)) {
                    doc.setNameSpace(readCharacters(reader));
                } else if (const_menu.equals(elementName)) {
                    doc.setMenu(readCharacters(reader));
                } else if (const_formCollection.equals(elementName)) {
                    doc.setFormCollection(readDocumentForms(reader, doc.getActionCollection()));
                } else if (const_actions.equals(elementName)) {
                    doc.setActionCollection(readDocumentActions(doc.getActionCollection(), reader));
                } else if (const_leaf.equals(elementName)) {
                    doc.getLeafCollection().add(readLeaf(reader));
                } else if (const_baseObject.equals(elementName)) {
                    doc.setExtension(true);
                    doc.setBaseObject(readCharacters(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.DOCUMENT.getName().equals(reader.getLocalName())) {
                return doc;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private Leaf readLeaf(XMLStreamReader reader) throws XMLStreamException {
        Leaf leaf = new Leaf();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    leaf.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    leaf.setGuid(readCharacters(reader));
                } else if (const_dataItem.equals(elementName)) {
                    leaf.setDataItem(readCharacters(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT && const_leaf.equals(reader.getLocalName())) {
                return leaf;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private List<Form> readDocumentForms(XMLStreamReader reader, List<Action> actions) throws  XMLStreamException {
        List<Form> forms = new ArrayList<>();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_form.equals(elementName)) {
                    forms.add(readForm(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(actions, reader);
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    const_formCollection.equals(reader.getLocalName())) {
                return  forms;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private Form readForm(XMLStreamReader reader) throws XMLStreamException {
        Form form = new Form();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    form.setName(readCharacters(reader));
                } else if (const_actions.equals(elementName)) {
                    readDocumentActions(form.getActions(), reader);
                } else if (const_finder.equals(elementName)) {
                    form.getFinders().add(readCharacters(reader));
                }
            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    const_form.equals(reader.getLocalName())) {
                return form;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private List<Action> readDocumentActions(List<Action> actions, XMLStreamReader reader) throws  XMLStreamException {
        List<Action> docActions;
        if (actions != null) {
            docActions = actions;
        } else {
            docActions = new ArrayList<>();
        }
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_action.equals(elementName)) {
                    docActions.add(readAction(reader));
                }

            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    const_actions.equals(reader.getLocalName())) {
                return docActions;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private Action readAction(XMLStreamReader reader) throws XMLStreamException {
        Action action = new Action();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    action.setName(readCharacters(reader));
                    action.setScripts(readActionScripts(reader));
                    return action;
                }

            } else if (eventType == XMLStreamReader.END_ELEMENT &&
                    const_action.equals(reader.getLocalName())) {
                return action;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private List<Script> readActionScripts(XMLStreamReader reader) throws XMLStreamException {
        List<Script> scripts = new ArrayList<>();
        int depth = 1;
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_script.equals(elementName)) {
                    Script script = new Script();
                    script.setMdScript(readCharacters(reader));
                    scripts.add(script);
                } else if (const_action.equals(elementName)) {
                    depth++;
                }

            } else if (eventType == XMLStreamReader.END_ELEMENT) {
                String endingElement = reader.getLocalName();
                if (const_action.equals(endingElement)) {
                    depth--;
                    if (depth == 0) {
                        return scripts;
                    }
                }
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private void readNamespaces(XMLStreamReader reader) throws XMLStreamException {
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (ElementType.NAMESPACE.getName().equals(elementName)) {
                    md.getNameSpaceDictionary().add(readNamespace(reader));
                }

            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.NAMESPACEDICTIONARY.getName().equals(reader.getLocalName())) {
                return;
            }
        }
    }

    private NameSpace readNamespace(XMLStreamReader reader)throws XMLStreamException {
        NameSpace ns = new NameSpace();
        while(reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLStreamConstants.START_ELEMENT) {
                String elementName = reader.getLocalName();
                if (const_name.equals(elementName)) {
                    ns.setName(readCharacters(reader));
                } else if (const_guid.equals(elementName)) {
                    ns.setGuid(readCharacters(reader));
                } else if (const_label.equals(elementName)) {
                    ns.setLabel(readCharacters(reader));
                } else if (const_targetNameSpace.equals(elementName)) {
                    ns.setTargetNameSpace(readCharacters(reader));
                } else if (const_qualified.equals(elementName)) {
                    ns.setQualified(readCharacters(reader));
                }
            } else if (eventType == XMLStreamConstants.END_ELEMENT &&
                    ElementType.NAMESPACE.getName().equals(reader.getLocalName())) {
                return ns;
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    private String readCharacters(XMLStreamReader reader) throws XMLStreamException {
        StringBuilder result = new StringBuilder();
        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.CHARACTERS:
                case XMLStreamReader.CDATA:
                    result.append(reader.getText());
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return result.toString();
            }
        }
        throw new XMLStreamException(EXCEPTION_EOF);
    }

    public String getNameSpaceList() {
        List<NameSpace> l = md.getNameSpaceDictionary();
        StringBuilder nsList = new StringBuilder();
        for (NameSpace aL : l) {
            nsList.append(aL.getName()).append(";");
        }

         return nsList.toString();
    }

    public Metadata getMetadata() {
        return md;
    }
}

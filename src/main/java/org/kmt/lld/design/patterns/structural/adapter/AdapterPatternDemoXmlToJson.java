package org.kmt.lld.design.patterns.structural.adapter;

/**
 * Adapter Design Pattern Example: XML to JSON Adapter
 *
 * Problem:
 * An existing XML-based service needs to be adapted to a JSON-based interface.
 * The client expects data in JSON format, but the service provides data in XML format.
 *
 * Solution:
 * The Adapter pattern allows the XML-based service to work with the JSON-based interface.
 * It acts as a bridge between the two incompatible interfaces.
 *
 * Components:
 * - Target: Defines the domain-specific interface that the Client uses. Here it's the JsonService that the Client uses.
 * - Adaptee: Defines an existing interface that needs adapting. Here XML-based service interface needs adapting.
 * - Adapter: Adapts the interface of the Adaptee to the Target interface. Adapts the interface of the XML-based service to the JSON-based interface.
 * - Client: Uses Adapter to work with objects of Adaptee interface. Here it's the JsonService.
 */

// Target interface (JSON-based)
interface JsonService {
    String getJsonData();
}

// Adaptee class (XML-based)
class XmlService {
    public String getXmlData() {
        return "<data><item>XML Data</item></data>";
    }
}

// Adapter class that makes XmlService compatible with JsonService
class XmlToJsonAdapter implements JsonService {
    private XmlService xmlService;

    public XmlToJsonAdapter(XmlService xmlService) {
        this.xmlService = xmlService; // Store the xmlService instance
    }

    @Override
    public String getJsonData() {
        // Convert XML data to JSON format
        String xmlData = xmlService.getXmlData(); // Get XML data from xmlService
        // Simplified conversion logic (for demonstration purposes)
        String jsonData = xmlData.replace("<data>", "{")
                .replace("</data>", "}")
                .replace("<item>", "\"item\": \"")
                .replace("</item>", "\"");
        return jsonData; // Return the converted JSON data
    }
}

// Client class
public class AdapterPatternDemoXmlToJson {
    public static void main(String[] args) {
        // Create an instance of the XmlService
        XmlService xmlService = new XmlService();

        // Create an instance of the XmlToJsonAdapter with the XmlService
        JsonService adapter = new XmlToJsonAdapter(xmlService);

        // Client uses the Adapter, which makes XmlService compatible with JsonService
        String jsonData = adapter.getJsonData(); // This will call the xmlService's getXmlData method and convert the result to JSON

        // Output the JSON data
        System.out.println("JSON Data: " + jsonData); // Output the converted JSON data
    }
}


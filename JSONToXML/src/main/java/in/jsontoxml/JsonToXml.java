package in.jsontoxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class JsonToXml {
    public static void main(String[] args) throws JsonProcessingException {

        try {
            //JSON data
            String jsonData = "{\"id\":2,\"name\":\"john\",\"age\":24} ";

            // creating objectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            //Read JSON Data as tree
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            // creating XMLMapper instance
            XmlMapper xmlMapper = new XmlMapper();

            // convert JSON tree to XML
            String xmlString = xmlMapper.writeValueAsString(jsonNode);

            System.out.print(xmlString);

            try {
                // Create a new file in the resources directory
                File file = new File("D:\\Java\\poc\\JSONToXML\\src\\main\\resources\\data.xml");

                // Write the string data to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(xmlString);
                    System.out.println("Data written to " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}


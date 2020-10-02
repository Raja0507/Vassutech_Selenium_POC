package Com.nopcommerce.testData;


import Com.nopcommerce.Configurations.ReadConfigFile;
import Com.nopcommerce.GenericMethods.GenericMethods;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile extends ReadConfigFile {



    private static JSONObject jsonObject;

    public void loadjsonfile() throws IOException, ParseException {
        // Step1 :file reader to read the json file
        FileReader fileReader = new FileReader("./TestData/Testdata.json");
        //Step2:Create a Jsonparcer object to parce the file read by filereader
        JSONParser jsonParser = new JSONParser();
        //Step 3:Store the parced data into object class object
        Object object = jsonParser.parse(fileReader);
        //Step4 Parce the Object class with json object to get the data based on the key
        jsonObject = (JSONObject) object;
    }

    public String getData( String fieldname) {
        JSONObject obj = (JSONObject) jsonObject.get(GenericMethods.Currenttestcase);
        System.out.println(obj.get(fieldname));
        return obj.get(fieldname).toString();
    }

}


package Com.nopcommerce.commontestannotations;


import Com.nopcommerce.GenericMethods.GenericMethods;
import Com.nopcommerce.testData.ReadJsonFile;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class CommonTestAnnotations {
    @BeforeSuite
    public void beforesuite() throws IOException, ParseException {
        System.out.println("Loading Json file....");
        ReadJsonFile readJsonFile=new ReadJsonFile();
        readJsonFile.loadjsonfile();
    }
    @AfterSuite
    public void aftersuit(){
        GenericMethods genericMethods=new GenericMethods();
        genericMethods.closeApplication();
    }
    @BeforeMethod
    public void beformethod(Method m){
        System.out.println(m.getName());

    }
}

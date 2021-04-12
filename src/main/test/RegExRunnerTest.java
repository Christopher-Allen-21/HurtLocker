import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegExRunnerTest {

    @Test
    public void splitByKVPairs() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        RegExRunner rer = new RegExRunner(result);

        List<String> keyValuePairs = rer.splitByKVPairs();

        for(int i=0;i<keyValuePairs.size();i++){
            System.out.println(keyValuePairs.get(i));
        }
        System.out.println(keyValuePairs.size());
    }

    @Test
    public void identifyName() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        RegExRunner rer = new RegExRunner(result);

        List<String> keyValuePairs = rer.splitByKVPairs();

        for(int i=0;i<keyValuePairs.size();i++){
            System.out.println(rer.identifyName(keyValuePairs.get(i)));
        }

    }


}
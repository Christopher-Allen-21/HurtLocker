import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

        RegExRunner rer = new RegExRunner(result);
        List<JerkSON> jerkSONList = rer.createJerkSONs();
        return jerkSONList.toString();
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }



}

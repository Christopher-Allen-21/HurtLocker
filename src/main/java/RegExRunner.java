import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExRunner {
    String string;

    public RegExRunner(String string){
        this.string = string;

    }


    public List<String> splitByKVPairs(){
//        String[] stringArr = string.split("##");
//        List<String> stringList = Arrays.asList(stringArr);

        List<String> stringList = splitByDelim(string,"\\##(.*?)\\##");
        //List<String> stringList = splitByDelim(string,"([^##]*)");

        return stringList;
    }

    public List<String> splitByDelim(String string, String regex){

        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        for(int i=0;matcher.find();i++){
            stringList.add(matcher.group());
        }

        return stringList;
    }


}

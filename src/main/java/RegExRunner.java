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


    public List<JerkSON> createJerkSONs(){
        List<JerkSON> jerkSONsList = new ArrayList<>();
        List<String> kvPairsList = splitByKVPairs();

        for(int i=0;i<kvPairsList.size();i++){

        }

        return jerkSONsList;
    }



    public FoodName identifyName(String string){

        for(FoodName name : FoodName.values()){
            Pattern pattern = Pattern.compile(name.label,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);
            boolean matchFound = matcher.find();
            if(matchFound){
                return name;
            }
        }

        return null;
    }





    public List<String> splitByKVPairs(){
//      String[] stringArr = string.split("##");
//      List<String> kvPairsList = Arrays.asList(stringArr);

        List<String> kvPairsList = splitByDelim(string,"(.*?)\\##");

        return kvPairsList;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

        for(FoodName name : FoodName.values()) {
            JerkSON jerkSON = new JerkSON();
            jerkSON.setName(name.label);
            jerkSONsList.add(jerkSON);
        }

        for(int i=0;i<kvPairsList.size();i++){
            //if name is null increment count of errors
            if(identifyName(kvPairsList.get(i))==null){
                jerkSONsList.get(4).incrementTotalCount();
            }

            for(int j=0;j<jerkSONsList.size();j++){
                //identify which jerkSON to check against
                if(identifyName(kvPairsList.get(i))!=null && identifyName(kvPairsList.get(i)).equals(jerkSONsList.get(j).getName())){
                    //if price is null then increment count of errors
                    if(identifyPrice(kvPairsList.get(i))==null){
                        jerkSONsList.get(4).incrementTotalCount();
                    }
                    //if no prices in list, add new price
                    else if(jerkSONsList.get(j).getPricesCount().size() == 0){
                        jerkSONsList.get(j).incrementTotalCount();
                        jerkSONsList.get(j).addNewPrice(identifyPrice(kvPairsList.get(i)));
                    }
                    //check if price already exists
                    else{
                        jerkSONsList.get(j).incrementTotalCount();
                        Map<String,Integer> pricesCount = jerkSONsList.get(j).getPricesCount();
                        boolean priceFound = false;
                        for(String p : pricesCount.keySet()){
                            //if price found, increment count of times price was seen
                            if(p.equals(identifyPrice(kvPairsList.get(i)))){
                                priceFound = true;
                                jerkSONsList.get(j).incrementExistingPrice(identifyPrice(kvPairsList.get(i)));
                            }
                        }
                        //if price not found then add new price
                        if(!priceFound){
                            jerkSONsList.get(j).addNewPrice(identifyPrice(kvPairsList.get(i)));
                        }
                    }
                }
            }
        }

        return jerkSONsList;
    }


    public String identifyName(String string){
        for(FoodName name : FoodName.values()){
            Pattern pattern = Pattern.compile(name.label,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(string);
            boolean matchFound = matcher.find();
            if(matchFound){
                return name.label;
            }
        }
        if(checkCo0kieS(string)){
            return FoodName.COOKIES.label;
        }
        return null;
    }

    public boolean checkCo0kieS(String string){
        Pattern pattern = Pattern.compile("Co0kieS",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        boolean matchFound = matcher.find();
        if(matchFound){
            return true;
        }
        return false;
    }

    public String identifyPrice(String string){
        Pattern pattern = Pattern.compile("\\d{1}\\.\\d{2}");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find()){
            return matcher.group();
        }
        return null;
    }



    public List<String> splitByKVPairs(){
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

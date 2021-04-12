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

        for(FoodName name : FoodName.values()) {
            JerkSON jerkSON = new JerkSON();
            jerkSON.setName(name.label);
            jerkSONsList.add(jerkSON);
        }


        for(int i=0;i<kvPairsList.size();i++){
            for(int j=0;j<jerkSONsList.size();j++){
                //if name is null
                if(identifyName(kvPairsList.get(i))==null){
                    //increment count of errors
                }
                //identify which jerkSON to check against
                else if(identifyName(kvPairsList.get(i)).equals(jerkSONsList.get(j).getName())){
                    //if no prices add the price
                    if(jerkSONsList.get(j).getPrices().size() == 0){
                        jerkSONsList.get(j).addPrice(identifyPrice(kvPairsList.get(i)));
                    }
                    //check if price already exists
                    else{
                        List<String> prices = jerkSONsList.get(j).getPrices();
                        boolean priceFound = false;
                        for(String p : prices){
                            if(p == null){
                                //INCREMENT ERRORS SOMEHOW
                            }
                            //if price found increment count of times price was seen
                            else if(p.equals(identifyPrice(kvPairsList.get(i)))){
                                //increment count of that price somehow
                                priceFound = true;
                            }
                        }
                        //if price not found then add the price
                        if(!priceFound){
                            jerkSONsList.get(j).addPrice(identifyPrice(kvPairsList.get(i)));
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
        return null;
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

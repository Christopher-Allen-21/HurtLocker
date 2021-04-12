import java.util.*;

public class JerkSON {

    String name;
    Integer totalCount=0;
    List<String> prices = new ArrayList<>();
    Map<String,Integer> pricesCount = new HashMap<>();

    public JerkSON(){

    }

    public void incrementTotalCount(){
        totalCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPrice(String price){
        prices.add(price);
    }

    public List<String> getPrices(){
        return prices;
    }

    public Map<String,Integer> getPricesCount(){
        return pricesCount;
    }

    public void addNewPrice(String price){
        pricesCount.put(price,1);
    }

    public void incrementExistingPrice(String price){
        pricesCount.put(price,pricesCount.get(price)+1);
    }


    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();

        if(name.equals("Errors")){
            sb.append("\n\n"+getName()+"\t\t\t\tseen: "+totalCount+" times");
        }
        else{
            sb.append("\n\nname: "+getName()+"\t\tseen: "+totalCount+" times").append("\n=============\t\t=============");
            for(String p : pricesCount.keySet()){
                sb.append("\nPrice: "+p+"\t\t\tseen: "+pricesCount.get(p));
            }
            sb.append("\n_____________\t\t_____________");
        }


        return sb.toString();
    }



}

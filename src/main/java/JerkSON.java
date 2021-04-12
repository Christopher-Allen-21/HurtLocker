import java.util.*;

public class JerkSON {

    String name;
    Integer totalCount=0;
    List<String> prices = new ArrayList<>();

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

    @Override
    public String toString(){
        StringBuilder sb =  new StringBuilder();

        sb.append("\n\nname: "+getName()+"\t\tseen: "+totalCount+" times").append("\n=============\t\t=============");
        for(String p : prices){
            sb.append("\nPrice: "+p);
        }

        return sb.toString();
    }



}

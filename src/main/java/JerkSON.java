import java.util.*;

public class JerkSON {

    String name;
    List<String> prices = new ArrayList<>();

    public JerkSON(){

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
        return new StringBuilder()
                .append("\nname: "+this.getName())
                .append("\n=============")
                .append("\nPrice: "+this.getPrices())
                .toString();
    }



}

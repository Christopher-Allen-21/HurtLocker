public enum FoodName{
    MILK ("milk"),
    BREAD ("bread"),
    COOKIES("cookies"),
    APPLES ("apples");

    public final String label;
    private FoodName(String label){
        this.label = label;
    }
}
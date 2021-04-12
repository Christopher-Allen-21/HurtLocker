public enum FoodName{
    MILK ("Milk"),
    BREAD ("Bread"),
    COOKIES("Cookies"),
    APPLES ("Apples"),
    ERRORS ("Errors");

    public final String label;
    private FoodName(String label){
        this.label = label;
    }
}
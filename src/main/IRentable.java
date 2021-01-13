public interface IRentable {

    String getDescription();
    float getPrice(int daysRented, Customer customer, boolean usePoints);
    int getLoyaltyPoints(int daysRented);
}

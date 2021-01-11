public interface IRentable {

    String getDescription();
    float getPrice(int daysRented, int loyaltyPoint);
    int getLoyaltyPoints(int daysRented);
}

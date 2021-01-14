public interface IRentable {

    String getDescription();
    double getPrice(int daysRented, Customer customer, int usedPoints);
    int getLoyaltyPoints(int daysRented);
}

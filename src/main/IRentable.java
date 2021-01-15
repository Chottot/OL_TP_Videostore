public interface IRentable {

    /**
     *
     * @return a description of what is rented
     */
    String getDescription();

    /**
     *
     * @param daysRented  the number of days we rent
     * @param customer    the customer that rent
     * @param usedPoints  the number of pint the customer want to use
     *
     * @return the price calculated by the Object who implements this interface
     */
    double getPrice(int daysRented, Customer customer, int usedPoints);

    /**
     *
     * @param daysRented the number of days rented
     * @return the number of loyalty point earned by the rent
     */
    int getLoyaltyPoints(int daysRented);
}

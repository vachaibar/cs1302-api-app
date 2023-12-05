package cs1302.api;

/**
 * Represents an API application.
 */
public class StockProfile {
    private String name;

    /**
     * Constructs a {@code StockProfile} object.
     *
     * @return the name of the stock
     */
    public String getName() {
        return name;
    } // getName

    /**
     * Sets the name of the stock.
     *
     * @param name the name of the stock
     */
    public void setName(String name) {
        this.name = name;
    } // setName
} // StockProfile

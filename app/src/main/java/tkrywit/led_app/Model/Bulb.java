package tkrywit.led_app.Model;

/**
 * Created by tkryw on 4/6/2017.
 */

public class Bulb {
    private String type;
    private int watts;
    private int quantity;

    public Bulb(String type, int watts, int number) {
        this.type = type;
        this.watts = watts;
        this.quantity = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int number) {
        this.quantity = number;
    }
}

package tkrywit.led_app.Model;

import java.util.ArrayList;

/**
 * Created by tkryw on 4/5/2017.
 */

public class Room {
    private String name;
    private String desc;
    private ArrayList<Bulb> bulbs;

    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.bulbs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Bulb> getBulbs() {
        return bulbs;
    }

    public void setBulbs(ArrayList<Bulb> bulbs) {
        this.bulbs = bulbs;
    }

}

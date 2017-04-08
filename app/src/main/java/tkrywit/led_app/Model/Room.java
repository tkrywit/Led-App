package tkrywit.led_app.Model;

import java.util.ArrayList;

/**
 * Created by tkryw on 4/5/2017.
 */

public class Room {
    private String name;
    private String desc;
    private ArrayList<Fixture> fixtures;

    public Room(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.fixtures = new ArrayList<>();
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

    public ArrayList<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(ArrayList<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}

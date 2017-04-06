package tkrywit.led_app.Model;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by tkryw on 4/5/2017.
 */

public class Project {

    private String title;
    private String description;
    private Bitmap photo;
    private ArrayList<Room> rooms;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}

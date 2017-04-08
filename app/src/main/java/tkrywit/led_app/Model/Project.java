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

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
        this.photo = null;
        this.rooms = new ArrayList<>();
    }

    public Project(String title, String description, Bitmap photo) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.rooms = new ArrayList<>();
    }

    public Project(String title, String description, Bitmap photo, ArrayList<Room> rooms) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.rooms = rooms;
    }

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

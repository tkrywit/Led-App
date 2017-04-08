package tkrywit.led_app.Utilities;

import java.util.ArrayList;

import tkrywit.led_app.Model.Project;
import tkrywit.led_app.Model.Room;

/**
 * Created by tkryw on 4/8/2017.
 */

public class StateManager {

    private static StateManager instance = null;
    private ArrayList<Project> projects;

    private StateManager() {
        projects = new ArrayList<>();

        //Sample list for testing
        for (int i = 0; i < 10; i++) {
            Project project = new Project("Example Title " + String.valueOf(i), "Example desc");
            for (int j = 0; j < 10; j++) {
                Room room = new Room("Room " + String.valueOf(j), "Room desc");
                project.getRooms().add(room);
            }
            projects.add(project);
        }
    }

    public static StateManager getInstance() {
        if (instance == null) {
            instance = new StateManager();
        }
        return instance;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}

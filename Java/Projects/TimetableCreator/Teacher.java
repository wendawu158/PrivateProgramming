package Projects.TimetableCreator;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class Teacher {

    public String name = ""; // Name of teacher
    public ArrayList<String> subjects = new ArrayList<>(); // Subject names & level
    public int maxTeachingPeriods = 0; // The amount periods a week teacher can teach
    public boolean[][] availablePeriods; // Periods the teacher are in



}

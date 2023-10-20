package Projects.TimetableCreator;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    public String name = ""; // Name of Student
    public int year = 0; // Year of Student
    public ArrayList<String> subjects = new ArrayList<>(); // Subject Names & Level
    public HashMap<String, String> subjectPeriodsPerWeek = new HashMap<>();
    // Keys are Subject Names & Level
    // Values are Periods per week for subject
    public HashMap<String, String> subjectPercentageGrade = new HashMap<>();
    // Keys are Subject Names & Level
    // Values are Percentage Grade of Student
    public boolean[][] availablePeriods; // Periods the student are in

}

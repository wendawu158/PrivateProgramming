package Projects.TimetableCreator;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> Students = new ArrayList<Student>();
        ArrayList<Teacher> Teachers = new ArrayList<Teacher>();

        ArrayList<String> Subjects = new ArrayList<>();
        HashMap<String, HashMap<String, ArrayList<String>>> SubjectConflicts
                = new HashMap<String, HashMap<String, ArrayList<String>>>();
        HashMap<String, Integer> SubjectInterest = new HashMap<>();

        for (Student student: Students) {
            for (String subject: student.subjects) {
                if (!Subjects.contains(subject)) {
                    Subjects.add(subject);
                    SubjectConflicts.put(subject, new HashMap<>());
                    SubjectInterest.put(subject, 0);
                }
            }
        }

        for (Student student: Students) {  

        }

    }

}

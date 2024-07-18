package org.example.hexlet;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private static final List<Course> COURSES = new ArrayList<>(List.of(
            new Course(0,"Java", "Java Developer"),
            new Course(1,"PHP", "PHP Developer"),
            new Course(2,"JavaScript", "JavaScript Developer")));

    public static List<Course> getCourses() {
        return new ArrayList<>(COURSES);
    }

    public static Course getCourse(int id) {
        return COURSES.get(id);
    }
}

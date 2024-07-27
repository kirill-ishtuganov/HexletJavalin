package org.example.hexlet.controllers;

import io.javalin.http.Context;
import org.example.hexlet.utilities.Data;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.utilities.Data.getCourse;

public class CourseController {

    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        var description = ctx.queryParam("description");
        var courses = findCourses(term, description);
        var page = new CoursesPage(courses, term, description);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParam("id");
        var course = getCourse(Integer.parseInt(id));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static List<Course> findCourses(String term, String description) {

        ArrayList<Course> result = new ArrayList<>();
        if (term != null) {
            for (var course : Data.getCourses()) {
                if (course.getName().toLowerCase().contains(term.toLowerCase())) {
                    result.add(course);
                }
            }
        } else {
            result.addAll(Data.getCourses());
        }

        if (description != null) {
            for (var course : Data.getCourses()) {
                if (course.getDescription().toLowerCase().contains(description.toLowerCase())) {
                    result.add(course);
                }
            }
        } else {
            result.addAll(Data.getCourses());
        }

        Map<Course, Long> map = result.
                stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        return  map.
                entrySet().
                stream().
                filter(e -> e.getValue() > 1).
                map(Map.Entry::getKey).
                collect(Collectors.toList());
    }
}

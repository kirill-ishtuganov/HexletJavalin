package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.UsersController;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.Data.getCourse;
import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPath(), UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.patch(NamedRoutes.userPath(), UsersController::update);

        app.get(NamedRoutes.coursesPath(), ctx -> {
            var term = ctx.queryParam("term");
            var description = ctx.queryParam("description");
            var courses = findCourses(term, description);
            var page = new CoursesPage(courses, term, description);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get(NamedRoutes.coursePath("{id}"), ctx -> {
            var id = ctx.pathParam("id");
            var course = getCourse(Integer.parseInt(id));
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });
        app.start(7070);
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

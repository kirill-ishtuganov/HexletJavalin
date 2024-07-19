package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.Data.getCourse;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("text/html");
            ctx.result(escapedId);
        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            var description = ctx.queryParam("description");
            var courses = findCourses(term, description);
            var page = new CoursesPage(courses, term, description);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
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

        return result.stream().distinct().collect(Collectors.toList());
    }
}

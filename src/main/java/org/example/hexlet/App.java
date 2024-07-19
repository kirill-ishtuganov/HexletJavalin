package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.Data.getCourse;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.hexlet.model.User;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            var page = new UsersPage(term);
            ctx.render("users/index.jte", model("page", page));
        });

        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UsersRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users/build", ctx -> ctx.render("users/build.jte"));

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

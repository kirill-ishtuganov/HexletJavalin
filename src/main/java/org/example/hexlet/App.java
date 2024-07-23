package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controllers.CourseController;
import org.example.hexlet.controllers.UsersController;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.userPath(), UsersController::show);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath(), UsersController::edit);
        app.patch(NamedRoutes.userPath(), UsersController::update);
        app.delete(NamedRoutes.userPath(), UsersController::destroy);

        app.get(NamedRoutes.coursesPath(), CourseController::index);
        app.get(NamedRoutes.coursePath(), CourseController::show);

        app.start(7070);
    }
}

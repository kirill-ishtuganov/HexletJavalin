package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controllers.CourseController;
import org.example.hexlet.controllers.RootController;
import org.example.hexlet.controllers.SessionsController;
import org.example.hexlet.controllers.UsersController;
import org.example.hexlet.utilities.NamedRoutes;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.mainPath(), RootController::index);

        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath(), UsersController::edit);
        app.patch(NamedRoutes.userPath(), UsersController::update);
        app.delete(NamedRoutes.userPath(), UsersController::destroy);
        app.get(NamedRoutes.userPath(), UsersController::show);

        app.get(NamedRoutes.coursesPath(), CourseController::index);
        app.get(NamedRoutes.coursePath(), CourseController::show);

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        app.start(7070);
    }
}

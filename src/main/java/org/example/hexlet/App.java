package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import org.example.hexlet.controllers.CourseController;
import org.example.hexlet.controllers.RootController;
import org.example.hexlet.controllers.SessionsController;
import org.example.hexlet.controllers.UsersController;
import org.example.hexlet.repository.BaseRepository;
import org.example.hexlet.utilities.NamedRoutes;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

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

        app.get(NamedRoutes.buildCoursesPath(), CourseController::build);
        app.get(NamedRoutes.coursesPath(), CourseController::index);
        app.get(NamedRoutes.coursePath(), CourseController::show);
        app.post(NamedRoutes.coursesPath(), CourseController::create);

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        app.start(7070);
    }
}

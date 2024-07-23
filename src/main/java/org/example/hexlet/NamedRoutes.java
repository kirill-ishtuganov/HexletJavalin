package org.example.hexlet;

public class NamedRoutes {

    public static String usersPath() {
        return "/u";
    }

    public static String userPath() {
        return "/u/{id}";
    }

    public static String buildUserPath() {
        return "/u/build";
    }

    public static String coursesPath() {
        return "/courses";
    }

    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }
}

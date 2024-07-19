package org.example.hexlet;

import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepository {
    private static List<User> entities = new ArrayList<>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<User> search(String term) {
        if (term == null) {
            return entities;
        }

        var users = entities.stream()
                .filter(entity -> entity.getName().toLowerCase().startsWith(term.toLowerCase()))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var users = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
        return users;
    }

    public static List<User> getEntities() {
        return entities;
    }

    public static int size() {
        return entities.size();
    }
}
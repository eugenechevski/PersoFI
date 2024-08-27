package PersoFI.model;

import javafx.beans.property.*;

public class Category {
    private final IntegerProperty id;
    private final StringProperty name;
    private final ObjectProperty<User> user;

    public Category(int id, String name, User user) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.user = new SimpleObjectProperty<>(user);
    }

    // Getters and setters
    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public StringProperty nameProperty() { return name; }

    public User getUser() { return user.get(); }
    public void setUser(User user) { this.user.set(user); }
    public ObjectProperty<User> userProperty() { return user; }
}

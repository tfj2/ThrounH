package entities;

public class User {
    private boolean manager;
    private String name;

    public User(boolean manager, String name) {
        this.manager = manager;
        this.name = name;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


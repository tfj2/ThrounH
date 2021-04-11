package entities;

public class User {
    // það er ekki til boolean data type i sqlite svo það þarf að geyma
    // það sem 0 eða 1.
    private int id;
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

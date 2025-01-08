package entities;

public class Contact {
    private int id;
    private String name;
    private String email;
    private String fone;

    public Contact(){}

    public Contact(String name, String email, String fone) {
        this.name = name;
        this.email = email;
        this.fone = fone;
    }

    public Contact(int id, String name, String email, String fone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.fone = fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                '}';
    }
}

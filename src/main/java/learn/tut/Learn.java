package learn.tut;

public class Learn {

    private String name;
    private String location;

    Learn(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Learn{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

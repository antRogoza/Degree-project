package model;

public class Criterion {
    private int id;
    private String name;

    public Criterion(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Criterion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

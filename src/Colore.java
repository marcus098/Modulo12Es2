public class Colore {
    private String name;
    public Colore(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Colore{" +
                "name='" + name + '\'' +
                '}';
    }
}

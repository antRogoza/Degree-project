import view.View;

public class App {
    public static void main(String[] args) {
        View view = new View();
        view.printMessage(View.bundle.getString(View.AUTHORS));
    }
}

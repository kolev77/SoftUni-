package InterfaceExample;

public class InterfaceExample {
    public static void main(String[] args) {

    }
}

class Document implements Printable {
    public void print() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Printable doc = new Document(); // Left side must be interface.
        doc.print();
    }
}


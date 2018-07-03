package Problem_1;

public class VarArgs {

    public static void main(String[] args) {
        String[] arr = {"first", "second", "third"};
        print(arr);
        print();
        print("Pesho", "Mesho", "Venci");
    }


    public static void print(String... varargs) {
        if (varargs.length == 0) {
            System.out.println("No arguments");
            return;
        }
        for (String arg : varargs) {
            System.out.println(arg);
        }

    }
}

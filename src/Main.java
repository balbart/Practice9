import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Введите номер: (0 - выход)");
            String number = in.next();
            if(number.equals("0")){
                break;
            }
            else if(number.matches("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{1,3}")){
            System.out.println(generator.findInArrayList(number));
            System.out.println(generator.binarySearch(number));
            System.out.println(generator.hashSearch(number));
            System.out.println(generator.treeSearch(number));
            }
            else{
                System.out.println("Неправильный ввод");
            }

        }
    }
}

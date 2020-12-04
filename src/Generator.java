import java.util.*;

public class Generator {
    private char[] chars = {'А','В', 'Е','К','М','Н','О','Р','С','Т','У','Х'}; // N = 12
    private String[] nums = {"111","222","333","444","555","666","777","888","999"};
    private ArrayList<String> allSets;

    Generator() {
        allSets = new ArrayList<>();
        generateAll();
    }

    private void generateAll(){
        for(int amount = 0; amount < 2.01E6; amount++){// 2_010_000
            int index4 = (amount % 199) + 1;// регион
            int index3 = (amount / 199) % 12;// последняя буква
            int index2 = (amount/ (199*12)) % 12;//средняя буква
            int index1 = (amount/ (199*12*12)) % 9;//красивый набор цифр
            int index0 = amount / (199*12*12*9);//первая буква
            String number = chars[index0] + nums[index1] + chars[index2] + chars[index3] + String.valueOf(index4);
            allSets.add(number);
        }
    }

    @Override
    public String toString() {
        return "Generator{" +
                "allSets=" + allSets +
                '}';
    }

    public String findInArrayList(String number){
        ArrayList<String> buff = new ArrayList<>(allSets);
        long time = System.nanoTime();
        if(buff.contains(number)) {
            time = System.nanoTime() - time;
            return"Поиск перебором: номер найден, поиск занял " + String.valueOf(time) + "нс";
        }
        else {
            time = System.nanoTime() - time;
            return "Поиск перебором: номер не найден, поиск занял " + String.valueOf(time) + "нс";
        }
    }

    public String binarySearch(String number) {
        ArrayList<String> buff = new ArrayList<>(allSets);
        Collections.sort(buff);
        long time = System.nanoTime();
        if(Collections.binarySearch(buff, number) > -1){
            time = System.nanoTime() - time;
            return "Бинарный поиск: номер найден, поиск занял " + String.valueOf(time) + "нс";
        }
        else{
            time = System.nanoTime() - time;
            return "Бинарный поиск: номер не найден, поиск занял " + String.valueOf(time) + "нс";
        }
    }

    public String hashSearch(String number) {
        HashSet<String> buff = new HashSet<>(new ArrayList<>(allSets));
        long time = System.nanoTime();
        if(buff.contains(number)){
            time = System.nanoTime() - time;
            return "Поиск в HashSet: номер найден, поиск занял " + String.valueOf(time) + "нс";
        }
        else{
            time = System.nanoTime() - time;
            return "Поиск в HashSet: номер не найден, поиск занял " + String.valueOf(time) + "нс";
        }
    }

    public String treeSearch(String number) {
        TreeSet<String> buff = new TreeSet<>(new ArrayList<>(allSets));
        long time = System.nanoTime();
        if(buff.contains(number)){
            time = System.nanoTime() - time;
            return "Поиск в TreeSet: номер найден, поиск занял " + String.valueOf(time) + "нс";
        }
        else{
            time = System.nanoTime() - time;
            return "Поиск в TreeSet: номер не найден, поиск занял " + String.valueOf(time) + "нс";
        }
    }


}

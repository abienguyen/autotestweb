package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class Main {
    //public static void main(String[] args) {
    //    System.out.println("Hello World!");
    //}

    public static void main(String[] args) {
        // TODO: co caro 3x3
        /** print out
         *   |  |
         * --+--+--
         *   |  |
         * --+--+--
         *   |  |
         */

        String[] row1 = new String[]{" ", "|", " ", "|", " "}; // 0 2 4
        String[] row2 = new String[]{"-", "+", "-", "+", "-"}; // 0 2 4
        String[] row3 = new String[]{" ", "|", " ", "|", " "}; // 0 2 4
        String[] row4 = new String[]{"-", "+", "-", "+", "-"}; // 0 2 4
        String[] row5 = new String[]{" ", "|", " ", "|", " "}; // 0 2 4

        List<String[]> table = List.of(row1, row2, row3, row4, row5);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please select from 1-9");
        int select = myObj.nextInt();
        selectPoint(table, select, "X");
        printTable(table);

        selectPoint(table, getRandomNumber(1, 9), "O");
        printTable(table);
    }

    public static void printTable(List<String[]> table) {
        for (String[] row : table) {
            for (String ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void selectPoint(List<String[]> table, int select, String player) {
        switch (select) {
            case 1: {
                table.get(0)[0] = player;
                break;
            }
            case 2: {
                table.get(0)[2] = player;
                break;
            }
            case 3: {
                table.get(0)[4] = player;
                break;
            }
            case 4: {
                table.get(2)[0] = player;
                break;
            }
            case 5: {
                table.get(2)[2] = player;
                break;
            }
            case 6: {
                table.get(2)[4] = player;
                break;
            }
            case 7: {
                table.get(4)[0] = player;
                break;
            }
            case 8: {
                table.get(4)[2] = player;
                break;
            }
            case 9: {
                table.get(4)[4] = "X";
                break;
            }
            default:
                break;
        }
    }

       /* public static void selectPoint(List<String[]> table){}

        for(String s : row1){
            System.out.println(s);
        }
        System.out.println();
        for(String s : row2){
            System.out.println(s);
        }
        System.out.println();
        for(String s : row3){
            System.out.println(s);
        }
        System.out.println();
        for(String s : row4){
            System.out.println(s);
        }
        System.out.println();
        for(String s : row5){
            System.out.println(s);
        }
        System.out.println();
    }*/


    //BT ex2 - Day 2
    /*public static void main(String[] args) {
        List<Person> student = List.of(new Person("Lê An"), new Person("Trần Thuỳ"), new Person("Nguyễn Thị Ánh"),
                new Person("Ngô Gia"), new Person("Dương Văn Hồng"));
        student.stream().forEach(Person::info);

        //tìm người già nhất

        List<Integer> years = student.stream().map(person -> person.getYearOfBirth()).collect(Collectors.toList());
        //stream.map là lấy 1 thuộc tính của 1 đối tượng ra ngoài và đưa vào collection
        int oldest = years.stream().min(Comparator.naturalOrder()).get();
        System.out.println(oldest);
        student.stream().filter(person -> person.getYearOfBirth() == oldest).toArray();

        for (int i = 0; i < 5; i++) {
            System.out.println(new Random().nextInt());
        }
    }



   /* public static void main(String[] args) {
        Point pointA = new Point(1,1);
        Point pointB = new Point(0,1);
        Point pointC = new Point(2,1);

        pointA.info();
        pointB.info();

        //AB lenght
        //int ab = (pointA.getX() - pointB.getX() *pointA.getX() - pointB.getX())+ (pointA.getY()  - pointB.getY())*(pointA.getX() - pointB.getX());
        //System.out.println(Math.sqrt(ab);

        System.out.println(length(pointA,pointB));
        System.out.println(length(pointA,pointC));
        System.out.println(length(pointB,pointC));
    }

    //pow() là hàm bình phương
    //sqrt() là hàm căn 2
    //BT tính tam giác
    private static double length(Point a, Point b){
     double ab = Math.pow(a.getX() - b.getX(),2) + Math.pow(a.getY() - b.getY(),2);
     return Math.sqrt(ab);
    }*/

    /*public static void main(String[] args) {
        int[] numbers = {1,4,5,7,9};
        int sum = 0;
        System.out.println(Arrays.stream(numbers).sum());// Tính tổng của mảng

        int[] array = {1,3,4,5,6};
        int [] filtered = Arrays.stream(array).filter(n -> n>5).toArray();//lọc phần tử >5
        Arrays.stream(filtered).forEach(System.out::println);

        //tìm vị trí của 2 phần tử trong mảng, sao cho tổng 2 phần tử đó numbers[i] + numbers [j] = 5 ==> {i,j}
        for(int i = 0; i < numbers.length; i++) {
            int j;
            for (j = 0; j < numbers.length; j++) ;
            if ((j != i) && numbers[i] + numbers[j] == 5) {
                int[] result = {i, j};
                System.out.println("found" + " " + j);
                break;
            }
        }

    }
}*/

    public class RemoveWhiteSpaces{
        public static void main (String[] args){
            String str = "         Hello              Japne     et         ";
            str = str.trim();// dùng hàm trim xoá space đầu và cuối
            System.out.print(str);
            System.out.println(str.replaceAll("\\s", " "));
            //dùng replaceALl để xoá  các space giữa các từ
            //dùng replace để xoá từng ký tự
        }

        private static String removeWhiteSpace(String str){
            String newStr = str.replaceAll("\\s", "");
            return newStr;
        }
    }

    public static boolean kiemTraNguyenAm(String letter) {
        if (letter.length() == 1) {
            if (letter.equalsIgnoreCase("u") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("i")) {
                System.out.println(letter + " la nguyen am");
                return true;
            } else {
                System.out.println(letter + " khong la nguyen am");
                return false;
            }
        } else throw new IllegalArgumentException("Please pass a letter only!");

    }

    public static boolean kiemTraSoChan(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " la so chan");
            return true;
        } else {
            System.out.println(number + " la so le");
            return false;
        }
    }

    public static boolean checkLenghth(String password) {
        if (password.length() >= 8) {
            return true;
        } else
            return false;
    }

    String password = "Password";

    public static boolean checkLength(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            System.out.println(password.charAt(i));
            Character.isDigit(password.charAt(i));
            result = true;
            break;
        }
        return result;
    }

    public static boolean checkUpCase(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            System.out.println(password.charAt(i));
            Character.isUpperCase(password.charAt(i));
            result = true;
            break;
        }
        return result;
    }
    public static boolean checkLowerCase(String password){
        boolean result = false;
        for(int i = 0; i<password.length();i++){
            System.out.println(password.charAt(i));
            Character.isLowerCase(password.charAt(i));
            result = true;
            break;
        }
        return result;
    }
    public static boolean checkFirstChar(String password){
        return Character.isLetter(password.charAt(0));
    }
    public static boolean checkKiTuTrungNhau (String password){
        boolean result = true;
        for (int i = 0; i <password.length(); i++){
            int count = 0;
            for (int j = 1; j<password.length();j++){
                if (password.charAt(i) == password.charAt(j)){
                    count++;
                    if (count >= 3) {
                        result = false;
                    }
                }
            }
        }
        return result;

    }

}



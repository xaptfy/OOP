package com.company;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Object[][] city = {
                {"Nice", 942208},
                {"Abu Dhabi", 1482816},
                {"Naples", 2186853},
                {"Vatican City", 572}
        };

        System.out.println("Задание 1: " + first(city));
        System.out.println("Задание 2: " + second(2));
        System.out.println("Задание 3: " + third("scissors","scissors")) ;
        System.out.println("Задание 4: " + fourth(new int[]{5,9,45,6,2,7,34,8,6,90,5,243}));
        System.out.println("Задание 5: " + fifth("SpOnTaNeOuS"));
        System.out.println("Задание 6: " + sixth("PuMpU"));
        System.out.println("Задание 7: " + seventh(1,2,2,1,1));//for false use 1,2,2,1,1
        System.out.println("Задание 8: " + eighth(36.1, 8.6, 3, true));//331.83
        System.out.println("Задание 9: " + ninth(new int[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println("Задание 10: " + tenth(12));
    }
    public static String first(Object[][] mass){
       for (int i=0; i < mass.length; i++) {
            mass[i][1] = (((int)mass[i][1]+500000)/100000)*1000000;
       }
       return Arrays.deepToString(mass);
    }
    public static String second(double a){
        double[] sides = new double[2];
        sides[0]=Math.floor((a*2)*100)/100;
        //sides[1] = Math.floor(Math.sqrt(Math.pow(sides[0],2)-Math.pow(a,2))*100/100;
        sides[1]=Math.floor(((a*2)*Math.cos(Math.toRadians(30)))*100)/100;
        return Arrays.toString(sides);
    }
    public static String third(String p1, String p2) {
        if ((p1 == "paper" && p2 == "paper")||(p1 == "rock" && p2 == "scissors")||(p1 == "scissors" && p2 == "paper")) {
            return "TUE";
            }
            else if ((p1 == "paper" && p2 == "paper")||(p1 == "rock" && p2 == "scissors")||(p1 == "scissors" && p2 == "paper")) {
                return "Player 1 WINS";
            }
            else return "Player 2 WINS";
        }
    public static int fourth(int[] m){
    int k_ch=0; int k_nech=0;
    for (int i=0; i< m.length;i++) {
        if(m[i]%2==0) k_ch += m[i];
        else k_nech+=m[i];
    }
    return Math.abs(k_ch-k_nech);
    }
    public static String fifth(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c))
                chars[i] = Character.toLowerCase(c);
            else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
        }
        return new String(chars);
    }
    public static String sixth(String str) {
        int l=str.length();
        str = str.toLowerCase();
        char s1 = str.charAt(l-1);
        if((s1=='a')||(s1=='o')||(s1=='y')||(s1=='u')||(s1=='i')) return (str+"-inator" + 1 + "000");
        else return (str+"inator"+l+"000");
    }
    public static boolean seventh(int a, int b, int c, int w, int h) {
        return ((a*b) <= (w*h))|| ((a*c) <= (w*h)) || ((b*c) <= (w*h));
    }
    public static double eighth(double fuel, double cost, int pass, boolean air){
        cost = cost + cost * 0.05 * pass;
                if (air)
                    cost = cost + cost * 0.1;
                return Math.floor(fuel*10000/cost)/100;
    }
    private static double ninth(int [] mass){
        double mean = 0;
        for (int i=0;i<mass.length;i++){
            mean+=mass[i];
        }
        mean=mean/mass.length;
        return Math.floor(mean*100)/100;
    }
    public static boolean tenth(int num2) {
        int sum = 0; int num1 = num2;
        while (num2 >= 1){
            sum += num2 % 10;
            num2 = num2 / 10;
        }
        return sum % 2 == num1 % 2;
    }


}

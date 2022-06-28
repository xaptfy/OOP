package com.company;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Задание 1: " + first(5));
        System.out.println("Задание 2: " + second(38, 8));
        System.out.println("Задание 3: " + third(5, 0, 2));
        System.out.println("Задание 4: " + fourth(51));
        System.out.println("Задание 5: " + fifth(true, false));
        System.out.println("Задание 6: " + sixth(46, 4, 5));
        System.out.println("Задание 7: " + squared(5));
        System.out.println("Задание 8: " + eighth(0.9D, 3, 2));
        System.out.println("Задание 9: " + ninth(10, 25));
        System.out.println("Задание 10: " + tenth(7, 2));
    }

    public static int first(int zad1) {
        return zad1 * 60;
    }

    public static int second(int d_o, int t_o) {
        return d_o * 2 + t_o * 3;
    }

    public static int third(int w, int d, int l) {
        return w * 3 + d;
    }

    public static boolean fourth(int c1) {
        return c1 % 5 == 0;
    }

    public static boolean fifth(boolean b1, boolean b2) {
        return b1 && b2;
    }

    public static int sixth(int n, int w, int h) {
        return n / (w * h);
    }

    public static int squared(int a) {
        return a * a;
    }

    public static boolean eighth(double prob, int prize, int pay) {
        return prob * (double)prize - (double)pay > 0.0D;
    }

    public static int ninth(int f1, int min) {
        return f1 * 60 * min;
    }

    public static int tenth(int n1, int n2) {
        return n1 - n1 / n2 * n2;
    }
}

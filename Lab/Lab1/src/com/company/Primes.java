package com.company;

public class Primes {

    public static void main(String[] args) {
        System.out.println(isPrime(13));
        for  (int i = 2; i <= 100; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }

    }
    public static boolean isPrime(int n){
        //проверяет является ли число простым
        for  (int i = 2; i < n; i++){
          if (n%i==0){
              return false;
          }

        }
        return true;

    }
}

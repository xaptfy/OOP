import java.util.Arrays;
import java.util.*;
public class zad4 {

    //4.1
    public static String n1(int[] arr) {
        String str="";
        for (int i : arr) {
            str+=Integer.toString(i);
        }
        if (str.contains("7")) {
            return "Boom!";
        }
        return "There is no 7 in array";
    }
    //4.2
    public static boolean n2(int[] arr) {
        Arrays.sort(arr);
        for (int i=1;i< arr.length;i++) {
            if(arr[i]-1!=arr[i-1])
                return false;
        }
        return true;
    }
    //4.3
    public static String n3(String str) {
        String res="";
        for (int i=0;i<str.length()/2;i++) {
            res+=str.charAt(i*2+1);
            res+=str.charAt(i*2);
        }
        if(str.length()%2==1) {
            res+=str.charAt(str.length()-1);
        }
        return res;
    }
    //4.4
    public static String n4(String str) {
        int i=str.length()-1;
        while ((str.charAt(i)=='!' || str.charAt(i)=='?') && i!=0 && (str.charAt(i-1)=='!' ||str.charAt(i-1)=='?') ) {
            str = str.substring(0,i);
            i-=1;
        }
        return str;
    }
    //4.5
    public static String n5(String a) {
        String[] str = a.split(" ");
        String res = "";
        for(int i = 0; i < str.length;i++){
            if (str[i].length()==1){
                str[i]=str[i].replace("x","ecks");
            } else if (str[i].charAt(0)=='x'){
                str[i]=str[i].replaceFirst("x","z");
            } else {
                str[i]=str[i].replaceAll("x","cks");
            }
            res += str[i] + " ";
        }

        return res;
    }
    //4.6
    public static int n6(int[] arr) {
        int res=0;
        Arrays.sort(arr);
        for (int i=1;i<arr.length;i++) {
            if (res<arr[i]-arr[i-1])
                res=arr[i]-arr[i-1];
        }
        return res;
    }
    //4.7
    public static int n7(int a) {
        String newstr = "";
        String stra = Integer.toString(a);
        int[] ne = new int[stra.length()];
        for (int i = 0; i < stra.length(); i++) {
            ne[i] = Integer.parseInt(stra.substring(i, i+1));
        }
        Arrays.sort(ne);
        for (int i = 0; i < stra.length(); i++) {
            newstr += Integer.toString(ne[i]);
        }
        int dif = a - Integer.parseInt(newstr);
        return a-dif<0?0:dif;
    }
    //4.8
    public static void commonLastVowel(String s1) {
        String str = s1.toLowerCase();
        String words[] = str.split(" ");
        int count[] = new int[6];//aeiouy
        for (int i = 0; i < 6; i++)
            count[i] = 0;
        String vowel = "aeiouy";
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < vowel.length(); j++) {
                if (words[i].charAt(words[i].length() - 1) == vowel.charAt(j))
                    count[j]++;
            }
        }
        int max = count[0];
        int k = 0;
        for (int i = 1; i < 6; i++) {
            //System.out.print(count[i]+" ");
            if (count[i] > max) {
                k = i;
                max = count[i];
            }
        }
        System.out.println(vowel.charAt(k));
    }
    //4.9
    public static int n9(int a, int b) {
        String res="";
        int maxlen=(int)Math.log10(Math.max(a, b));
        for (int i=0;i<=maxlen;i++) {
            res+=Integer.toString(a/(int)Math.pow(10, maxlen-i)+(int)b/(int)Math.pow(10, maxlen-i));
            a%=(int)Math.pow(10, maxlen-i);
            b%=(int)Math.pow(10, maxlen-i);
        }
        return Integer.parseInt(res) ;
    }
    //4.10
    public static String n10(String str) {
        String res="";
        for (int i=0;i<str.length();i++) {
            if(!res.contains(Character.toString(str.charAt(i)))) {
                res+=str.charAt(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.print(n7(123));
    }

}
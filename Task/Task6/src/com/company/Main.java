
import java.util.*;


public class Main {


    public static void main(String[] args) {
        System.out.println("Задание 1");
        task1();
        System.out.println("Задание 2");
        task2();
        System.out.println("Задание 3");
        task3();
        System.out.println("Задание 4");
        task4();
        System.out.println("Задание 5");
        task5();
        System.out.println("Задание 6");
        task6();
        System.out.println("Задание 7");
        task7();
        System.out.println("Задание 8");
        task8();
        System.out.println("Задание 9");
        task9();
        System.out.println("Задание 10");
        task10();
    }


    static void task1(){
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
    }

    public static String clearTrashFromString(String str){ //убираем ненужный мусор из строки(в том числе и пробелы)
        str = str.toLowerCase(Locale.ROOT);
        for (int i = 0; i < str.length(); i++){
            if ((str.charAt(i) < 97) || (str.charAt(i) > 122)){
                char symb = str.charAt(i);
                str = str.replace(symb, ' ');
            }
        }
        while (str.contains(" ")){
            str = str.replaceFirst(" ", "");
        }
        return str;
    }

    public static String hiddenAnagram(String str, String anag){
        str = clearTrashFromString(str);
        anag = clearTrashFromString(anag);
        boolean check = false;
        int length = anag.length();
        for (int i = 0; i <= str.length() - length; i++){
            String tempStr = str.substring(i, i + length); //берём кусок строки длиной как ключ
            String tempStr2 = anag;
            for (int j = 0; j < length - 1; j++){
                if (tempStr2.contains(Character.toString(tempStr.charAt(j)))){ //если символ есть в ключе, то убираем
                    tempStr2 = tempStr2.replaceFirst(Character.toString(tempStr.charAt(j)), ""); // символ
                    check = true;
                }else{ // если совпадения нет, то это точно не анаграма
                    check = false;
                    break;
                }
            }
            if (check){ //если анаграма была успешно найдена
                return tempStr;
            }
        }
        return "notfound";
    }

    static void task2(){
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
    }

    public static ArrayList<String> collect(String str, int count){
        if (str.length() < count){
            return new ArrayList<>();
        }
        String s1 = str.substring(0, count); //режем первое слово из строки
        String s2 = str.substring(count); //оставляем остатки в новой строке, которую передадим как новый параметр
        ArrayList<String> result = new ArrayList<>();
        result.add(s1);
        result.addAll(collect(s2, count));
        Collections.sort(result); // сортируем список и затем его возращаем
        return result;
    }

    static void task3(){
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
    }

    public static String nicoCipher(String message, String key){
        if (message.equals("")) return "";
        int[] keyValue = new int[key.length()]; //хранит ключи к символам в ключевом слове
        char[] keyChar = key.toCharArray(); //(извлекаем и скачиваем нужную инфу)парсим сам ключ на символы
        int min, index;
        for(int i = 0; i < key.length(); i++){//присваиваем значение ключам символов в алфаитном порядке
            min = 1000;
            index = -1;
            for (int j = 0; j < key.length(); j++){
                if (keyChar[j] < min){
                    min = keyChar[j];
                    index = j;
                }
            }
            if (index != -1){
                keyChar[index] = 1000;
                keyValue[index] = i;
            }
        }
        int count = 0, length = message.length();
        while (length > key.length()){ //считаем кол-во подстрок
            count++;
            length -= key.length();
        }
        if (length > 0) count++; //если есть неполная подстрока(пробелы же тоже добавляются)
        String[] words = new String[count];
        for (int i = 0; i < count; i++){
            words[i] = "";
        }
        for (int i = 0; i < words.length; i++){
            for (int j = i * key.length(); j < (i + 1) * key.length(); j++){//по сути это шаг - это длина ключа(слова)
                if (j < message.length()){
                    words[i] += message.charAt(j); //пока не дошли до конца собираем в массив
                }else{
                    words[i] += " "; // если вдруг мы вышли за конец, то докидываем пробелы
                }
            }
        }
        for (int i = 0; i < words.length; i++){
            char[] word = (words[i]).toCharArray();
            char[] temp = new char[word.length];
            for (int j = 0; j < keyValue.length; j++){
                temp[keyValue[j]] = word[j]; // раставляем буквы в порядке кодировки
            }
            StringBuilder temp2 = new StringBuilder();
            for (char ch : temp){
                temp2.append(ch); //собираем новое слово из переставленных букв
            }
            words[i] = temp2.toString(); //кладём новое слово в массив
        }
        StringBuilder result = new StringBuilder();
        for (String word : words){
            result.append(word);
        }
        return result.toString();
    }

    static void task4(){
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15, 3}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15 )));
    }

    public static int[] twoProduct(int[] arr, int prod){ // пробегаемся слева и ищем первое удачное совпадение
        int[] result = new int[2];
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if ((arr[i] * arr[j]) == prod){
                    result[1] = arr[i];
                    result[0] = arr[j];
                    return result;
                }
            }
        }
        return new int[]{};
    }

    static void task5(){
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println(Arrays.toString(isExact(362880)));
    }

    public static int[] isExact(int num, int n){
        if (num == 0){
            return new int[]{};
        }
        if (num == 1){
            return new int[]{1, 1};
        }
        n++;
        if (num % n == 0){
            try {
                return new int[]{num, isExact(num / n, n)[1] + 1};
            } catch (ArrayIndexOutOfBoundsException e){
                return new int[]{};
            }
        }else{
            return new int[]{};
        }
    }

    public static int[] isExact(int num){
        if (num == 0){
            return new int[]{};
        }
        if (num == 1){
            return new int[]{1, 1};
        }
        if (num % 2 == 0){
            try {
                return new int[]{num, isExact(num / 2, 2)[1] + 1};
            } catch (ArrayIndexOutOfBoundsException e){
                return new int[]{};
            }
        }else{
            return new int[]{};
        }
    }

    static void task6(){
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
    }

    public static String fractions(String num){
        int k = -1, s = -1;
        String intPart = "";
        String period = "";
        for (int i = 0; i < num.length(); i++){//запоминаем позицию сепаратора
            if (num.charAt(i) == '.'){
                k = i;
            }
            if (num.charAt(i) == '('){//запоминаем позицию начала периода
                s = i;
            }
        }
        num = num.replace('(', ' ');
        num = num.replace(')', ' ');
        num = num.replaceAll(" ", ""); //чистим всю фигню(видимо кроме точки =) )
        intPart = num.substring(0, k); //целая часть числа
        StringBuilder helper = new StringBuilder();
        if(s - k == 1){ // если период начинается сразу же после сепаратора
            period = num.substring(k + 1);
            for (int i = 0; i < period.length(); i++){
                helper.append("9");
            }
        }else{ //если не сразу
            String fraction = num.substring(k + 1); //вся дробная часть
            String partFraction = num.substring(k + 1, s); //дробная часть, без периода
            for (int i = 0; i < fraction.length() - partFraction.length(); i++){
                helper.append("9");
            }
            for (int i = 0; i < partFraction.length(); i++){
                helper.append("0");
            } //теперь смотрим на новый период по правилу: вся дробная часть - дробная часть без периода
            period = Integer.toString(Integer.parseInt(fraction.toString()) - Integer.parseInt(partFraction.toString()));
        }
        int p, h, i = 2;
        if (!(period.equals("") || helper.toString().equals(""))){ //собираем период и хелпер в числа
            p = Integer.parseInt(period);
            h = Integer.parseInt(helper.toString());
        }else{
            p = -1;
            h = -1;
        }
        while (i < p || i < h){ //ищем общие делители и по максимому сокращаем
            if ((p % i == 0) && (h % i == 0)){
                p /= i;
                h /= i;
                i = 2;
            }else {
                i++;
            }
        }
        int iP;
        if (!(intPart.equals(""))){
            iP = Integer.parseInt(intPart); //переводим строковое представление целой части в число
        }else{
            iP = -1;
        }
        return ((iP * h) + p) + "/" + h;
    }

    static void task7(){
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESIN" +
                "VOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
    }

    public static String pilish_string(String str){
        if (str.equals("")){
            return str;
        }
        while (str.contains(" ")){
            str = str.replace(" ", "");
        }
        if (str.length() > 77){
            str = str.substring(0,77);
        }
        StringBuilder result = new StringBuilder();
        int[] arr = new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        String tempWord = "";
        int counter = 0;
        int tempNum = arr[counter];
        for (int i = 0; i < str.length(); i++){//пробегаемся по строке и режем её на символы
            if (tempNum > 0){
                tempWord += str.charAt(i);
                tempNum--;
            }else{
                counter++;
                tempNum = arr[counter] - 1;
                result.append(tempWord).append(" ");
                tempWord = "" + str.charAt(i);
            }
        }
        if (tempNum > 0){//если строка закончилась, но до пи ещё надо добаить
            while (tempNum > 0){
                tempWord += tempWord.charAt(tempWord.length() - 1);
                tempNum--;
            }
            result.append(tempWord).append(" ");
        }else if(!(tempWord.equals(""))){
            result.append(tempWord).append(" "); //вроде как докидываем если остался какой-то мусор(значит он не мусор, а полезное)
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    static void task8(){
        System.out.println(generateNonconsecutive(1));
        System.out.println(generateNonconsecutive(2));
        System.out.println(generateNonconsecutive(3));
        System.out.println(generateNonconsecutive(4));
        System.out.println(generateNonconsecutive(5));
        System.out.println(generateNonconsecutive(6));
        System.out.println(generateNonconsecutive(7));
    }

    public static String generateNonconsecutive(int n){
        if (n < 1) return "";
        ArrayList<String> list = new ArrayList<>();
        StringBuilder tempWord = new StringBuilder();
        for (int i = 0; i < n; i++){//генерим строку вида 1010101
            if (i % 2 == 0){
                tempWord.append("1");
            }else{
                tempWord.append("0");
            }
        }
        list.add(tempWord.toString());
        String zero = "";
        for (int i = 0; i < n; i++){//генерация последнего(1-го) числа, состоящего только из нулей
            zero += "0";
        }
        while (!(tempWord.toString().equals(zero))){//пока не получим это 00000 число
            for(int i = tempWord.length() - 1; i >= 0; i--){
                if (tempWord.charAt(i) == '1'){
                    tempWord.replace(i, i + 1, "0");
                    if (i == tempWord.length() - 2){// если на предпоследнем месте то просто шаг с генерацией
                        tempWord.replace(i + 1, i + 2, "1");
                        list.add(tempWord.toString());
                        break;
                    }else{//либо уже 00000 либо 1 оказалось на последнем месте
                        if (tempWord.toString().equals(zero)){//если уже получили 00000
                            list.add(tempWord.toString());
                            break;
                        }
                        list.add(tempWord.toString());
                        boolean check = false;
                        for(int j = tempWord.length() - 1; j >= 0; j--){
                            if (tempWord.charAt(j) == '1'){
                                check = true;
                                tempWord.replace(j, j + 1, "0"); //меняем 1 на ноль
                                for (int k = j + 1; k < tempWord.length(); k++){ //генерация со следующей позиции новой
                                    if (k % 2 == (j + 1) % 2){                   //чередующейся последовательности
                                        tempWord.replace(k, k + 1, "1");
                                    }else{
                                        tempWord.replace(k, k + 1, "0");
                                    }
                                }
                                list.add(tempWord.toString());
                                break;
                            }
                        }
                        if(check){
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--){
            result.append(list.get(i)).append(" ");
        }
        result.replace(result.length() - 1, result.length(), "");
        return result.toString();
    }

    static void task9(){
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
    }

    public static String isValid(String str){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            String symbol = str.substring(i, i+1);
            map.computeIfPresent(symbol, (key, val) -> val + 1);
            map.putIfAbsent(symbol, 1);
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            arr[i] = entry.getValue();
            i++;
        }
        boolean replace = false;
        for (int j = 1; j < arr.length; j++){
            if (arr[j - 1] != arr[j]){
                if (replace){
                    return "NO";
                }
                if (arr[j - 1] > arr[j]){
                    arr[j - 1]--;
                    replace = true;
                }else{
                    arr[j]--;
                    replace = true;
                }
            }
        }
        for (int j = 1; j < arr.length; j++){
            if (arr[j - 1] != arr[j] && replace){
                return "NO";
            }
        }
        return "YES";
    }

    static void task10(){
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})));
    }

    public static int[][] sumsUp(int[] arr){
        int p = 0;
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] + arr[j] == 7){
                    p++;
                }
            }
        }
        int[][] result = new int[p][2];
        p = 0;
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] + arr[j] == 7){
                    result[p++] = new int[]{Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                }
            }
        }
        return result;
    }

}
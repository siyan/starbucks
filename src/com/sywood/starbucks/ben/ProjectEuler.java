package com.sywood.starbucks.ben;
import java.math.BigInteger;
import java.util.ArrayList;

public class ProjectEuler {
    static int fib(int i){
        if (i == 0| i == 1){
            return 1;
        }else{
            return fib(i-1) + fib(i-2);
        }
    }
    static boolean isPrime(int num){
        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    static boolean isPal(int num){
        String rev = "";
        String a = String.valueOf(num);
        for (int i = a.length()-1; i >= 0; i--) {
            rev += a.charAt(i);
        }
        return rev.equals(a);
    }
    static int one(){
        int ret = 0;
        for (int i = 1; i < 1000; i++) {
            if (i%3==0 | i%5 == 0){
                ret += i;
            }
        }
        return ret;
    }

    static int second(){
        int i = 1;
        int ret = 0;
        while (fib(i) < 4000000){
            int b = fib(i);
            if (b % 2 == 0){
                ret += b;
            }
            i++;
        }
        return ret;
    }
    static int third(){
        int ret = 0;
        for (int i = 2; i < Math.sqrt(600851475143L); i++) {
            if (600851475143L % i == 0 & isPrime(i)){
                ret = i;
            }
        }
        return ret;
    }
    static int four(){
        int ret = 0;
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                if (isPal(i*j) & i*j > ret){
                    ret = i*j;
                }
            }
        }
        return ret;
    }
    static int five(){
        int ret = 1;
        for (int i = 20; i >= 2; i--) {
            if (ret % i != 0){
                ret *= i;
            }
        }
        return ret;
    }
    static int six(){
        int sum = 0;
        int other = 0;
        for (int i = 1; i <= 100; i++) {
            sum += (int) Math.pow(i, 2);
            other += i;
        }other = (int) Math.pow(other, 2);
        return other-sum;
    }
    static int seven(){
        ArrayList<Integer> primes = new ArrayList<>();
        int i = 2;
        while(primes.size() != 10001){
            if (isPrime(i)){
                primes.add(i);
            }
            i++;
        }
        return primes.get(10000);
    }
    static void eight(){
        String num = "73167176531330624919225119674426574742355349194934" +
                     "96983520312774506326239578318016984801869478851843" +
                     "85861560789112949495459501737958331952853208805511" +
                     "12540698747158523863050715693290963295227443043557" +
                     "66896648950445244523161731856403098711121722383113" +
                     "62229893423380308135336276614282806444486645238749" +
                     "30358907296290491560440772390713810515859307960866" +
                     "70172427121883998797908792274921901699720888093776" +
                     "65727333001053367881220235421809751254540594752243" +
                     "52584907711670556013604839586446706324415722155397" +
                     "53697817977846174064955149290862569321978468622482" +
                     "83972241375657056057490261407972968652414535100474" +
                     "82166370484403199890008895243450658541227588666881" +
                     "16427171479924442928230863465674813919123162824586" +
                     "17866458359124566529476545682848912883142607690042" +
                     "24219022671055626321111109370544217506941658960408" +
                     "07198403850962455444362981230987879927244284909188" +
                     "84580156166097919133875499200524063689912560717606" +
                     "05886116467109405077541002256983155200055935729725" +
                     "71636269561882670428252483600823257530420752963450";
        long product = 0;
        for (int i = 0; i < num.length()-13; i++) {
            String sub = num.substring(i, i+13);
            long tot = 1;
            for (char digit : sub.toCharArray()){
                tot *= (int) digit;
            }
            if (tot > product){
                product = tot;
            }
        }
        System.out.println(product);
    }
    public static void nine(){
        for (int a = 1; a < 333; a++){
            for (int b = a+1; b < 666; b++){
                int c = 1000 -a -b;
                if (a*a + b*b == c*c){
                    System.out.println(a + ", " + b + ", " + c);
                    System.out.println(a*b*c);
                }
            }
        }
    }
    public static void ten(){
        long sum = 2L;
        int i = 3;
        while(i < 2000000){
            if (isPrime(i)){
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }
    public static void eleven(){
        int max = 0;
        int[][] nums = new int[][]{
                {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
                {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
                {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
                {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2,36, 91},
                {22, 31,16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
                {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
                {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
                {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
                {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72,},
                {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
                {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
                {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36 ,29 ,85 ,57},
                {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
                {19, 80, 81,68 ,5, 94, 47, 69, 28, 73, 92, 13, 86 ,52 ,17 ,77 ,4, 89, 55, 40},
                {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
                {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
                {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
                {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
                {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
                {1, 70, 54, 71, 83, 51, 54 ,69 ,16 ,92 ,33 ,48 ,61, 43, 52,1, 89, 19, 67, 48}
        };
        long largest = 0;
        for (int i = 0; i < 20; i++){
            for (int j = 0; j <= 16; j++){
                int product = nums[i][j]*nums[i][j+1]*nums[i][j+2]*nums[i][j+3];
                largest = largest < product ? product : largest;
            }
        }for (int i = 0; i <= 16; i++){
            for (int j = 0; j < 20; j++){
                int product = nums[i][j]*nums[i+1][j]*nums[i+2][j]*nums[i+3][j];
                largest = largest < product ? product: largest;
            }
        }for (int i = 0; i <= 16; i++){
            for (int j = 3; j < 20; j++){
                int product = nums[i][j]*nums[i+1][j-1]*nums[i+2][j-2]*nums[i+3][j-3];
                largest = largest < product ? product: largest;
            }
        }for (int i = 0; i <= 16; i++){
            for (int j = 0; j <= 16; j++){
                int product = nums[i][j]*nums[i+1][j+1]*nums[i+2][j+2]*nums[i+3][j+3];
                largest = largest < product ? product: largest;
            }
        }
        System.out.println(largest);
    }
    static int factors(long num){
        int ret = 0;
        for (int i = 1; i <= num; i++){
            if (num % i == 0){
                ret += 1;
            }
        }
        return ret;
    }
    static void twelve(){
        int divisors = 0;
        long num = 0;
        long i = 1;
        while (divisors <= 500){
            num += i;
            divisors = (factors(num));
            i++;
            System.out.println(i + ", " + num + ", " + divisors);
        }
        System.out.println(divisors);
    }

    public static void main(String[] args){
        twelve();
    }
}

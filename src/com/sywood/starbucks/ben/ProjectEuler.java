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
    static int eight(){
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
        int product = 0;
        for (int i = 0; i < num.length()-13; i++) {
            String sub = num.substring(i, i+13);
            int tot = 1;
            for (char digit : sub.toCharArray()){
                tot *= (int) digit;
            }
            if (tot > product){
                product = tot;
            }
        }
        return product;
    }
    public static void nine(){
        long A = 0;
        long B = 0;
        long C = 0;
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
        int sum = 0;
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        int i = 3;
        while(primes.get(primes.size()-1) < 2000000){
            if (isPrime(i)){
                primes.add(i);
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args){
        ten();
    }
}

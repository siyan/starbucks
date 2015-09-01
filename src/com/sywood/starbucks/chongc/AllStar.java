package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/8/23.
 */
public class AllStar {




    public static String AllStar(String str){
        if(str.length()<=0){
            return null;
        }else{
            return str.substring(0,1)+"*"+AllStar(str.substring(1));
        }
    }








    public static boolean strCopies(String str,String sub,int count){

        if(count==0){
            return true;
        }else{
            if(str.length()<sub.length()){
                    return false;     /////not finished yet
            }
        }

        return true; ///written to prevent error


    }














    public static int sumDigits(int num){
        if(num / 10 == 0) {
            return 0;
        }else{
            return num % 10 + sumDigits(num/10);
        }
    }













    public static int countPairs(String str){
        if(str.length()!=0) {
            if (str.substring(0).equalsIgnoreCase(str.substring(2))) {
                return 1 + countPairs(str.substring(1));
            } else {
                return countPairs(str.substring(1));
            }
        }else{
            return 0;
        }
    }




    public static String stringClear(String str){
        if(str.substring(0,1).equalsIgnoreCase(str.substring(1,2))){

        }

         return null;
    }                    //



    public static String noX(String str ){
        if(str.substring(0,1).equalsIgnoreCase("x")) {
            return noX(str.substring(1));
        }else{
            return str.substring(0,1) + noX(str.substring(1));
        }
    }

    public static boolean array6(int[] array){
        if(array.length!=0) {
            return array[0] == 6 || array6(array);    //Wait, how do you summon the second to the last number in an array?
        }else{
            return false;
        }
    }

    public static String changePi(String str){
        if(str.length()<=0){
            return null;
        }else{
            if(str.substring(0,2).equalsIgnoreCase("pi")){
                return "3.14" + changePi(str.substring(2,str.length()));
            }else{
                return str.substring(0,1) + changePi(str.substring(1));
            }
        }
    }

    public static boolean nestParen(String str){
        if(str.length()>=2) {
            if (str.substring(0, 0) == "(" && str.substring(str.length()) == ")") {
                return nestParen(str.substring(1, str.length() - 1));
            } else {
                return true;
            }
        }else{
            return true;
        }
    }

    public static String parenBit(String str){
        //how will it be if str="(asd)asd(sdaw)"?
        return null;
    }


}

package com.sywood.starbucks.ben;

/**
 * Created by Striker on 2015-10-14.
 */
public class censor {
    public static String remove(String tot, String rem){
        if (tot.length() < rem.length()){
            return tot;
        }else {
            if (tot.substring(0, rem.length()).equals(rem)) {
                return remove(tot.substring(rem.length()), rem);
            }else{
                return tot.charAt(0) + remove(tot.substring(1), rem);
            }
        }
    }

    public static void main(String[] args){
        System.out.print(remove(remove("whatthemomooofun", "moo"), "moo"));
    }
}

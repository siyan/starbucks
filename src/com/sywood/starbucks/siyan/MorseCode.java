package com.sywood.starbucks.siyan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by siyan on 8/19/15.
 */
public class MorseCode {

    private Map<String,String> _codeChar = new HashMap<String,String>();
    private Map<String,String> _charCode = new HashMap<String,String>();

    public MorseCode() {

        for( int i = 0; i < CODES.length; i++ ) {
            _codeChar.put(CODES[i][1], CODES[i][0]);
            _charCode.put(CODES[i][1], CODES[i][0]);
        }
    }

    void traversal(int depth, String text, String strMessage) {

        for( int len = 1; len <= Math.min(4, strMessage.length()); len++ ) {

            String code = strMessage.substring(0, len);

            if(_codeChar.containsKey( code )) {

                System.out.println(depth + ": " + code + " ==> " + text + _codeChar.get(code));

                traversal(depth + 1, text + _codeChar.get(code), strMessage.substring(len));
            }
        }
    }

    public static void main(String[] args) {

        MorseCode mc = new MorseCode();
        mc.traversal(0, "", "-..-");
    }

    String[][] CODES = new String[][]{
        {"a", ".-"},
        {"b", "-..."},
        {"c", "-.-."},
        {"d", "-.."},
        {"e", "."},
        {"f", "..-."},
        {"g", "--."},
        {"h", "...."},
        {"i", ".."},
        {"j", ".---"},
        {"k", "-.-"},
        {"l", ".-.."},
        {"m", "--"},
        {"n", "-."},
        {"o", "---"},
        {"p", ".--."},
        {"q", "--.-"},
        {"r", ".-."},
        {"s", "..."},
        {"t", "-"},
        {"u", "..-"},
        {"v", "...-"},
        {"w", ".--"},
        {"x", "-..-"},
        {"y", "-.--"},
        {"z", "--.."},
    };
}

package com.sywood.starbucks.siyan;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by siyan on 8/19/15.
 */
public class MorseCode {

    private Map<String,String> _codeChar = new LinkedHashMap<String,String>();
    private Map<String,String> _charCode = new LinkedHashMap<String,String>();

    public MorseCode() {
        for( int i = 0; i < CODES.length; i++ ) {
            _codeChar.put(CODES[i][1], CODES[i][0]);
            _charCode.put(CODES[i][0], CODES[i][1]);
        }
    }

    private void a( String message ) {
        StringBuffer buf = new StringBuffer();
        for( char c : message.toCharArray() ) {
            buf.append( _charCode.get( String.valueOf(c) ));
        }

        System.out.println(buf.toString());

        // to finish, see b()

    }

    private void b(String chars, String codes, String morseCodes) {
        for( String code : _codeChar.keySet() ) {
            if( code.length() <= morseCodes.length() && code.equals(morseCodes.substring(0, code.length()))) {

                if( code.length() < morseCodes.length()) {
                    b(chars + _codeChar.get(code), codes + " " + code, morseCodes.substring(code.length()));
                }
                else {
                    System.out.println( codes + " " + code + " = " + chars + _codeChar.get(code));
                }
            }
        }
    }

    public static void main(String[] args) {
        MorseCode mc = new MorseCode();
        mc.a("hello");
        mc.b("", "", "-..--");
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

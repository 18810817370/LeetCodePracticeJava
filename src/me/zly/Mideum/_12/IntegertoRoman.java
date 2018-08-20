package me.zly.Mideum._12;

// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
//
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
// I can be placed before V (5) and X (10) to make 4 and 9.
// X can be placed before L (50) and C (100) to make 40 and 90.
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
// Example 1:
//        Input: 3
//        Output: "III"
//
// Example 2:
//        Input: 4
//        Output: "IV"
//
// Example 3:
//        Input: 9
//        Output: "IX"
//
// Example 4:
//        Input: 58
//        Output: "LVIII"
//        Explanation: C = 100, L = 50, XXX = 30 and III = 3.
//
// Example 5:
//        Input: 1994
//        Output: "MCMXCIV"
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegertoRoman {

    public String intToRoman(int num) {

        if (num < 1 || num > 3999) return "";

        StringBuffer stringBuffer = new StringBuffer();
        int value;

        value = num / 1000;
        num %= 1000;
        for (int i = 0; i < value; i ++) {
            stringBuffer.append('M');
        }

        value = num / 100;
        if (value == 4) {
            stringBuffer.append('C');
            stringBuffer.append('D');
            num -= 400;
        } else if (value == 9) {
            stringBuffer.append('C');
            stringBuffer.append('M');
            num -= 900;
        } else if (value > 4){
            num -= 500;
            stringBuffer.append('D');
        }

        value = num / 100;
        num %= 100;
        for (int i = 0; i < value; i ++) {
            stringBuffer.append('C');
        }

        value = num / 10;
        if (value == 4) {
            stringBuffer.append('X');
            stringBuffer.append('L');
            num -= 40;
        } else if (value == 9) {
            stringBuffer.append('X');
            stringBuffer.append('C');
            num -= 90;
        } else if (value > 4){
            stringBuffer.append('L');
            num -= 50;
        }

        value = num / 10;
        num %= 10;
        for (int i = 0; i < value; i ++) {
            stringBuffer.append('X');
        }

        if (num == 4) {
            stringBuffer.append('I');
            stringBuffer.append('V');
            num -= 4;
        } else if (num == 9) {
            stringBuffer.append('I');
            stringBuffer.append('X');
            num -=9;
        } else if (num > 4){
            stringBuffer.append('V');
            num -=5;
        }
        for (int i = 0; i < num; i ++) {
            stringBuffer.append('I');
        }

        return stringBuffer.toString();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new IntegertoRoman().intToRoman(num);

            String out = (ret);

            System.out.print(out);
        }
    }
}

package com.zb;

import java.math.BigDecimal;

public class test {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(1);
        BigDecimal num2 = new BigDecimal(2);

        num1 = num1.add(num2);
        System.out.println(num1);
    }
}

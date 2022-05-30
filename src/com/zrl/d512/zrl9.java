package com.zrl.d512;
public class zrl9
{
    public static void main(String[] args)
    {
        int i = 1, s = 0;
        do {
            s = s + i;
            i = i + 2;
        } while (i <= 100);
        System.out.printf("%d", s);
    }
}

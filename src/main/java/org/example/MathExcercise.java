package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathExcercise {
    public boolean isHappy(int n) {
        int temp = n;
        while(temp > 9){
            int sum = 0;
            while(temp >= 10) {
                sum += (temp%10 * temp%10);
                temp = temp/10;
            }
            temp = sum + (temp) * (temp);
        }
        return temp == 1 || temp == 7;
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        if(A[A.length-1] < 0){
            return 1;
        }
        for(int i = 1 ; i < A.length; i++) {
            if(A[i] != A[i-1] && A[i] != A[i-1]+1)
                return A[i-1]+1;
        }
        return A[A.length-1] +1;
    }

}

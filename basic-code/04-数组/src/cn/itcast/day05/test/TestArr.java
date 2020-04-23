package cn.itcast.day05.test;

import org.junit.Test;

public class TestArr {

    @Test
    public void testArry() {
        int[] arr1 = new int[]{1,2,3,4};
        int max=arr1[0];
        int min=arr1[0];
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>max){
                max=arr1[i];
            }
            if (arr1[i]<min){
                min=arr1[i];
            }
        }
        System.out.println(max);
        System.out.println(min);

        int temp=0;
        for (int i=0, j=arr1.length-1;i<j;i++,j--){
            temp=arr1[i];
            arr1[i]=arr1[j];
            arr1[j]=temp;
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

    }
}

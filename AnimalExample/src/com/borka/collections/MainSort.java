package com.borka.collections;

/**
 * Created by Comp14 on 05/09/2017.
 */
public class MainSort {

    public static void main(String[] args) {

        int[] numbers = {-2,55, -9, 4, 0,45, 92};

    //    sortArray(numbers);
        sortArray2(numbers);

    }
//        static void sortArray(int[] numbers)
//        {
//            int temp=0;
//            for (int i = 0; i < numbers.length; i++) {
//                for (int j = 0; j < numbers.length - 1; j++) {
//                    if (numbers[j + 1] > numbers[j]) {
//                        temp = numbers[j + 1];
//                        numbers[j + 1] = numbers[j];
//                        numbers[j] = temp;
//                    }
//                }
//            }
//            for (int i = 0; i < numbers.length; i++) {
//                System.out.println(numbers[i]);
//            }
//        }

    static void sortArray2(int[] numbers)
    {
        int temp=0;
        boolean isSwitched = true;
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println("\n");
      while (isSwitched) {
         isSwitched=false;
          for (int j = 0; j < numbers.length - 1; j++) {
              if (numbers[j + 1] > numbers[j]) {
                  temp = numbers[j];
                  numbers[j] = numbers[j++];
                  numbers[j++] = temp;
                  isSwitched = true;
              }
          }
      }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }


}
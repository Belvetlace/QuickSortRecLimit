import cs_1c.FHsort;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Foothill
{

   public static void main(String[] args)
   {
      final int[] ARRAY_SIZE = {20000, 50000, 100000, 150000};
              //200000, 500000, 1000000, 1500000};
      int randomInt, recLimit;
      ArrayList<Long>[] times = new ArrayList[ARRAY_SIZE.length];

      for (int i = 0; i < ARRAY_SIZE.length; i++)
      {
         System.out.println("\nArray size: " + ARRAY_SIZE[i]);
         times[i] = new ArrayList<>();
         Integer[] arrayOfInts = new Integer[ARRAY_SIZE[i]];
         for (int k = 0; k < ARRAY_SIZE[i]; k++)
         {
            randomInt = (int) (Math.random() * ARRAY_SIZE[i]);
            arrayOfInts[k] = randomInt;
         }
         for( recLimit = 2; recLimit <= 300; recLimit += 2)
            times[i].add(timeSort(recLimit, arrayOfInts.clone()));
      }


   }

   private static long timeSort(int recLimit,
                                    Integer[] array)
   {
      long startTime, stopTime, elapsedTime;
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);

      FHsort.setRecursionLimit(recLimit);

      startTime = System.nanoTime();  // ------------------ start
      FHsort.quickSort(array);
      stopTime = System.nanoTime();   // ------------------- stop
      elapsedTime = stopTime - startTime;
      System.out.println(String.format(
              "Elapsed Time: %8s seconds. Reclimit: %d",
              tidy.format( elapsedTime / 1e9), recLimit));
      return elapsedTime;
   }
}

/*
      Investigate all recursion limits from 2 to 300 in steps of 2: 2, 4, 6, 8

      Run them on different size arrays from 20,000 up to the largest you can
      get in your computer
      (you should be able to get it up to close to 1 million or more).

      Provide a table that summarizes the results
      - you don't have to show every recursion limit value
      - if there is no change in 10 consecutive values,
      pick one to represent that value.

      Comment on the results, describing the range that seems to be minimal
      (and flat)

 */
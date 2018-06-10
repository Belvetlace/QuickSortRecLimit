import cs_1c.FHsort;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Foothill
{
   private static ArrayList<Long>[] times;
   private final static int[] ARRAY_SIZE = {20000, 50000, 100000, 150000};
           //200000, 350000, 500000, 1000000, 1500000};

   public static void main(String[] args)
   {

      int randomInt, recLimit;
      times = new ArrayList[ARRAY_SIZE.length];

      for (int i = 0; i < ARRAY_SIZE.length; i++)
      {
         times[i] = new ArrayList<>();
         Integer[] arrayOfInts = new Integer[ARRAY_SIZE[i]];
         for (int k = 0; k < ARRAY_SIZE[i]; k++)
         {
            randomInt = (int) (Math.random() * ARRAY_SIZE[i]);
            arrayOfInts[k] = randomInt;
         }
         for( recLimit = 2; recLimit <= 300; recLimit += 2)
            times[i].add(timeSort(recLimit,
                    Arrays.copyOf(arrayOfInts, arrayOfInts.length)));
      }
      printTable();
   }

   private static void printTable()
   {
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      System.out.print(String.format("%-13s", "Array Size:"));
      for (int aARRAY_SIZE : ARRAY_SIZE)
      {
         System.out.print(String.format("  %,-10d", aARRAY_SIZE));
      }
      System.out.println();
      for (int recLimit = 2; recLimit <= 300; recLimit += 2)
      {
         System.out.print(String.format("RecLimit: %3d", recLimit));
         for (int i = 0; i < ARRAY_SIZE.length; i++)
         {
            System.out.print(String.format("  %-10s",
                    tidy.format(times[i].get(recLimit/2-1) / 1e9)));
         }
         System.out.println();
      }
   }

   private static long timeSort(int recLimit,
                                    Integer[] array)
   {
      long startTime, stopTime, elapsedTime;

      FHsort.setRecursionLimit(recLimit);

      startTime = System.nanoTime();  // ------------------ start
      FHsort.quickSort(array);
      stopTime = System.nanoTime();   // ------------------- stop
      elapsedTime = stopTime - startTime;

      return elapsedTime;
   }

   public static ArrayList<Long>[] getTimes()
   {
      return times;
   }
}

/*
Comment on the results, describing the range that seems to be minimal
(and flat)

Run-------------------------


 */
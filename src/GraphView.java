
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GraphView extends LineChart<Number, Number>
{
   private ArrayList<Long>[] times;
   private int[] ARRAY_SIZE;

   public GraphView(ArrayList<Long>[] times, int[] ARRAY_SIZE, String title)
   {
      super(new NumberAxis(), new NumberAxis());
      setTitle(title);
      this.times = times;
      this.ARRAY_SIZE = ARRAY_SIZE;
      final NumberAxis xAxis = (NumberAxis) getXAxis();
      final NumberAxis yAxis = (NumberAxis) getYAxis();
      xAxis.setForceZeroInRange(false);
      yAxis.setForceZeroInRange(false);
      xAxis.setLabel("RecLimit");
      yAxis.setLabel("Time");
      for(int i = 0; i <times.length; i++)
         update(i);
   }

   public void update(int p)
   {
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);

      Series<Number, Number> series = new Series<>();
      series.setName("Array of " + ARRAY_SIZE[p]);

      for( int i = 0, recLimit = 2; i < times[p].size(); i++, recLimit += 2)
      {
         series.getData().add(new Data<>(recLimit,
                 times[p].get(i) / 1e9)); //tidy.format( elapsedTime / 1e9)
      }

      this.getData().add(series);

   }

   public void clear()
   {
      this.getData().clear();
   }

}

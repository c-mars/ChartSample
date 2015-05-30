package c.mars.chartsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;

public class MainActivity extends AppCompatActivity {

    static void buildChart(ColumnChartView chart, List<Float> in) {
        int numSubcolumns = 1;
        int numColumns = 7;

        List<Column> columns = new ArrayList<>();
        List<SubcolumnValue> values;
        String days[] = {"M", "T", "W", "T", "F", "S", "S"};
        for (int i = 0; i < numColumns; ++i) {

            values = new ArrayList<>();
            for (int j = 0; j < numSubcolumns; ++j) {
                SubcolumnValue sc = new SubcolumnValue(in.get(i), Color.parseColor("#8AC451"));
                values.add(sc);
            }

            Column column = new Column(values);
            column.setHasLabels(false);
            column.setHasLabelsOnlyForSelected(false);
            columns.add(column);
        }

        ColumnChartData data = new ColumnChartData(columns);

        Float[] vs = {0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
        List<Float> valL = Arrays.asList(vs);
        List<String> daysL = Arrays.asList(days);
        Axis axisX = Axis.generateAxisFromCollection(valL, daysL);// new Axis();

        Axis axisY = new Axis().setHasLines(true);

        axisY.setName("kW");

        data.setAxisXTop(axisX);
        data.setAxisYLeft(axisY);
        chart.setColumnChartData(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColumnChartView chart = (ColumnChartView) findViewById(R.id.chart);

        Float[] usg={250f, 130f, 100f, 160f, 110f, 140f, 80f};
        List<Float> in = Arrays.asList(usg);
        buildChart(chart, in);
    }
}

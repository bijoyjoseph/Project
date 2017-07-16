package com.finance;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.finance.notimportant.DemoBase;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends DemoBase implements OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChart1;
    private PieChart mChart2;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;
    private String[] productIllustrationTypes = {"Child advantage", "Samridhi", "Elite advantage", "Aajeevan sampatti+",
            "Triple health insurance", "Flexi save", "Monthly income plan", "Super series"};
    private float[] perc1 = {5, 55, 7.5f, 2, 0.5f, 10, 9, 11};
    private float[] perc2 = {2, 58, 7f, 2.5f, 0.5f, 11, 9, 10};

//    private Typeface tf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_piechart);

        tvX = (TextView) findViewById(R.id.tvXMax);
        tvY = (TextView) findViewById(R.id.tvYMax);

        mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
        mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);

        mSeekBarY.setProgress(10);

        mSeekBarX.setOnSeekBarChangeListener(this);
        mSeekBarY.setOnSeekBarChangeListener(this);

        mChart1 = (PieChart) findViewById(R.id.chart1);
        mChart2 = (PieChart) findViewById(R.id.chart2);
        mChart1.setUsePercentValues(true);
        mChart2.setUsePercentValues(true);
        mChart1.setDescription("");
        mChart2.setDescription("");
        mChart1.setExtraOffsets(5, 10, 5, 5);
        mChart2.setExtraOffsets(5, 10, 5, 5);

        mChart1.setDragDecelerationFrictionCoef(0.95f);
        mChart2.setDragDecelerationFrictionCoef(0.95f);

        mChart1.setCenterText(generateCenterSpannableText());
        mChart2.setCenterText(generateCenterSpannableText());

        mChart1.setDrawHoleEnabled(true);
        mChart2.setDrawHoleEnabled(true);
        mChart1.setHoleColor(Color.WHITE);
        mChart2.setHoleColor(Color.WHITE);

        mChart1.setTransparentCircleColor(Color.WHITE);
        mChart2.setTransparentCircleColor(Color.WHITE);
        mChart1.setTransparentCircleAlpha(110);
        mChart2.setTransparentCircleAlpha(110);

        mChart1.setHoleRadius(30f);
        mChart1.setTransparentCircleRadius(61f);
        mChart2.setHoleRadius(30f);
        mChart2.setTransparentCircleRadius(61f);

        mChart1.setDrawCenterText(true);
        mChart2.setDrawCenterText(true);

        mChart1.setRotationAngle(0);
        mChart2.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart1.setRotationEnabled(true);
        mChart2.setRotationEnabled(true);
        mChart2.setHighlightPerTapEnabled(true);

        // mChart1.setUnit(" €");
        // mChart1.setDrawUnitsInChart(true);

        // add a selection listener
        mChart1.setOnChartValueSelectedListener(this);
        mChart2.setOnChartValueSelectedListener(this);

        setData(3, 100);

        mChart1.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mChart2.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart1.spin(2000, 0, 360);

   /*     Legend l = mChart1.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);*/
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvX.setText("" + (mSeekBarX.getProgress() + 1));
        tvY.setText("" + (mSeekBarY.getProgress()));

        setData(mSeekBarX.getProgress(), mSeekBarY.getProgress());
    }

    private void setData(int count, float range) {

        float mult = productIllustrationTypes.length - 1;
        count = productIllustrationTypes.length - 1;

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.

//        Data values
        for (int i = 0; i < count + 1; i++) {
            yVals1.add(new Entry(perc1[i], i));
        }
        for (int i = 0; i < count + 1; i++) {
            yVals2.add(new Entry(perc2[i], i));
        }

        ArrayList<String> xVals = new ArrayList<String>();
//party name

        for (int i = 0; i < count + 1; i++)
            xVals.add(productIllustrationTypes[i]);

        PieDataSet dataSet = new PieDataSet(yVals1, "Election Results");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        PieDataSet dataSet1 = new PieDataSet(yVals2, "Election Results");
        dataSet1.setSliceSpace(3f);
        dataSet1.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        dataSet1.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        PieData data1 = new PieData(xVals, dataSet1);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
//        data.setValueTypeface(tf);
        mChart1.setData(data);
        mChart2.setData(data1);

        // undo all highlights
        mChart1.highlightValues(null);
        mChart2.highlightValues(null);

        mChart1.invalidate();
        mChart2.invalidate();
    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("PieChart\n");
      /*  s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);*/
        return s;
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }
}

package com.pfoa.csvparser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;

import com.pfoa.csvparser.dto.ExpenseDto;

public class BarChart extends JFrame {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void drawChart(List<ExpenseDto> expenseList) throws IOException {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(ExpenseDto dto : expenseList) {
			int totalPerMonth = dto.getGroceries()+dto.getLiability()+dto.getUtilityBill();
			int savings = dto.getCredit() - totalPerMonth;
			dataset.setValue(dto.getCredit(), "Credit", dto.getMonth());
			dataset.setValue(totalPerMonth, "Debit", dto.getMonth());
			dataset.setValue(savings, "Savings", dto.getMonth());
		}
		JFreeChart barChart = ChartFactory.createBarChart(
		        "Monthly Expense Hof",
		        "",
		        "Money (EUR)",
		        dataset,
		        PlotOrientation.VERTICAL,
		        true, true, true);
		CategoryItemRenderer renderer = ((CategoryPlot)barChart.getPlot()).getRenderer();

        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);
		ChartPanel chartPanel = new ChartPanel(barChart);
       // default size
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       // add it to our application
       // default size
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       // add it to our application
       setContentPane(chartPanel);
       barChart.setBorderVisible(true);
       int width = 800;    /* Width of the image */
       int height = 800;   /* Height of the image */ 
       File BarChart = new File( "BarChart.jpeg" ); 
       ChartUtils.saveChartAsJPEG( BarChart , barChart , width , height );
	}
}

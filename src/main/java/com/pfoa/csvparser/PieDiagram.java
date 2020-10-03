package com.pfoa.csvparser;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.pfoa.csvparser.dto.ExpenseDto;

public class PieDiagram extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void drawChart(List<ExpenseDto> expenseList) throws IOException {

		DefaultPieDataset dataset = new DefaultPieDataset();
		int creditTotal = 0;
		int grocerriesTotal = 0;
		int liabilitiesTotal = 0;
		int utilitiesTotal = 0;
		int debitTotal = 0;
		for(ExpenseDto dto : expenseList) {
			creditTotal += dto.getCredit();
			grocerriesTotal += dto.getGroceries();	
			liabilitiesTotal += dto.getLiability();			
			utilitiesTotal += dto.getUtilityBill();			
		}
		debitTotal = grocerriesTotal + liabilitiesTotal + utilitiesTotal;
		int savingsTotal = creditTotal - debitTotal;
		dataset.setValue("Credit = " + creditTotal, creditTotal);
		dataset.setValue("GrocerriesTotal = " + grocerriesTotal, grocerriesTotal);
//		dataset.setValue("DebitTotal = " + debitTotal, debitTotal);
		dataset.setValue("LiabilitiesTotal = " + liabilitiesTotal, liabilitiesTotal);
		dataset.setValue("UtilitiesTotal = " + utilitiesTotal, utilitiesTotal);
		//dataset.setValue("Savings = " + savingsTotal, savingsTotal);
		JFreeChart chart = ChartFactory.createPieChart("Total Expenditure in categories",
	                dataset, true, true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
       // default size
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       // add it to our application
       // default size
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       // add it to our application
       setContentPane(chartPanel);
       chart.setBorderVisible(true);
       int width = 600;    /* Width of the image */
       int height = 600;   /* Height of the image */ 
       File BarChart = new File( "PieChartInCategories.jpeg" ); 
       ChartUtils.saveChartAsJPEG( BarChart , chart , width , height );
	}

}

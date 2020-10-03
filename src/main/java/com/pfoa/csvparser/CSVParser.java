package com.pfoa.csvparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.pfoa.csvparser.dto.ExpenseDto;

public class CSVParser extends JFrame{
	
	public static void main(String args[]) throws IOException {
		String filePath = "C:\\Users\\user\\Desktop\\PART TIME JOB-HUNT\\learning\\expense.csv";
		BarChart barChart = new BarChart();
		PieDiagram pieDiagram = new PieDiagram();
		List<ExpenseDto> expenseList = readCsv(filePath);
		SwingUtilities.invokeLater(() -> {
			barChart.setSize(800, 400);
			barChart.setLocationRelativeTo(null);
			barChart.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			barChart.setVisible(true);
		    });
		barChart.drawChart(expenseList);
		SwingUtilities.invokeLater(() -> {
			pieDiagram.setSize(800, 400);
			pieDiagram.setLocationRelativeTo(null);
			pieDiagram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			pieDiagram.setVisible(true);
		    });
		pieDiagram.drawChart(expenseList);
	}
	
	static List<ExpenseDto> readCsv(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		int rowCount = 1;
		List<ExpenseDto> expenseList = new ArrayList<>();
		while((line = br.readLine()) != null) {
			if(rowCount == 1) {
				rowCount++;
				continue;
			}
			String[] contents = line.split(";");
			ExpenseDto expenseDto = new ExpenseDto(contents[0], 
					Integer.parseInt(contents[1]), Integer.parseInt(contents[2]), 
					Integer.parseInt(contents[3]), Integer.parseInt(contents[4]));
			expenseList.add(expenseDto);
			//System.out.println("name " + contents[0]);
		}
		br.close();
		return expenseList;		
	}


}


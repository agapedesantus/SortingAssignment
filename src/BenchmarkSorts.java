import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class BenchmarkSorts {

  public static void main(String[] args) {
		
		int[] n = {1000, 2000, 3000, 4000, 5000, 6000, 7000,
				8000, 9000, 10000, 15000, 20000, 25000 };
		
		long start, duration;
		// TODO change SOP to PrintWriter
		
		ArrayList<SortsCVS> result = new ArrayList<>();
		
		for (int i = 0; i < n.length; i++) {
			int [] list = buildArray(n[i]);
			int[] list2 = Arrays.copyOf(list, list.length);

			start = System.currentTimeMillis();
			InsertionSort.insertionSort(list2);
			duration = System.currentTimeMillis() - start;
			System.out.println("InsertionSort,"+ n[i] + "," + duration);
			result.add(new SortsCVS("InsertionSort", n[i], duration));
			
			
			start = System.currentTimeMillis();
			BubbleSort.bubbleSort(list2);
			duration = System.currentTimeMillis() - start;
			System.out.println("BubbleSort,"+ n[i] + "," + duration);
			result.add(new SortsCVS("BubbleSort", n[i], duration));
			
			start = System.currentTimeMillis();
			MergeSort.mergeSort(list2);
			duration = System.currentTimeMillis() - start;
			System.out.println("MergeSort,"+ n[i] + "," + duration);
			result.add(new SortsCVS("MergeSort", n[i], duration));
			
			start = System.currentTimeMillis();
			SelectionSort.selectionSort(list2);
			duration = System.currentTimeMillis() - start;
			System.out.println("SelectionSort,"+ n[i] + "," + duration);
			result.add(new SortsCVS("SelectionSort", n[i], duration));
			
			int[] list3 = Arrays.copyOf(list, list.length);
			try {				
				start = System.currentTimeMillis();
				QuickSort.quickSort(list3);
				duration = System.currentTimeMillis() - start;
				System.out.println("quickSort,"+ n[i] + "," + duration);
				result.add(new SortsCVS("quickSort", n[i], duration));
				System.out.println();
				
			} catch (Exception soe) {
				System.out.println("quickSort,"+ n[i] + "," + "overflow");
			}
		}	
	}
	
  	private static void WriteToFile(ArrayList<SortsCVS> scvs) {
  		try {
  			FileWriter fileWriter = new FileWriter("src\\data\\Benchmark.csv");
  				
  			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
  			PrintWriter printWriter = new PrintWriter(bufferedWriter);
 
  			for(SortsCVS s : scvs) {
				printWriter.println(s.getName() + "," + s.getIndex() + "," + s.getDuration());
			}
  			printWriter.flush();
  			printWriter.close();
  			
  			JOptionPane.showMessageDialog(null,"Record Saved");
  		} catch (IOException e) {
  			JOptionPane.showMessageDialog(null,"Record not Saved");  		}
  	}
  
	private static int[] buildArray(int n) {
		Random rand = new Random();
		int[] i = new int[n];
		for(int j = 0; j < n; j++) {
            i[j] = rand.nextInt(n);			
		}
		return i;
	}
}
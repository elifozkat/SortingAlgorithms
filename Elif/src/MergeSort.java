import java.io.IOException;
import java.util.ArrayList;

public class MergeSort {

	
	public static void mergeSort(ArrayList<String[]> a, int leftIndex, int rightIndex,
			int column) throws IOException {
		int equal = (leftIndex + rightIndex) / 2;

		if (rightIndex == leftIndex)
			return;
		mergeSort(a, leftIndex, equal, column);
		mergeSort(a, equal + 1, rightIndex, column);
		merge(a, leftIndex, equal, rightIndex, column);
		Main.counter++;
		Main.printer.println("Step "+Main.counter);
		
		for(int i=0; i<a.size() ; i++){
			for(int j=0; j<7; j++){
				if(j==6){
					Main.printer.print(a.get(i)[j]);
				}else
				Main.printer.print(a.get(i)[j]+",");
			}
			Main.printer.println();
		}
	}

	public static void merge(ArrayList<String[]> a, int l, int e, int r, int column) {
		if (a.get(e)[column].compareToIgnoreCase(a.get(e + 1)[column]) < 0) // ben
																			// buldum
																			// ;))
			return;
		while (l <= e && e + 1 <= r) {
			if (a.get(l)[column].compareToIgnoreCase(a.get(e + 1)[column]) <= 0)
				l++;
			else if (a.get(l)[column].compareToIgnoreCase(a.get(e + 1)[column]) > 0) {
				String[] tmp = a.get(e + 1);
				for (int i = e; l <= i; i--) {
					a.set(i + 1, a.get(i));
				}
				a.set(l, tmp);
				l++;
				e++;

			}

		}

	}

}

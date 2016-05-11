import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static File output = new File("output.txt");
	static PrintWriter printer;
	static int counter=0;
	
	public static void main(String[] args) throws IOException {
		printer = new PrintWriter(output);
		File input = new File("currentEmployees.csv");
		File input2 = new File("instructions.txt");

		Scanner sc = new Scanner(input);

		Scanner sc2 = new Scanner(input2);

		ArrayList<String[]> arLst = new ArrayList<>();

		while (sc.hasNextLine()) {
			String word = sc.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(word, ",");
			String[] a = new String[7];
			while (tokenizer.hasMoreTokens()) {
				for (int i = 0; i < 7; i++) {
					a[i] = tokenizer.nextToken();
				}

			}
			arLst.add(a);
		}

		while (sc2.hasNextLine()) {
			String l = sc2.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(l, " ");
			ArrayList<String> a = new ArrayList<>();
			while (tokenizer.hasMoreTokens()) {
				a.add(tokenizer.nextToken());
			}
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(a.size() - 1).equalsIgnoreCase("mergesort")) {
					MergeSort.mergeSort(arLst, 0, arLst.size() - 1,
							Integer.parseInt(a.get(i)) - 1);
				}
				if (a.get(a.size() - 1).equalsIgnoreCase("quicksort"))
					QuickSort.quickSort(arLst, 0, arLst.size() - 1,
							Integer.parseInt(a.get(i)) - 1);
			}
		}
		printer.close();

		// MergeSort.mergeSort(arLst, 0, arLst.size()-1, 0);
		// QuickSort.quickSort(arLst, 0, arLst.size()-1, 0);
	}

}

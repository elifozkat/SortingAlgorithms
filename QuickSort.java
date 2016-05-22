import java.io.IOException;
import java.util.ArrayList;


public class QuickSort {

	public static void quickSort(ArrayList<String[]> a, int leftIndex, int rightIndex,int column) throws IOException{
		
		
		if(rightIndex<=leftIndex)
			return;
		int p = modify(a, leftIndex, rightIndex, column);
		quickSort(a, leftIndex, p-1, column);
		quickSort(a, p+1, rightIndex, column);
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
	
	public static int modify(ArrayList<String[]> a, int leftIndex, int rightIndex, int column){
		int i=leftIndex;
		int j=rightIndex;
		String[] temp;
		String pivot = a.get((leftIndex+rightIndex)/2)[column];
		
		while(i!=j){
			while (a.get(i)[column].compareToIgnoreCase(pivot)<0 && i!=j)
				i++;
			while(a.get(j)[column].compareToIgnoreCase(pivot)>0 && i!=j)
			j--;
			
				temp= a.get(i);
				a.set(i, a.get(j));
				a.set(j, temp);
				//j--;
				//i++;
				
		}
		
		
		return i;
	}
	
	
	
}

package test;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Proximity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the proximity value: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the array of comma separated strings:");
		String line = sc.nextLine();
		
		String[] array = line.split(",");
		Arrays.sort(array);
		if(n>array.length) {
			n=array.length-1;
		}
		List<String> inorderList = Arrays.asList(array);
		int last = array.length-1;
		for(String obj : array){
			int indexa = inorderList.indexOf(obj) +1;
			int indexb = indexa-2;
			
			System.out.print("Closest "+n+" for "+obj+" : ");
			for(int i=0; i < n; i++){
				String vala = array[last];
				String valb = array[0];
				
				if(indexa<array.length){
					vala = inorderList.get(indexa);
				} else {
					System.out.print(inorderList.get(indexb)+", ");
					indexb--;
					continue;
				}
				if(indexb>-1){
					valb = inorderList.get(indexb);
				} else {
					System.out.print(inorderList.get(indexa)+", ");
					indexa++;
					continue;
				}
				int diffa = Math.abs(obj.compareTo(vala));
				int diffb = Math.abs(obj.compareTo(valb));
				
				if(diffa < diffb){
					System.out.print(inorderList.get(indexa)+", ");
					indexa++;
				} else {
					System.out.print(inorderList.get(indexb)+", ");
					indexb--;
				}
			}
			System.out.println();
		}
	}
	
	
}

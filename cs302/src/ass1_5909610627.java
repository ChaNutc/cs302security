import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ass1_5909610627 {
	private Scanner sc;
	private ArrayList<ArrayList<String>> w;
	public ass1_5909610627() {
		w = new ArrayList<>();
		sc = new Scanner(System.in);
		System.out.print("Enter Input Key:");
		String key = "Thats my Kung Fu";//sc.nextLine();
		String text = "54 68 61 74 73 20 6D 79 20 4B 75 6E 67 20 46 75";
		System.out.println("Key in Hex: "+text);
		//for(int i=0;i<key.length();i++) {
			//System.out.println(key.getBytes());
		String a = Arrays.toString(key.getBytes());
			System.out.println(Arrays.toString(key.getBytes()));
		//}
		String test1 = a.replace("[", "");
		String test2 = test1.replace("]", "");
		test2 = test2.replaceAll(" ", "");
		String[] temp = test2.split(",");
		for(int i=0;i<temp.length;i++) {
			System.out.print(Integer.toHexString(Integer.parseInt(temp[i]))+" ");
		}
		System.out.println();
		//System.out.println(temp.length);
		ArrayList<String> wi = new ArrayList<>();
		for(int i =0;i<4;i++) {
			wi.clear();
			for(int j =0;j<4;j++) {
				//System.out.println(j+(i*4));
				//System.out.println(Integer.toHexString(Integer.parseInt(temp[j+(i*4)])));
				wi.add(Integer.toHexString(Integer.parseInt(temp[j+(i*4)])));
			}
			w.add(wi);
		}
		System.out.println(w.size());
	}
	
	public static void main(String[] args) {
		new ass1_5909610627();
	}
}

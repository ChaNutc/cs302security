import java.util.Scanner;

public class ass1_5909610627 {
	private Scanner sc;
	public ass1_5909610627() {
		sc = new Scanner(System.in);
		System.out.print("Enter Input Key:");
		String key = sc.nextLine();
		String text = "54 68 61 74 73 20 6D 79 20 4B 75 6E 67 20 46 75";
		System.out.println("Key in Hex: "+text);
		
		
	}
	public static void main(String[] args) {
		new ass1_5909610627();
	}
}

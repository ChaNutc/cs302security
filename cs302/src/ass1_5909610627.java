import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.DMUL;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ass1_5909610627 {
	private Scanner sc;
	private String[] rcon = {"01","02","04","08","10","20","40","80","1b","36"};;
	private ArrayList<ArrayList<String>> w;
	private ArrayList<String> sBox;
	public ass1_5909610627() {
		sBox = new ArrayList<>();
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
			wi = new ArrayList<>();
			for(int j =0;j<4;j++) {
				wi.add(Integer.toHexString(Integer.parseInt(temp[j+(i*4)])));
				//System.out.println(wi);
			}
			w.add(wi);
			/*for(int j=0;j<4;j++) {
				System.out.print(w.get(i).get(j)+" ");
			}System.out.println();*/
		}
		/*ArrayList<String> t1 = new ArrayList<>();
		ArrayList<String> t2 = new ArrayList<>();
		ArrayList<String> t3 = new ArrayList<>();
		ArrayList<String> t4 = new ArrayList<>();
		for(int i=0;i<4;i++) {
			t1.add(wi.get(i));
		}w.add(t1);

		for(int i=4;i<8;i++) {
			t2.add(wi.get(i));
		}w.add(t2);

		for(int i=8;i<12;i++) {
			t3.add(wi.get(i));
		}w.add(t3);

		for(int i=12;i<16;i++) {
			t4.add(wi.get(i));
		}w.add(t4);*/

		//System.out.println(w);
		//System.out.println(w);
		/*for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(w.get(i).get(j)+" ");
			}System.out.println();
		}*/
		for(int i=0;i<10;i++) {
			findnew();
			next();
			//System.out.println(w);
			/*System.out.println(w.get(w.size()-1).get(0));
			System.out.println(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0)))));
			System.out.println(w.get(w.size()-1).get(1));
			System.out.println(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(1)))));
			System.out.println(w.get(w.size()-1).get(2));
			System.out.println(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(2)))));
			System.out.println(w.get(w.size()-1).get(3));
			System.out.println(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(3)))));*/
			
		}
		/*System.out.println();
		for(int i=0;i<w.size();i++) {
			if(i%4==0) {
				if(i==0) {
					System.out.print("k"+i/4+"\t");
				}else{
					System.out.println();
					System.out.print("k"+i/4+"\t");
				}
				
			}
			System.out.print(w.get(i));
			
		}*/
		//System.out.println(w);
	}
	public void next() {
		ArrayList<String> wn = new ArrayList<>();
		String text="";
		for(int j=0;j<3;j++) {
			for(int i=0;i<4;i++) {
				text = xor(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-1).get(i),16))), fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-5).get(i),16))));
				wn.add(fullHex(Integer.toHexString(Integer.parseInt(text,2))));
			}
			w.add(wn);
			wn = new ArrayList<>();
			text="";
		}
	}
	public void findnew() {
		if(w.size()%4==0) {
			ArrayList<String> rot = new ArrayList<>();
			String rottemp="";
			//System.out.println(w.get(w.size()-1));
			for(int i=0;i<w.get(w.size()-1).size();i++) {
				if(i==0) {
					rottemp = w.get(w.size()-1).get(i);
				}else {
					rot.add(w.get(w.size()-1).get(i));
				}
				
			}
			rot.add(rottemp);
			//System.out.println();
			//w.get(w.size()-1)
			//System.out.println(w.get(w.size()-1));
			//w.get(w.size()-4);
			Sbox s = new Sbox();
			//System.out.println(rot);
			for(int i =0;i<4;i++) {
				//System.out.println(Integer.parseInt(rot.get(i).charAt(0)+"", 16)+" "+Integer.parseInt(rot.get(i).charAt(1)+"", 16));
				//System.out.println(s.getSbox(Integer.parseInt(rot.get(i).charAt(0)+"", 16),Integer.parseInt(rot.get(i).charAt(1)+"", 16)));
				//System.out.println(Integer.toHexString(s.getSbox(Integer.parseInt(rot.get(i).charAt(0)+"", 16),Integer.parseInt(rot.get(i).charAt(1)+"", 16))));
				//System.out.println();
				//System.out.println(rot.get(i));
				rot.add(Integer.toHexString(s.getSbox(Integer.parseInt(rot.get(i).charAt(0)+"", 16),Integer.parseInt(rot.get(i).charAt(1)+"", 16))));
			}
			for(int i=0;i<4;i++) {
				rot.remove(0);
			}
			String brcon="";
			//Integer.toBinaryString(Integer.parseInt(rcon[w.size()/4-1], 16));
			for(int i=0;i<8-Integer.toBinaryString(Integer.parseInt(rcon[w.size()/4-1], 16)).length();i++) {
				brcon+="0";
			}
			brcon+=Integer.toBinaryString(Integer.parseInt(rcon[w.size()/4-1], 16));
			//System.out.println(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0), 16)));
			String brot="";
			for(int i=0;i<8-Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0), 16)).length();i++) {
				brot+="0";
			}
			brot+=Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0), 16));
			/*String xor="";
			for(int i=0;i<8;i++) {
				if((brcon.charAt(i)+"").equals(brot.charAt(0)+"")) {
					xor+="0";
				}else {
					xor+="1";
				}
			}*/
			rot.set(0,xor(brcon,brot));
			rot.set(1,fullBinary(Integer.toBinaryString(Integer.parseInt(rot.get(1),16))));
			rot.set(2,fullBinary(Integer.toBinaryString(Integer.parseInt(rot.get(2),16))));
			rot.set(3,fullBinary(Integer.toBinaryString(Integer.parseInt(rot.get(3),16))));
			/*for(int i=0;i<rot.size();i++) {
				System.out.println(rot.get(i));
			}*/
			ArrayList<String> w4 = new ArrayList<>();
			String text = null;
			//System.out.println(rot);
			//System.out.println(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0)))));
			for(int i=0;i<4;i++) {
				text = xor(rot.get(i), fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(i),16))));
				//System.out.println(text);
				w4.add(fullHex(Integer.toHexString(Integer.parseInt(text,2))));
			}//System.out.println(w4);
			w.add(w4);
			//System.out.println(w);
			w4= new ArrayList<>();
			//System.out.println(w);
			/*System.out.println(w.get(0));
			System.out.println(w.get(w.size()-4).get(0));
			System.out.println(rot.get(0));
			System.out.println(fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0)))));
			System.out.println(xor(rot.get(0), fullBinary(Integer.toBinaryString(Integer.parseInt(w.get(w.size()-4).get(0))))));*/
			rot = new ArrayList<>();
		}
	}
	public String xor(String a,String b) {
		String xor="";
		System.out.println(Integer.toHexString(Integer.parseInt(a,2)));
		System.out.println(a);
		System.out.println(Integer.toHexString(Integer.parseInt(b,2)));
		System.out.println(b);
		
		for(int i=0;i<8;i++) {
			if((a.charAt(i)+"").equals(b.charAt(i)+"")) {
				xor+="0";
			}else {
				xor+="1";
			}
		}
		System.out.println(xor);
		System.out.println();
		return xor;
	}
	public String fullBinary(String a) {
		String bi="";
		for(int i=0;i<8-a.length();i++) {
			bi+="0";
		}
		bi+=a;
		return bi;
	}public String fullHex(String a) {
		String he ="";
		for(int i=0;i<2-a.length();i++) {
			he+="0";
		}
		he+=a;
		return he;
	}
	
	
	public static void main(String[] args) {
		new ass1_5909610627();
	}
}

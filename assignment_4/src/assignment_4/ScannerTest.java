package assignment_4;
import java.io.*;
import java.util.*;
public class ScannerTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = "300 -10 9000000000000 3570 26.5 5.999 true 300356:Hello:World:";
		File f = new File("C:\\Users\\dan80\\Downloads\\Currency.txt");
		InputStream str = new FileInputStream("C:\\Users\\dan80\\Downloads\\Currency.txt");
		MyScanner stream = new MyScanner(str);
		MyScanner input = new MyScanner(s);
		MyScanner fileinput = new MyScanner(f);
		
		while(input.hasNext()) {
			if(input.hasNextInt()) {
				System.out.println("Integer found: "+input.nextInt());
				break;
			}
		}
		
		while(input.hasNext()) {
			if(input.hasNextByte()) {
				System.out.println("Byte found: "+input.nextByte());
				break;
			}
		}
		
		while(input.hasNext()) {
			if(input.hasNextLong()) {
				System.out.println("Long found: "+input.nextLong());
				break;
			}
		}
		
		while(input.hasNext()) {
			if(input.hasNextShort()) {
				System.out.println("Short found: "+input.nextShort());
				break;
			}
		}
		
		while(input.hasNext()) {
			if(input.hasNextDouble()) {
				System.out.println("Double found: "+input.nextDouble());
				break;
			}
		}
		
		while(input.hasNext()) {
			if(input.hasNextFloat()) {
				System.out.println("Float found: "+input.nextFloat());
				break;
			}
		}
		
		while(input.hasNext()) {
			if(input.hasNextBoolean()) {
				System.out.println("Boolean found: "+input.nextBoolean());
				break;
			}
		}
		System.out.println("Delimiter--------");
		input.useDelimeter(":");
		System.out.println("-------------");
		
		
		while(input.hasNext()) {
			System.out.println(input.next());
		}
		
		System.out.println(fileinput.nextLine());
		System.out.println(fileinput.nextLine());
		System.out.println(fileinput.nextLine());
		System.out.println(fileinput.nextLine());
		str.read();
		//unsure how to test the input stream
		//while(stream.hasNext()) {
		//	System.out.println(str.read());
		//}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

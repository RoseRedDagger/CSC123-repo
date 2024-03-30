package assignment_4;
import java.io.*;
import java.util.*;

public class MyScanner {
	private String tokens[];
	private int index;
	FileInputStream fis;
	
	public MyScanner(InputStream source) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(source));
	}
	
	public MyScanner(File f) throws Exception {
		fis=new FileInputStream(f);
		
    }
	
	public String nextLine() throws Exception {
		
		int i;
		String s="";
		
		while((i=fis.read())!=-1) {
			if(i=='\n') {
				return s;
			}
			s+=(char)i;
        }
		
		return null;
		
	}

	public MyScanner(String string) {
	if (string != null && !string.equals("")) {
	tokens = string.trim().split("\\s+");
	} 
	else {
	// otherwise, initializing tokens as an empty array
	tokens = new String[0];
	}
	index = 0; 
	}

	public boolean hasNext() {
	return index < tokens.length;
	}


	public String next() {
	if (!hasNext()) {
	throw new NoSuchElementException();
	}

	// fetching element and updating index, returning element

	String element = tokens[index];

	index++;

	return element;

	}

	public boolean hasNextInt() {
	if (!hasNext()) {
	// no more tokens
	return false;
	}
	// trying to parse current token as integer
	try {
	int n = Integer.parseInt(tokens[index]);
	// if parsing is successful, returning true
	return true;
	} catch (Exception e) {

	}
	// else, returning false
	return false;
	}

	public int nextInt() {

	if (!hasNext()) {
	// no more tokens
	throw new NoSuchElementException();
	}
	if (!hasNextInt()) {
	// next token exist, but not in integer form
	throw new InputMismatchException();
	}
	// otherwise parsing as integer and returning it
	int number = Integer.parseInt(tokens[index]);
	index++;
	return number;
	}
	
	public boolean hasNextDouble() {
		if (!hasNext()) {
		// no more tokens
		return false;
		}
		// trying to parse current token as Double
		try {
		double d = Double.parseDouble(tokens[index]);
		// if parsing is successful, returning true
		return true;
		} catch (Exception e) {

		}
		// else, returning false
		return false;
		}
	
	public double nextDouble() {
		if (!hasNext()) {
		// no more tokens
		throw new NoSuchElementException();
		}
		if (!hasNextDouble()) {
		// next token exist, but not in Double form
		throw new InputMismatchException();
		}
		// otherwise parsing as Double and returning it
		double dob = Double.parseDouble(tokens[index]);
		index++;
		return dob;
		}
	//same process as hasNextInt & nextInt for the rest
	public boolean hasNextLong() {
		if (!hasNext()) {
		return false;
		}
		try {
		long d = Long.parseLong(tokens[index]);
		return true;
		} catch (Exception e) {

		}
		return false;
		}
	
	public long nextLong() {
		if (!hasNext()) {
		throw new NoSuchElementException();
		}
		if (!hasNextLong()) {
		throw new InputMismatchException();
		}
		long lon = Long.parseLong(tokens[index]);
		index++;
		return lon;
		}
	
	public boolean hasNextFloat() {
		if (!hasNext()) {
		return false;
		}
		try {
		float dd = Float.parseFloat(tokens[index]);
		return true;
		} catch (Exception e) {

		}
		return false;
		}
	
	public float nextFloat() {
		if (!hasNext()) {
		throw new NoSuchElementException();
		}
		if (!hasNextFloat()) {
		throw new InputMismatchException();
		}
		float flo = Float.parseFloat(tokens[index]);
		index++;
		return flo;
		}
	
	public boolean hasNextShort() {
		if (!hasNext()) {
		return false;
		}
		try {
		short ss = Short.parseShort(tokens[index]);
		return true;
		} catch (Exception e) {

		}
		return false;
		}
	
	public short nextShort() {
		if (!hasNext()) {
		throw new NoSuchElementException();
		}
		if (!hasNextShort()) {
		throw new InputMismatchException();
		}
		short sho = Short.parseShort(tokens[index]);
		index++;
		return sho;
		}
	
	public boolean hasNextByte() {
		if (!hasNext()) {
		return false;
		}
		try {
		byte by = Byte.parseByte(tokens[index]);
		return true;
		} catch (Exception e) {

		}
		return false;
		}
	
	public byte nextByte() {
		if (!hasNext()) {
		throw new NoSuchElementException();
		}
		if (!hasNextByte()) {
		throw new InputMismatchException();
		}
		byte bo = Byte.parseByte(tokens[index]);
		index++;
		return bo;
		}
	
	public boolean hasNextBoolean() {
		if (!hasNext()) {
		return false;
		}
		try {
		boolean bi = Boolean.parseBoolean(tokens[index]);
		return true;
		} catch (Exception e) {

		}
		return false;
		}
	
	public boolean nextBoolean() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (!hasNextBoolean()) {
			throw new InputMismatchException();
			}
		boolean boo = Boolean.parseBoolean(tokens[index]);
		index++;
		return boo;
		}
	//sets pattern as delimiter and prints 
	public void useDelimeter(String pattern) {
		StringTokenizer token = new StringTokenizer(tokens[index], pattern);
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
		
	}
	
	
	

	}

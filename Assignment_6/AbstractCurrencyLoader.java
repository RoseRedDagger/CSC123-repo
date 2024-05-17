package assignment6Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCurrencyLoader {

	
	public static AbstractCurrencyLoader getInstance(String type) {
		type=type.toUpperCase().strip();
		
		if(type.equals("FILE")) {
			return new FileCurrencyLoader();
			
		}
		else if(type.equals("STRING")) {
			return new StringHook();
		}
		else if (type.equals("NETWORK")){
			return new NetworkCurrencyLoader();
			
		}
		
		return null;
		
	}
	
	public Map<String, MyCurrency> loadCurrencies() throws Exception{
		Map m=new HashMap<String, MyCurrency>();
		BufferedReader br=new BufferedReader(new InputStreamReader(getStream()));
		
		String line=null;
		while((line=br.readLine())!=null) {
			String[] tokens=line.split(",");
			String currencyCode=tokens[0];
			double exchangeRate=Double.valueOf(tokens[2]);
			m.put(currencyCode,new MyCurrency(currencyCode, exchangeRate));
		}
		return m;
	}
	
	protected abstract InputStream getStream() throws FileNotFoundException, IOException;
 	
}
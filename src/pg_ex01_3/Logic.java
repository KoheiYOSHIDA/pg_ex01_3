package pg_ex01_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic extends Main {
	int MaxUpdatekey = 1;

	public void StartFunction() {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.clear();
		String line = INPUTTEXT;
		showWord(line);
		exstractWord(line,map);
		sortWord(map);
	}

/*	public void importInputFile(Map map) {
		 String fileName = "pg_ex01_3/src/pg_ex01_3/sample1.txt";
		   try {
		     BufferedReader in = new BufferedReader(new FileReader(fileName));
		     while (true) {
		       String line = in.readLine();
		       if (line == null) {
		         break;
		       }
		       showWord(line);
		       exstractWord(line,map);
		    }
		    in.close();
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
	}
*/
	public String convertLargeToSmall(String largeWord) {
		String smallWord = largeWord.toLowerCase();
		return smallWord;
	}

	public void exstractWord(String line,Map map) {
		String p[] = line.split(PATTERN2);
		String result = null;
		for (int i=0;i < p.length; i++) {
			result = patternMatch(p[i]);
			if(result.equals("")) continue;
			registWord(result,map);

		}

	}

	public String patternMatch(String input) {
		String regex = PATTERN1;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		if (m.find()){
			String str[] = input.split(PATTERN1,2);
			Matcher match = p.matcher(str[0]);
			 if(match.find()) {
				 return "";
			 }
			return str[0];
		}
	 return input;
	}

	public void registWord(String word,Map map) {
		word = convertLargeToSmall(word);
//		System.out.println(word);
		if (map.containsKey(word)) {
			int updateKey = (int)map.get(word) + 1;
			if(MaxUpdatekey < updateKey) {
				MaxUpdatekey = updateKey;
			}
			  map.put(word,updateKey);
		} else {
			map.put(word, 1);
		}
	}

	public void sortWord(Map map) {
		 List<Entry<String, Integer>> list_entries =
			new ArrayList<Entry<String, Integer>>(map.entrySet());
		 Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
		 
		 Map<Integer, String> mMap = new HashMap<Integer, String>();
		 mMap.clear();
		 
		 
	       for(Entry<String, Integer> entry : list_entries) {
	    	   System.out.println(entry.getKey() + " : " + entry.getValue());
	/*    	   System.out.println(entry.getKey()+":"+entry.getValue());
	    	   if(MaxUpdatekey == entry.getValue()) {
	    		   System.out.println(entry.getKey()+":"+entry.getValue());

	    		   mMap.put(entry.getValue(),entry.getKey());
	    		   continue;
	    	   } else {
	    		   Object[] mapkey = mMap.keySet().toArray();
	    		   Arrays.sort(mapkey);
	           
	    		   for (Integer nKey : mMap.keySet()){
	    			   System.out.println(mMap.get(nKey));
	    		   } 
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	    		   mMap.clear();
	    		   mMap.put(entry.getValue(),entry.getKey());
	    		   MaxUpdatekey--;
	        } */
	    }
    }


	public void showWord(String word) {
		System.out.print(word);
		System.out.println("\n");
	}
}
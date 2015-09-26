
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		String[] namesList = new String[]{"Freda", "Argelia", "Hermine", "Audria", "Isela", 
										  "Danelle", "Kathern", "Maurita", "Ambrose", "Nevada", 
										  "Cathey", "Mirtha", "Jung", "Laurie", "Tawanna", 
										  "Yelena", "Marlo", "Flo", "Brigida", "Ophelia", 
										  "Eloy", "Nikole", "Rocco", "Jo", "Harlan", 
										  "Ivan", "Dean", "Zelma", "Angle", "Efren"};
		
		Random r = new Random();
		int randomNumber;
		
		Map<String, Integer> shortHashNameList = new HashMap<String, Integer>();
		shortHashNameList.put("Freda", 21);
		shortHashNameList.put("Mirtha", 31);
		shortHashNameList.put("Rocco", 41);
		shortHashNameList.put("Freda", 51);
		shortHashNameList.put("Eloy", 11);
		
		List<Person> shortNoHashNameList = new ArrayList<Person>();
		shortNoHashNameList.add(new Person("Freda", 21));
		shortNoHashNameList.add(new Person("Mirtha", 31));
		shortNoHashNameList.add(new Person("Rocco", 41));
		shortNoHashNameList.add(new Person("Freda", 51));
		shortNoHashNameList.add(new Person("Eloy", 11));
		
		long time = 0;
		
		for(int i = 0; i < 50000000; i++){
			randomNumber = r.nextInt(30);
			//start time counter
			long start = System.currentTimeMillis();
			shortHashNameList.get(namesList[randomNumber]);
			//finish and add timer counter
			long end = System.currentTimeMillis();
			time += end - start;
		}
		
		//print time
		System.out.println("The search time with Hash was: " + time/1000d + " seconds");
		
		time = 0;
		for(int i = 0; i < 50000000; i++){
			randomNumber = r.nextInt(30);
			
			String name = namesList[randomNumber];
			
			long end;
			//start time counter
			long start = System.currentTimeMillis();
			for(Person p : shortNoHashNameList){
				if(p.getName().equals(name)){
					//finish and add timer counter
					end = System.currentTimeMillis();
					time += end - start;
					break;
				}
				//finish and add timer counter
				end = System.currentTimeMillis();
				time += end - start;
			}
			
		}
		
		//print time
		System.out.println("The search time with List was: " + time/1000d + " seconds");

	}

}

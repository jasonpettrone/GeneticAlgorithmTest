
public class Driver {
	
	public static void main(String[] args){
		
		String target = "Jason is cool";
		
		Population pop = new Population(200, .05, target.toCharArray());
		pop.createInitialPop();
		int generations = 10000;
		
		for(int i = 0; i < generations; i++){
			
			pop.createNewGeneration();
			
			if(i % 1 == 0){
				System.out.println(pop.getFittestMember() + " " + pop.getFittestMember().fitness(target.toCharArray()));
				if(pop.getFittestMember().toString().equals(target)){
					System.out.println("'" + target + "'" + " was found on generation " + i);
					break;
				}
			}
			
		}
		
		
		
		
	}
}

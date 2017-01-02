
public class Driver {
	
	public static void main(String[] args){
		
		String target = "This Genetic Algorithm was made by Jason Pettrone";	
		Population pop = new Population(1000, 0.5, target.toCharArray());
		int generations = 100000;
		
	
		pop.createInitialPop();		
		for(int i = 0; i < generations; i++){
			
			pop.createNewGeneration();
			
			if(i%1 == 0){
				System.out.println(pop.getFittestMember().toString() + " " + pop.getFittestMember().fitness);
				if(pop.getFittestMember().toString().equals(target)){
					System.out.println("'" + target + "'" + " was found on generation " + i);
					break;
				}
			}
		}
		
		
		
		
	}
}


public class Driver {
	
	public static void main(String[] args){
		
		String target = "......................................................................................................................................................";
		Population pop = new Population(10000, 1, target.toCharArray());
		int generations = 1000000000;
		
	
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


public class Driver {
	
	public static void main(String[] args){
		
		String target = "Fat eggs";
		DNA parent1 = new DNA(10);
		DNA parent2 = new DNA(10);
		
		System.out.println(parent1 + " " + parent1.fitness(target.toCharArray()));
		System.out.println(parent2 + " " + parent2.fitness(target.toCharArray()));
		
		System.out.println(DNA.reproduce(parent1, parent2, 1));
	}
}

import java.util.Random;

public class DNA {
	
	char[] genes;	//Genes this DNA will have
	double fitness;	//Fitness of this particular set of genes
	
	
	//Constructor - initializes with a set of genes
	public DNA(String genes){
		
		this.genes = genes.toCharArray();
	}
	
	//Constructor - will generate a random set of genes with a given length
	public DNA(int length){
		
		Random r = new Random();
		String s = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		
		String result = "";
		for(int i = 0; i<length; i++)
			result += s.charAt(r.nextInt(s.length()));
		
		genes = result.toCharArray();
	}
	
	//Get genes
	public char[] getGenes(){
		
		return genes;
	}
	
	//Set genes
	public void setGenes(char[] genes){
		
		this.genes = genes;
	}
	
	//Crossover method - Mates two parents to create a child
	public static char[] crossover(DNA parent1, DNA parent2){
		
		char[] child = parent1.getGenes();
		
		//Do crossover
		
		return child;
	}
	
	//Fitness function - returns the fitness of this set of genes
	public double getFitness(){
		
		return 1.0;
	}
	
	//toString method for easy printing
	public String toString(){
		
		String answer = "";
		for(int i = 0; i < genes.length; i++)
			answer += genes[i];
		return answer;
	}
}

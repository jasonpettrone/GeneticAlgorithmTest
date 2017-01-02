import java.util.Random;

public class DNA {
	
	private char[] genes;	//Genes this DNA will have
	private int fitness;	//Fitness of this particular set of genes
	
	private static Random r = new Random();
	private static String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";
	
	
	//Constructor - initializes with a set of genes
	public DNA(char[] genes){
		
		this.genes = genes;
	}
	
	//Constructor - will generate a random set of genes with a given length
	public DNA(int length){
		
		String result = "";
		for(int i = 0; i<length; i++)
			result += alphabet.charAt(r.nextInt(alphabet.length()));
		
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
	
	//Reproduction method - Mates two parents to create a child, returns child
	//The child's genes are produced by alternating between the two parents genes 
	public static DNA reproduce(DNA parent1, DNA parent2, double mutationRate){
		
		DNA child;
		char[] parent1Genes = parent1.getGenes();
		char[] parent2Genes = parent2.getGenes();
		char[] childGenes = new char[parent1Genes.length];
		
		//Alternate between the two parents to produce the child
		for(int i = 0; i<parent1Genes.length; i++){
			if(i%2==0)
				childGenes[i] = parent1Genes[i];
			else
				childGenes[i] = parent2Genes[i];
		}
		
		//Chance a mutation on the child
		//We mutate the child by giving it a new random character in a random location
		if(Math.random() < mutationRate)
			childGenes[r.nextInt(childGenes.length)] = alphabet.charAt(r.nextInt(alphabet.length()));
			
		
		child  = new DNA(childGenes);
		return child;
	}
	
	//Fitness function - returns the fitness of this set of genes
	//The fitness in this case is determined by how many characters match the target phrase
	public int fitness(char[] target){
		
		int fitness = 0;
		
		for(int i = 0; i < target.length; i++)
			if(genes[i] == target[i])
				fitness++;
		
		this.fitness = fitness;
		return fitness;
	}
	
	//toString method for easy printing
	public String toString(){
		
		String answer = "";
		for(int i = 0; i < genes.length; i++)
			answer += genes[i];
		return answer;
	}
}

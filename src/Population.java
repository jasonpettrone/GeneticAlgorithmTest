import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Population {
	
	private DNA[] population;
	private double mutationRate;
	private int size;
	private char[] target;
	private static Random r = new Random();
	
	//Constructor to initialize a population of size n, a mutation rate, and a target
	public Population(int n, double rate, char[] target){
		
		size = n;
		mutationRate = rate;
		this.target = target;
		population = new DNA[size];
	}
	
	//Creates our initial random population
	public void createInitialPop(){
		
		for(int i = 0; i < population.length; i++)
			population[i] = new DNA(target.length);	
	}
	
	//Survival of the fittest. Chooses what parents will create the next generation.
	public DNA[] selection(){
		
		ArrayList<DNA> genePool = new ArrayList<DNA>();
		DNA[] parents = new DNA[2];
		
		//Evaluate fitness of each element
		for(int i = 0; i < population.length; i++){
			int fitness = population[i].fitness(target);
			for(int j = 0; j<fitness; j++)
				genePool.add(population[i]);
		}
		
		parents[0] = genePool.get(r.nextInt(genePool.size()));
		parents[1] = genePool.get(r.nextInt(genePool.size()));
		
		return parents;
	}
	
	public void createNewGeneration(){
		
		
		for(int i = 0; i < population.length; i++){
			
			//Get the parents of the new generation
			DNA[] parents = selection();
			
			//Create children from those parents
			population[i] = DNA.reproduce(parents[0], parents[1], mutationRate);
		}
	}
	
	//Gets the fittest member of the current population
	public DNA getFittestMember(){
		
		int fittest = 0;
		int index = 0;
		
		for(int i = 0; i < population.length; i++){
			if(population[i].fitness(target) > fittest){
				index = i;
				fittest = population[i].fitness(target);
			}
		}
		
		return population[index];
	}
	
	public String toString(){
		
		return Arrays.toString(population);
	}
}

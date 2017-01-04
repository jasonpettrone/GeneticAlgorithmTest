import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Population {
	
	private ArrayList<DNA> population;
	private PriorityQueue<DNA> heapPopulation;
	private double mutationRate;
	private int size;
	private char[] target;
	private static Random r = new Random();
	Comparator<DNA> comparator = new DNA(0);
	
	//Constructor to initialize a population of size n, a mutation rate, and a target
	public Population(int n, double rate, char[] target){
		
		size = n;
		mutationRate = rate;
		this.target = target;
		
		heapPopulation = new PriorityQueue<DNA>(comparator);
		population = new ArrayList<DNA>();
	}
	
	//Creates our initial random population
	public void createInitialPop(){
		
		for(int i = 0; i < size; i++){
			population.add(new DNA(target.length));
			population.get(i).fitness(target);
			heapPopulation.add(population.get(i));
		}
		
	}
	
	//Survival of the fittest. Chooses what parents will create the next generation.
	//The parents are chosen off the top of a heap, so the two strongest parents will create the next generation
	public DNA[] selection(){
		
		DNA[] parents = new DNA[2];
		
		parents[0] = heapPopulation.poll();
		
		if(parents[0].toString().equals(heapPopulation.peek().toString()) == false)
			parents[1] = heapPopulation.poll();
		else{
			while(parents[0].toString().equals(heapPopulation.peek().toString())){
				if(heapPopulation.size() == 1)
					break;
				else
					parents[1] = heapPopulation.poll();
			}
		}
		
		return parents;
	}
	
	public void createNewGeneration(){
		
		ArrayList<DNA> newPop = new ArrayList<DNA>();
		PriorityQueue<DNA> newHeap = new PriorityQueue<DNA>(comparator);

		DNA[] parents = selection();
		for(int i = 0; i < population.size(); i++){
			DNA child = DNA.reproduce(parents[0], parents[1], mutationRate);
			newPop.add(child);
			newPop.get(i).fitness(target);
			newHeap.add(child);
		}	
		
		heapPopulation = newHeap;
		population = newPop;
		
	}
	
	//Gets the fittest member of the current population
	public DNA getFittestMember(){
		
		return heapPopulation.peek();
	}
	
	public String toString(){
		
		return population.toString();
	}
}

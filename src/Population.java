import java.util.ArrayList;

public class Population {
	
	private DNA[] population;
	private double mutationRate;
	private int size;
	
	//Constructor to initialize a population of size n and a mutation rate
	public Population(int n, double rate){
		
		size = n;
		mutationRate = rate;
		population = new DNA[size];
	}
}

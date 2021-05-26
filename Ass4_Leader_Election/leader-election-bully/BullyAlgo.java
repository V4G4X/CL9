import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Bully{
	private int noOfProcess;
	private ArrayList<Boolean> state = new ArrayList<Boolean>();
	private int leader;

	public Bully(int noOfProcess) {
		this.noOfProcess = noOfProcess;
		for(int i=0;i<noOfProcess;i++) {
			state.add(true);
		}
		System.out.println("\nCreated " + noOfProcess + " process");
	}

	public void up(int processId) {

		if(state.get(processId-1)) {
			System.out.println("\nProcess " + processId + " is already active");		
		}
		else {
			int highestActiveProcess = processId-1 ;
			state.set(processId-1,true);
			System.out.println("\nProcess " + processId + " held election");
			
			for(int i = processId;i<noOfProcess;i++) {
				System.out.println("Election msg sent from " + processId + " to process " + (i+1));
			}

			System.out.println("\n");

			for(int i=processId;i<noOfProcess;i++) {
				if(state.get(i)) {
					System.out.println("Alive msg sent from process " + (i+1) + " to process " + processId);
					highestActiveProcess = i;
				}
			}

			leader = highestActiveProcess + 1;

			System.out.println("\nElected Leader : Prcess " + leader);
			
		}

	}

	public void down(int processId) {
		state.set(processId-1,false);
		System.out.println("\nProcess " + processId + " went down");
		if(leader == processId) {
			holdElection();
		}
	}

	public void holdElection() {

		Scanner sc = new Scanner(System.in);
		int processId;


		while(true) {

			System.out.println("\nCoordination Process : ");
			processId = sc.nextInt();

			if(state.get(processId-1)) {
				break;
			}

			System.out.println("\nProcess " + processId + " is down...Select another process to hold election");
		}

		System.out.println("Process " + processId + " held election");

		int highestActiveProcess = processId-1 ;
			
		for(int i = processId;i<noOfProcess;i++) {
			System.out.println("Election msg sent from " + processId + " to process " + (i+1));
		}

		System.out.println("\n");

		for(int i=processId;i<noOfProcess;i++) {
			if(state.get(i)) {
				System.out.println("Alive msg sent from process " + (i+1) + " to process " + processId);
				highestActiveProcess = i;
			}
		}

		leader = highestActiveProcess + 1;

		System.out.println("\nElected Leader : Process " + leader);

	}

}

public class BullyAlgo {
	public static void main(String[] args) {

		System.out.println("Enter no of processes : ");

		Scanner sc = new Scanner(System.in);
		int noOfProcess = sc.nextInt();


		Bully bully = new Bully(noOfProcess);


		while(true) {
			System.out.println("\nEnter choice : \n1) Up process \n2) Down process \n3) Hold election \n4) Exit\nChoice : ");

			int choice = sc.nextInt();

			if(choice == 4) 
				break;

			switch(choice) {

				case 1 : 
					System.out.println("Process Id : ");
					int temp = sc.nextInt();
					bully.up(temp);
					break;

				case 2 : 
					System.out.println("Process Id : ");
					int temp1 = sc.nextInt();
					bully.down(temp1);
					break;

				case 3 : 
					bully.holdElection();
			}

		}

	}
}
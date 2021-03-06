package com.daltrisseville.DogeNaval.Client.Entities;

import java.util.ArrayList;

/**
 * This class represents the admin game board
 */
public class PrivateBoard extends GenericBoard{

	// private int[] expectedDogList;
	private ArrayList<Dog> dogs;
	private ArrayList<Integer> expectedDogList;

	private static Integer[] BOARD_DOG_LIST = { 3, 4, 5 };
	

	public PrivateBoard() {
		// this.expectedDogList = BOARD_DOG_LIST;
		this.expectedDogList = new ArrayList<Integer>();
		for (int i : BOARD_DOG_LIST) {
			expectedDogList.add(i);
		}
		this.dogs = new ArrayList<Dog>();
		
	}

	public void addDog(int length,int x, int y,  DogDirection d) {
		Dog dog = new Dog(length, x, y, d);
		dogs.add(dog);
	}
	public void addDog(Dog dog) {
		dogs.add(dog);
	}

	
	public ArrayList<Integer> getExpectedDogList() {
		return expectedDogList;
	}

	

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}

	

}

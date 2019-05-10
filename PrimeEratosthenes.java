/*
 * File: PrimeEsratosthenes.java
 * ------------------------------
 * A program to find prime number from 2 to N, where
 * N is the upper limit that we declared as constant.
 * The algorithm to find the prime number is based on
 * the third B.C Greek astronomer, Eratosthenes.
 */

import acm.program.*;
import java.util.*;

public class PrimeEratosthenes extends ConsoleProgram {
	
	/* The upper limit of the prime number list*/
	private static final int UPPER_LIMIT = 1000;
	/* The number to indicate composite number*/
	private static final int COMPOSITE = -1;
	/* The array that contain list of prime number*/
	private int[] array;
	
	public void run() {
		initArray();
		createPrimeArray();
		printList();
	}
	
	/**
	 * Method: initArray
	 * ------------------
	 * This method initializes the array of number 2 until
	 * UPPER_LIMIT.
	 */
	private void initArray() {
		array = new int[UPPER_LIMIT - 1];
		for(int i = 2; i <= UPPER_LIMIT; i++) {
			array[i - 2] = i;
		}
	}
	
	/**
	 * Method: printList
	 * ------------------
	 * This method will print the list of prime number.
	 */
	private void printList() {
		for(int i = 0; i < UPPER_LIMIT - 1; i++) {
			if(array[i] != COMPOSITE) {
				println(array[i]);
			}
		}
	}
	
	/**
	 * Method: createPrimeArray
	 * -------------------------
	 * This method will create an array of prime number.
	 */
	private void createPrimeArray() {
		for(int i = 0; i < UPPER_LIMIT - 1; i++) {
			if(array[i] != COMPOSITE) {
				removePrimeMultiples(i);
			}
		}
	}
	
	/**
	 * Method: removePrimeMultiples
	 * -----------------------------
	 * This method will cross out all multiples of the
	 * prime numbers. This is done by assigning the number 
	 * as COMPOSITE.
	 * @param i
	 */
	private void removePrimeMultiples(int i) {
		int prime = array[i];
		for(int j = i + 1; j < UPPER_LIMIT - 1; j++) {
			if(array[j] != COMPOSITE && array[j] % prime == 0) {
				array[j] = COMPOSITE;
			}
		}
	}
	
}
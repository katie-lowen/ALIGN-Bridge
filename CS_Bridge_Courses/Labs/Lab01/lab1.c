#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//this code is a rewriting of a pythoon exercise "print evens"
//uses a for loop to go throught a given list and print the even numbers

int findEvens( int array[], int size){
	for (int i =  0; i < size; i ++){
		if (array[i] % 2 == 0){
			 printf("%d\n", array[i]);
		}
	}
}

int main(){

	int array[] = {1, 2, 3, 4, 5, 6, 8, 10};
	int evenNums = findEvens(array, 8);
	printf("Above are the even numbers presented in the given list");
	
	return 0;

}

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


//sets up vector strucutre
//data is sue dot track values in array
//size is the amount of non null elements in array
//capacity is hwo big the array is when we make it 
typedef struct vector {
	int*data;
	int size;
	int capacity;
	

}vector_t;

//delceration to avoid error
void freeVector(vector_t* vector);

//sets up vector fcuntion
vector_t* makeVector(int initCapacity) {
	
	//put vector on heap
	vector_t* vector = (vector_t*)malloc(sizeof(vector_t));

	if (vector == NULL) {
		return NULL;
		}
	//put datat on heap
	//set size ot zero
	//Capacity is passed
	vector->data = (int*)malloc(sizeof(int)*initCapacity);
	vector->size = 0;
	vector->capacity = initCapacity;
	return vector;
}


//loops through array to free values from heap 
void freeVector(vector_t* vector) {
	if (vector == NULL) {
		       return; 	}
	if (vector-> data != NULL) {
	free(vector->data);}

	free(vector);
	
}

//resize function doubles the capacity of the array 
void  resize(vector_t* vect) {

	if (vect==NULL) {return;}

	//doubles capacity 
	vect->capacity = vect->capacity*2;
	int * newvect =  (int*) malloc(sizeof(int)*vect->capacity);
	//error coding
	if( newvect == NULL || vect->data ==NULL){ 
		printf("failure\n");
		return;}
	//passing th old array to the new array
	for (int i=0; i < vect->size; i++) {
	    newvect[i]=vect->data[i];}	 
	free(vect->data);	
	//pass the old data to the new array strcuutre
	vect->data = newvect;
}



//pritn function for the array 
void print (vector_t* vect) {

	if (vect == NULL){
		return;}
	else if(vect->data == NULL ) {  
		printf("empty");
		return;   }
	//will print null values 
	for (int i =0; i < vect->size; i++) {
		printf("%d ",vect->data[i]);
		}
	printf("\n");
}

//the add fcuntion can add anywhere in the array
//it primarily will add to the first position since we are usign a queue 
void add ( vector_t* vect, int pos, int num) {

	//error coding
	if ( pos <=0) {

		printf("invalid num or num to big, use the append function \n");
		return;} 	


	//check to see if the array is too small for our new addition if so resize fucntion is called	
	if (pos> vect->capacity || vect->size >= vect->capacity ){
		resize(vect); 
	;}			
	
//shifts the array one down from the position
	for(int i = vect->size -1; i >=pos; i--) {
		vect->data[i] = vect->data[i-1];}
	//insert posiiton and element
	vect->data[pos-1] = num;
	vect->size++;
}




//delete any element in list including null
void delete(vector_t* vect, int pos) {
	//error checking  
	if ( pos <=0 || pos > vect->size) {
                  printf("invalid num or num to big");}
	if (vect==NULL) {return;}	
	 //opposite of adding takes the element shifts up one based on position
	for (int i =pos-1; i < vect->size; i++) {
	    vect->data[i] = vect->data[i+1];}

	vect->size--;
	}

//check to see if vect is empty
bool is_empty(vector_t* vect) {
	if (vect->size == 0) {
		return true; }
	
	return false;
}

//find any position in array by passing value of position
void find( vector_t*vect , int pos) {
	if (pos > vect->capacity || pos<0) {
		printf("error cant be negative or higher than capacity \n");
		return;}	
	printf("value at pos is %d\n",vect->data[pos]);
}


//size  is tracked as we go so we just print size
int size(vector_t* vect) {

	if (vect == NULL) {return 0;}
	
	return vect->size;

}


int main() {
	//initalize vector
	vector_t* vect_2 =  makeVector(2);
	//addd point point to vector 
	//since its a queue will go to position one
	//the size+1 will force it to be added in order
	add(vect_2,vect_2->size+1,1);
	//print is used to check queueu 
	print(vect_2);
	
	add(vect_2,vect_2->size+1,2);
	//more checking and tetsing the find function for three ootions  
	find(vect_2,1);
	find(vect_2,-2);
	find(vect_2,1000);
	print(vect_2);
	//this will trigger the resize function
	add(vect_2,vect_2->size+1,3);
	print(vect_2);
	//start deleitng our entries
	delete(vect_2,1);
	print(vect_2);
	delete(vect_2,1);
	print(vect_2);
	delete(vect_2,1);
	//will trigger a deletion with no amounts in vector 
	delete(vect_2,1);
	print(vect_2);
	freeVector(vect_2);
	return 0 ;


	/*
 	*the following is more tetsin 	
	vector_t*vect = makeVector(10);
	//illegla vector add
	add(vect,-1,0);
	//normal vector adds
	add(vect,3,1);
	add(vect,2,2);
	add(vect,5,3);
	add(vect,4,4);
	//test print
	print(vect);
	//Test delete 
	delete(vect,2);
	delete(vect,3);
	print(vect);
	//test find
	find(vect,3);
	bool x = is_empty(vect);
	//tets boolean
	printf("%s\n", x? "true": "false");
	//test size 
	printf("size of array: %d\n",size(vect));	
	freeVector(vect);
	return 0;*/

}

package com.two.anubha.java.algo;
import java.util.*;
/*Answer a Query
Imagine a length-N array of booleans, initially all false. Over time, some values are 
set to true, and at various points in time you would like to find the location of the
 nearest true to the right of given indices.
 
You will receive Q queries, each of which has a type and a value. SET queries have type = 1 
and GET queries have type = 2.

When you receive a SET query, the value of the query denotes an index in the array that 
is set to true. Note that these indices start at 1. When you receive a GET query, you must 
return the smallest index that contains a true value that is greater than or equal to the given 
index, or -1 if no such index exists.

Signature
int[] answerQueries(ArrayList<Query> queries, int N)

Input
A list of Q queries, formatted as [type, index] where type is either 1 or 2, and index is < N
1 <= N <= 1,000,000,000
1 <= Q <= 500,000

Output
Return an array containing the results of all GET queries. The result of queries[i] is the smallest 
index that contains a true value that is greater than or equal to i, or -1 if no index satisfies those conditions.

Example
N = 5
Q = 5
queries = [[2, 3], [1, 2], [2, 1], [2, 3], [2, 2]]
output = [-1, 2, -1, 2]

The initial state of the array is [false, false, false, false, false].

The first query is GET 3, but no values in the array are true, so the answer is -1.
The second query is SET 2, so the value at index 2 is set to true.
The new state of the array is [false, true, false, false, false].

The third query is GET 1, and the index of the true value nearest to 1 (to the right) is 2.
The fourth query is GET 3, but no values to the right of index 3 are true.
The fifth query is GET 2, and the value at index 2 is true.*/
class Query{
  int type;
  int index;
}
public class AnswerQueries {
	
	int[] answerQueries(ArrayList<Query> queries, int N){
	   int[] retArray = new int[queries.size()];
	   boolean[] boolArray = new boolean[queries.size()];
	  
	   Arrays.fill(boolArray, false);
	   int k=0;
	  
	   for(int i=0; i<queries.size(); i++){
	      if(queries.get(i).type == 1){
	         boolArray[i] = true;
	      }else if(queries.get(i).type == 2){
	         boolean found = false;
	         for(int j=queries.get(i).index-1; j<queries.size(); j++){
	        	 if(boolArray[j] == true){
		              retArray[k++] = j+1;
		              found = true;
		              break;
	           }
	         }
             if(!found)
	             retArray[k++] = -1;
	      }
	   }
	   return retArray;
	}
	
	public static void main(String[] args){
		//[[2, 3], [1, 2], [2, 1], [2, 3], [2, 2]]
		Query query1 = new Query();
		query1.type = 2;
		query1.index = 3;
		
		Query query2 = new Query();
		query2.type = 1;
		query2.index = 2;
		
		Query query3 = new Query();
		query3.type = 2;
		query3.index = 1;
		
		Query query4 = new Query();
		query4.type = 2;
		query4.index = 3;
		
		Query query5 = new Query();
		query5.type = 2;
		query5.index = 2;
		
		ArrayList<Query> queries = new ArrayList<>();
		queries.add(query1);
		queries.add(query2);
		queries.add(query3);
		queries.add(query4);
		queries.add(query5);
		
		AnswerQueries  mock1 = new AnswerQueries();
		int[] retArray = mock1.answerQueries(queries, 5);
		
		Arrays.stream(retArray)
			  .forEach(System.out::println);
		
		System.exit(0);
	}
}

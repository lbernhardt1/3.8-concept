package concept;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * Concept for branching Yes-No-Questions
		 * 
		 * 1) Old design List of Questions
		 * 
		 * (Q)-(Q)-(Q)-(Q)-(Q)-(Q)-...
		 * 
		 * 2) New design List of List of Questions
		 * 
		 * ((Q))-((Q))-((Q))-((Q))-...
		 * 		   |           |
		 *        (Q)         (Q)
		 *        
		 * 3) Methods to add a List of Questions to main branch and method to add follow up Questions to sub branch
		 * 
		 * ((Q))-((Q))-((Q))-((Q)) + ((Q))
		 * 		   |           |
		 *        (Q)         (Q)
		 *        			   +
		 *        			  (Q)
		 *        
		 * 4) Methods like startSurvey use 2 nested for loops to traverse all Questions. 
		 * 	  A If statement checks the user input and is a Question answered negatively
		 * 	  the inner for loop will be terminated with break; the remaining follow up
		 *    Questions in this branch will not be asked.
		 */
	
		Survey testSurvey = new Survey("A new test Survey");
		testSurvey.addQuestion("Is the sky blue?");
		testSurvey.addQuestion("Do you have a favorite number?");
		testSurvey.addFollowupQuestion("Is your favorite number <100?");
		testSurvey.addFollowupQuestion("Is your favorite number <10?");
		testSurvey.addQuestion("Is water wet?");
		
		testSurvey.startSurvey();
		testSurvey.startSurvey();
		testSurvey.startSurvey();
		testSurvey.printSurvey();


	}

}

package concept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import concept.YNQuestion;

public class Survey {

	private List<List<YNQuestion>> allQuestions;
	private String description;

	/** Constructor
	 */
	public Survey(String description) {
		super();
		this.allQuestions = new ArrayList<List<YNQuestion>>();
		this.description = "Description: " + description;
	}

	/** Adds a new List of size 1 containing the Question to allQuestions
	 * @param questionText
	 */
	public void addQuestion(String questionText) {
		YNQuestion newquest = new YNQuestion(questionText);
		List<YNQuestion> newquestlist = new ArrayList<YNQuestion>();
		newquestlist.add(newquest);
		allQuestions.add(newquestlist);
	}

	/** Adds a new follow up Question to the last List of Questions in allQuestions
	 * @param questionText
	 */
	public void addFollowupQuestion(String questionText) {
		YNQuestion newquest = new YNQuestion(questionText);

		allQuestions.get(allQuestions.size() - 1).add(newquest);
	}

	/** Prints the entire Survey including description, questions, options and answers.
	 * 
	 */
	public void printSurvey(){
		System.out.println(description + "\n");
		for (List<YNQuestion> i : allQuestions) {
			for (YNQuestion j : i) {
				System.out.println(j.printAll());
			}				
		}
	}

	/** Prints all Questions in Survey and records the given answers.
	 *  Skips follow up questions if the previous answer was negativ.
	 * 
	 */
	public void startSurvey(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		for (List<YNQuestion> i : allQuestions) {
			for (YNQuestion j : i) {
				// prints question
				System.out.println(j.printQuestionText());

				// checks until it receives a valid input
				while(!validYN(input)){
					try {
						input = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}

				// adds the valid answer, clears input and continues the follow up questions on yes or breaks on no
				if(input.equals("y")){
					j.addAnswer("y");
					input = "";
				} else if(input.equals("n")){
					j.addAnswer("n");
					input = "";
					break;
				} 
			}				
		}
		System.out.println("Survey is finished\n");
	}

	/** Checks if input is a valid answer to a YNQuestion
	 * @param input
	 * @return
	 */
	boolean validYN(String input){
		if (input.equals("y") || input.equals("n")){
			return true;
		} else {
			return false;
		}
	}

}

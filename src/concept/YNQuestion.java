package concept;

import java.util.ArrayList;
import java.util.List;

public class YNQuestion {
	
	private String questionText;
	private List<String> answers;
	private List<String> options;
	
	/** Constructor
	 * @param questionText
	 */
	public YNQuestion(String questionText) {
		super();
		this.questionText = questionText;
		this.answers = new ArrayList<String>();
		this.options = new ArrayList<String>();
		options.add("Yes or No? (y/n)");
	}
	
	/** Adds new answer
	 * @param answer
	 */
	public void addAnswer(String answer) {
		this.answers.add(answer);
	}
	
	/** Returns the text of the question and available options
	 * @return
	 */
	public String printQuestionText(){
		return questionText + "\n" + options.toString();
	}
	
	/** Returns the text of the question, available options and all given answers
	 * @return
	 */
	public String printAll(){
		return questionText + "\n" + options.toString() + "\n" + answers.toString() + "\n";
	}

}

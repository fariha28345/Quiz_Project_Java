import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import java.util.Random;
import java.util.Scanner;

public class GiveQuiz {
    static void giveQuiz() throws IOException, ParseException {
        String fileName = "./src/main/resources/quiz.json";
        Scanner sc = new Scanner(System.in);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        System.out.println("Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. " +
                "Are you ready? Press 's' for start.");

        char ch = sc.next().charAt(0);
        while(ch == 's'){
            int marks = 0;
            for (int i = 1; i <= 10; i++) {

                Random rand = new Random();
                int pos = rand.nextInt(jsonArray.size());
                JSONObject quesObj = (JSONObject) jsonArray.get(pos);

                String question = (String) quesObj.get("question");
                String option1 = (String) quesObj.get("option 1");
                String option2 = (String) quesObj.get("option 2");
                String option3 = (String) quesObj.get("option 3");
                String option4 = (String) quesObj.get("option 4");
                String answerkey = (String) quesObj.get("answerkey");

                System.out.println("\n[Question " + i + "] " +question);
                System.out.println("1. " + option1);
                System.out.println("2. " + option2);
                System.out.println("3. " + option3);
                System.out.println("4. " + option4);


                String answer = sc.next();
                if (answer.equals(answerkey)) {
                    marks++;
                }
            }
            if(marks >= 8) {
                System.out.println("\nExcellent! You have got " + marks + " out of 10");
            } else if (marks >= 5) {
                System.out.println("\nGood. You have got "+ marks +" out of 10");
            } else if (marks >= 2) {
                System.out.println("\nVery poor! You have got "+ marks +" out of 10");
            } else {
                System.out.println("\nVery sorry you are failed. You have got "+ marks +" out of 10");
            }

            System.out.println("\nWould you like to start again? press s for start or q for quit");
            ch = sc.next().charAt(0);
        }
    }
}

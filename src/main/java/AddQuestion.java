import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class AddQuestion {
    static void addQuestion() throws IOException, ParseException {
        System.out.println("Welcome admin! Please create new questions in the question bank.");
        String fileName = "./src/main/resources/quiz.json";
        char choice;
        do {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;

            Scanner sc = new Scanner(System.in);

            JSONObject addQs = new JSONObject();

            System.out.println("Input your question");
            addQs.put("question", sc.nextLine());
            System.out.println("Input option 1:");
            addQs.put("option 1", sc.nextLine());
            System.out.println("Input option 2:");
            addQs.put("option 2", sc.nextLine());
            System.out.println("Input option 3:");
            addQs.put("option 3", sc.nextLine());
            System.out.println("Input option 4:");
            addQs.put("option 4", sc.nextLine());
            System.out.println("What is the answer key?");
            addQs.put("answerkey", sc.nextLine());

            jsonArray.add(addQs);

            FileWriter file = new FileWriter(fileName);
            file.write(jsonArray.toJSONString());
            file.flush();
            System.out.println("Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            choice = sc.next().charAt(0);
        } while (choice == 's');
    }
}

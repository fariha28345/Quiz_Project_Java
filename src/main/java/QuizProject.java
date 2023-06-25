import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class QuizProject {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        String fileName="./src/main/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        System.out.println("Enter your username");
        String username = sc.next();
        System.out.println("Enter password");
        String password = sc.next();

        JSONObject json1 = (JSONObject) jsonArray.get(0);


        String unAdmin = (String) json1.get("username");
        String pAdmin = (String) json1.get("password");

        JSONObject json2 = (JSONObject) jsonArray.get(1);

        String unStudent = (String) json2.get("username");
        String pStudent = (String) json2.get("password");

        if(unAdmin.equals(username) && pAdmin.equals(password)) {
            AddQuestion.addQuestion();
        }
        else if (unStudent.equals(username) && pStudent.equals(password)) {
            GiveQuiz.giveQuiz();
        }
        else {
            System.out.println("Invalid creds");
        }
    }
}

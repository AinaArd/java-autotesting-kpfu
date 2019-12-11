package generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Education;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataGenerator {
    private int number;
    private JSONArray objects;

    private Map<String, Object> vars;
    JavascriptExecutor js;
    private static ObjectMapper mapper = new ObjectMapper();

    public DataGenerator(int number) {
        this.number = number;
//        objects = new JSONArray();
    }

//    public JSONArray createData(int n) {
//        for (int i = 0; i < n; i++) {
//            JSONObject object = new JSONObject();
//            object.put("dateStart", generateRandomDate());
//            object.put("dateEnd", generateRandomDate());
//            object.put("organization", generateRandomName());
//            objects.add(object);
//        }
//        writeToFile(objects);
//        return objects;
//    }
//
//    private void writeToFile(JSONArray array) {
//        try {
//            FileWriter writer = new FileWriter("C:\\AinaArd\\data.txt");
//            for (Object obj : array) {
//                if (obj instanceof JSONObject) {
//                    ((JSONObject)obj).writeJSONString(writer);
//                    writer.write("\ n");
//                }
//            }
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Enter number of elements that should be generated: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        DataGenerator generator = new DataGenerator(number);
        try {
            generator.createData(number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createData(int m) throws IOException {
        List<Education> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new Education(generateRandomDate(), generateRandomDate(), generateRandomName()));
        }
        mapper.writeValue(new File("testData.txt"), list);
    }

    private String generateRandomName() {
        Random random = new Random();
        int length = random.nextInt(25);
        String charLow = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
        String charUp = charLow.toUpperCase();
        String data = charLow + charUp;

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(data.length());
            char rndChar = data.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

    private String generateRandomDate() {
        LocalDate randomDate = createRandomDate(2000, 2019);
        return randomDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}

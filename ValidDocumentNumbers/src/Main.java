import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String numbers = "";
        try (FileReader fileReader = new FileReader("D:\\Courses\\Valid document numbers\\Document numbers.txt")) {
            int i;
            while ((i = fileReader.read()) != -1) {
                numbers = numbers + (char) i;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] number = numbers.split("\n");

        try (
                FileWriter fileWriter = new FileWriter("D:\\Courses\\Valid document numbers\\Valid documents.txt");
                FileWriter fileWriter1 = new FileWriter("D:\\Courses\\Valid document numbers\\Invalid documents.txt")
        ) {

            for (int i = 0; i < number.length; i++) {
                if (number[i].trim().matches("^docnum[0-9a-zA-Z]{9}$") || number[i].matches("^contract[0-9a-zA-Z]{7}$")) {
                    fileWriter.write(number[i]);
                    fileWriter.flush();

                }else {
                    fileWriter1.write(number[i]);
                    fileWriter1.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

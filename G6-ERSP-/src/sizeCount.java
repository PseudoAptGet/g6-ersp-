import java.util.*;
import java.io.*;

public class sizeCount {
    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader("data/StudentProblemHistory_October18(1).csv"))) {
            String line;
            line = br.readLine();
            line = br.readLine();
            ArrayList<String> record = new ArrayList<String>(Arrays.asList(line.split(",")));


            System.out.println(record.get(4));
            // while ((line = br.readLine()) != null) {
            //     String[] values = line.split("'");
            //     records.add(Arrays.asList(values));
            // }
        }
        System.out.println(sizeCount.getNumStudents());

        // data/StudentProblemHistory_October18(1).csv



    }

    public static int getNumStudents(){

        HashSet<Integer> x = new HashSet<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/StudentProblemHistory_October18(1).csv"))) {
            String line;
            line = br.readLine();

            while((line = br.readLine()) != null){
     
                ArrayList<String> record = new ArrayList<String>(Arrays.asList(line.split(",")));


                System.out.println(record.get(4));
                x.add(Integer.parseInt(record.get(4)));
                
            }
            
        }
        
        catch (FileNotFoundException ex){

        } 
        catch (IOException ex){

        }
        return x.size();

    }
}

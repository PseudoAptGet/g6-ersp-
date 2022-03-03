import java.util.*;
import java.io.*;


public class studentClustering {

    public static void main(String[] args){
        System.out.println(studentClustering.getNumTeachers());

    




    }
    
    public static int getNumTeachers(){

        HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
        int numTeachers = 0; 

        try (BufferedReader br = new BufferedReader(new FileReader("data/TeacherActivityOctober18.csv"))) {
            String line;
            line = br.readLine();

            while((line = br.readLine()) != null){
                
                ArrayList<String> record = new ArrayList<String>(Arrays.asList(line.split(",")));
                String y = record.get(1);   
                
                if(x.containsKey(Integer.parseInt(y))){
                    int newVal = x.get(Integer.parseInt(y));
                    int next = newVal+1;
                    x.replace(Integer.parseInt(y), next);
                }
                else{
                    x.put(Integer.parseInt(y), 1);
                }
                
                
            }

            for(HashMap.Entry<Integer, Integer> entry : x.entrySet()){
                if(entry.getValue() > 10){
                    numTeachers += 1; 
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : x.entrySet()) {
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                sb.append('&');
            }
            sb.deleteCharAt(sb.length() - 1);
            String result = sb.toString();

            System.out.println(result);
            
        }
        
        catch (FileNotFoundException ex){

        } 
        catch (IOException ex){

        }
        return numTeachers;
    }






}
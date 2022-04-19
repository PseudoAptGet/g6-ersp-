import java.util.*;
import java.io.*;


public class studentClustering {

    public static void main(String[] args){
        System.out.println(studentClustering.getNumTeachers());
    }
    
    //calculates the number of teachers who have done at least 10 actions. 
    public static int getNumTeachers(){
        HashMap<Integer, Integer> x = new HashMap<Integer, Integer>(); // x has a key value map of teacher id : number of actions
        int numTeachers = 0;  // tracker of numStudents

        try (BufferedReader br = new BufferedReader(new FileReader("data/TeacherActivityOctober18.csv"))) { //Change as necessary to correct filepath
            line = br.readLine(); //skips the first line since it's useless
            while((line = br.readLine()) != null){ 
                
                ArrayList<String> record = new ArrayList<String>(Arrays.asList(line.split(","))); 
                String y = record.get(1);   
                
                if(x.containsKey(Integer.parseInt(y))){ //this entry already exists. Increment x
                    int newVal = x.get(Integer.parseInt(y));
                    int next = newVal+1;
                    x.replace(Integer.parseInt(y), next);
                }
                else{
                    x.put(Integer.parseInt(y), 1); //entry doesn't exist. Create it in x
                }
                
                
            }

            for(HashMap.Entry<Integer, Integer> entry : x.entrySet()){
                if(entry.getValue() > 10){
                    numTeachers += 1; 
                }
            }

            // debugging purposes. 
//             StringBuilder sb = new StringBuilder(); //FOR DEBUGGING PURPOSES
//             for (Map.Entry<Integer, Integer> entry : x.entrySet()) {
//                 sb.append(entry.getKey());
//                 sb.append('=');
//                 sb.append(entry.getValue());
//                 sb.append('&');
//             }
//             sb.deleteCharAt(sb.length() - 1);
//             String result = sb.toString();

//             System.out.println(result);
            
        }
        
        catch (FileNotFoundException ex){

        } 
        catch (IOException ex){

        }
        return numTeachers;
    }






}

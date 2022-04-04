import java.util.*;
import java.util.Map.Entry;
import java.io.*;



public class teacherClustering {

    public static void main(String[] args){
        try{
            HashSet<Integer> applicableTeachers = cleanTeacherData();
            String[] currentClusteringActions = {"Class Summary Per Student", "Class Summary Per Student Per Problem", "Class Summary Per Student Per Topic"};
            HashMap<Integer, Integer> preClusteringOutput = categorizeTeacherData(currentClusteringActions);
            preClusteringOutput.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
        }
        catch (Exception ex){
            System.out.println("UH OH MOMENT");
            
        }
        
        

    




    }

    public static HashMap<Integer, Integer> categorizeTeacherData(String[] currentClusteringActions) throws FileNotFoundException, IOException{
        HashMap<Integer, Integer> returnFreq = new HashMap<Integer, Integer>(); //hashset 
        int numTeachers = 0;  // tracker of numStudents

        try (BufferedReader br = new BufferedReader(new FileReader("data/TeacherActivityOctober18.csv"))) { // FELLAS, CHANGE YOUR FILENAME, AND ADD CORRECT PATH. 
            String line;
            line = br.readLine(); //SKIP THE FIRST LINE BC ITS THE HEADERS/USELESS
            while((line = br.readLine()) != null){ //KEEP ON READING LINES
                
                ArrayList<String> record = new ArrayList<String>(Arrays.asList(line.split(","))); //SPLIT ON COMMAS. GET ARRAYLIST OF ELEMENTS IN A ROW
                String curTeacherId = record.get(1);   //GET PARTICULAR ELEMENT AT ?,IMPORTANT,.....
                String curAction = record.get(3);
                
                for(int i = 0; i < currentClusteringActions.length; ++i){

                    if(curAction.equals(currentClusteringActions[i])){
                        //we know it is contained
                        if(returnFreq.containsKey(Integer.parseInt(curTeacherId))){ //HASHMAP. USELESS, BUT CHECK JAVADOC
                            int newVal = returnFreq.get(Integer.parseInt(curTeacherId));
                            int next = newVal+1;
                            returnFreq.replace(Integer.parseInt(curTeacherId), next);
                        }
                        else{
                            returnFreq.put(Integer.parseInt(curTeacherId), 1);
                        }
                    }
                }
                
                
            }

            return returnFreq;

            
            
        }
    

    }
 

  
    public static HashSet<Integer> cleanTeacherData() throws FileNotFoundException, IOException{

        HashMap<Integer, Integer> x = new HashMap<Integer, Integer>(); //hashset 
        HashSet<Integer> applicableTeachers = new HashSet<>();
        int numTeachers = 0;  // tracker of numStudents

        try (BufferedReader br = new BufferedReader(new FileReader("data/TeacherActivityOctober18.csv"))) { // FELLAS, CHANGE YOUR FILENAME, AND ADD CORRECT PATH. 
            String line;
            line = br.readLine(); //SKIP THE FIRST LINE BC ITS THE HEADERS/USELESS
            while((line = br.readLine()) != null){ //KEEP ON READING LINES
                
                ArrayList<String> record = new ArrayList<String>(Arrays.asList(line.split(","))); //SPLIT ON COMMAS. GET ARRAYLIST OF ELEMENTS IN A ROW
                String curTeacherId = record.get(1);   //GET PARTICULAR ELEMENT AT ?,IMPORTANT,.....
                
                if(x.containsKey(Integer.parseInt(curTeacherId))){ //HASHMAP. USELESS, BUT CHECK JAVADOC
                    int newVal = x.get(Integer.parseInt(curTeacherId));
                    int next = newVal+1;
                    x.replace(Integer.parseInt(curTeacherId), next);
                }
                else{
                    x.put(Integer.parseInt(curTeacherId), 1);
                }
                
                
            }

            for(HashMap.Entry<Integer, Integer> entry : x.entrySet()){
                if(entry.getValue() > 10){
                    numTeachers += 1; 
                    applicableTeachers.add(entry.getKey());
                }
            }

            
            
        }
        
        for (Map.Entry<Integer, Integer> entry : x.entrySet()) {
            if(entry.getValue() > 10){
                StringBuilder sb = new StringBuilder(); //FOR DEBUGGING
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                sb.append('&');
                sb.deleteCharAt(sb.length() - 1);
                String result = sb.toString();
                applicableTeachers.add(entry.getKey());
        
                System.out.println(result);

            }

        }
        return applicableTeachers;

        


    }






}

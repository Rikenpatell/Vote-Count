import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class VoteCounter {

    public void readVoteCount(){
        try {
            Scanner sc = new Scanner(new File("dataset/Wiki-Vote.csv"));
            Map<String, Integer> map = new HashMap<>();
            List<String> users = new ArrayList<>();
            sc.next();
            while (sc.hasNext())
            {
                String line = sc.next();
                users.add(line.split(",")[1]);
            }
            for (String s : users) {
                if (map.keySet().contains(s))
                    map.put(s, map.get(s) + 1);
                else
                    map.put(s, 1);
            }
            writeVoteResult(map);
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }

    }

    private void writeVoteResult(Map<String, Integer> map) {
        File file = new File("dataset/Vote-Results.csv");
        try {
            FileWriter output = new FileWriter(file);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer val = entry.getValue();

                String line = key + "," + val+"\n";
                output.write(line);
            }
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SortAlg {

    VoteCounter counter = new VoteCounter();
    List<String> sortedData = new ArrayList<>();

    public static void main(String[] args) {

        SortAlg sortAlg = new SortAlg();
        sortAlg.readCount();
        sortAlg.sort();

        // Test get() method
        sortAlg.get(1);
        sortAlg.get(2);
        sortAlg.get(3);
        sortAlg.get(4);
        sortAlg.get(5);
        sortAlg.get(27);
        sortAlg.get(32);
        sortAlg.get(33);
        sortAlg.get(41);
        sortAlg.get(59);
    }
    public void readCount() {
        // Read Vote-Results.csv
        counter.readVoteCount();
    }

    public void sort() {
        // key part of the sorting algorithm
        // sort the records by VoteCount
        try {
            Scanner sc = new Scanner(new File("dataset/Vote-Results.csv"));
            Map<String, Integer> map = new HashMap<>();
            while (sc.hasNext())
            {
                String line = sc.next();
                map.put(line.split(",")[0], Integer.parseInt(line.split(",")[1]));
            }
            List<Integer> valueList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                valueList.add(entry.getValue());
            }

            /* Remove Comment Symbol ( // ) from the code to use sort() method */

            /**Bubble Sort Technique**/
            BubbleSort sort = new BubbleSort();
            /**Selection Sort Technique**/
//            SelectionSort sort = new SelectionSort();
            /**Insertion Sort Technique**/
//            InsertionSort sort = new InsertionSort();
            sortedData = sort.get(map, valueList);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void get(int rank) {
        String userId = "";
        String voteCount = "";
        for (String entry : sortedData) {
            if (entry.matches("(.*)#" + rank)) {
                userId = entry.split(",")[0];
                voteCount = entry.split(",")[1].split("#")[0];
                System.out.println("UserID " + userId + " is ranked at " + rank + " with " + voteCount + " votes");
            }
        }
    }
}
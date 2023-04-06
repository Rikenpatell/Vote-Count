import java.util.*;

/** Author Riken Patel **/

public class BubbleSort {

    public void bubbleSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr.get(j) < arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
    }

    public List<String> get(Map<String, Integer> map, List<Integer> valueList) {
        List<String> sortedData = new ArrayList<>();
        bubbleSort(valueList);
        List<Integer> rankList = uniqueList(valueList);
        for (Integer value : valueList) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (Objects.equals(value, entry.getValue())) {
                    int rank = rankList.indexOf(value) + 1;
                    if (!sortedData.contains(entry.getKey() + "," + value + "#" + rank))
                        sortedData.add(entry.getKey() + "," + value + "#" + rank);

                }

            }
        }
        return sortedData;
    }

    public List<Integer> uniqueList(List<Integer> valueList) {
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer value : valueList) {
            if (!uniqueList.contains((int) value))
                uniqueList.add(value);
        }
        return uniqueList;
    }

    static void printArray(List<Integer> list) {
        for (Integer i : list)
            System.out.print(i + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(12, 11, 13, 5, 6);

        BubbleSort ob = new BubbleSort();
        ob.bubbleSort(list);

        printArray(list);
    }
}

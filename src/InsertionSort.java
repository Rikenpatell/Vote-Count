import java.util.*;

public class InsertionSort {

    void sort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && key > arr.get(j)) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }

    public List<String> get(Map<String, Integer> map, List<Integer> valueList) {
        List<String> sortedData = new ArrayList<>();
        sort(valueList);
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

        InsertionSort ob = new InsertionSort();
        ob.sort(list);

        printArray(list);
    }
}

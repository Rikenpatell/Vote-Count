import java.util.*;

public class SelectionSort {

    void sort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr.get(j) > arr.get(min_idx))
                    min_idx = j;
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
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

        SelectionSort ob = new SelectionSort();
        ob.sort(list);

        printArray(list);
    }
}

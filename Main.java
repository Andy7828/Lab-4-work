import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        ArrayList<Integer> bubbleSortedList = new ArrayList<>(integerList);
        long bubbleStart = System.nanoTime();
        Lab4.bubbleSort(bubbleSortedList);
        long bubbleEnd = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nBubble sort runtime: " + (bubbleEnd - bubbleStart) + " ns");

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        ArrayList<Integer> insertionSortedList = new ArrayList<>(integerList);
        long insertionStart = System.nanoTime();
        Lab4.insertionSort(insertionSortedList);
        long insertionEnd = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.println("\nInsertion sort runtime: " + (insertionEnd - insertionStart) + " ns");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            int key = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j--;
            }
            integerList.set(j + 1, key);
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size() - 1; i++) {
            for (int j = 0; j < integerList.size() - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                }
            }
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
    }
}

/*
Answers to questions:

1. If you were implementing a sort algorithm for a new language, which sort would you use?
   - I would use an optimized algorithm like quicksort or mergesort for general purposes since they have better average-case time complexity (O(n log n)) compared to bubble and insertion sort (O(n^2)).

2. Was there a difference in the time it took for bubble and insertion sort to run? Does this make sense given the time complexities for these sorting algorithms?
   - Yes, there is typically a difference. Insertion sort generally performs better than bubble sort on average because it does fewer swaps, even though both have the same worst-case time complexity (O(n^2)). This aligns with their theoretical efficiencies.

3. Which sort algorithm has an easier implementation (in terms of understanding) to you?
   - Bubble sort is easier to understand and implement because it follows a simple "compare and swap" pattern. However, insertion sort is not much harder and is more efficient for small or partially sorted datasets.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    LinkedList<Integer> queue = new LinkedList<>();
    PriorityQueue<Integer> findMax = new PriorityQueue<>();
    ArrayList<Integer> result = new ArrayList<>();

    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(input.readLine());
        String[] secondLine = input.readLine().split(" ");
        int m = Integer.parseInt(input.readLine());

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(secondLine[i]);
        }
        int currentMax = array[0];
        int indexMax = 0;
        queue.addLast(array[0]);
        if (m == 1) {
            for (int temp : array) {
                System.out.print(temp + " ");
            }
        }

        else {

            for (int i = 1; i < m; i++) {
                queue.addLast(array[i]);
                if (array[i] >= currentMax) {
                    currentMax = array[i];
                    indexMax = i;
                }
            }
            result.add(currentMax);

            for (int i = m; i < n; i++) {
                queue.removeFirst();
                queue.addLast(array[i]);
                indexMax--;
                if (indexMax >= 0) {
                    if (array[i] >= currentMax) {
                        currentMax = array[i];
                        indexMax = m - 1;
                        result.add(currentMax);
                    } else {
                        result.add(currentMax);
                    }


                } else {
                    currentMax = queue.getFirst();
                    indexMax = 0;
                    for (int j = 1; j < queue.size(); j++) {
                        int currentQueue = queue.get(j);
                        if (currentQueue >= currentMax) {
                            currentMax = currentQueue;
                            indexMax = j;
                        }
                    }
                    result.add(currentMax);
                }
            }
        }

        result.forEach(r -> System.out.print(r + " "));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickFind {
    public static void main(String[] args) {
        int n;
        try (BufferedReader reader = new BufferedReader(new FileReader("graph.txt"))) {
            n = Integer.parseInt(reader.readLine());
            int[] graph = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = i;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int a = Integer.parseInt(data[0]);
                int b = Integer.parseInt(data[1]);
                if (a >= n || b >= n) {
                    throw new IllegalArgumentException("Invalid graph data.");
                }
                if (graph[a] != graph[b]) {
                    if (a > b) {
                        int tmp = a;
                        a = b;
                        b = tmp;
                    }
                    System.out.println("(" + a + ", " + b + ")");
                    int graphElem = graph[b];
                    for (int i = 0; i < n; i++) {
                        if (graph[i] == graphElem) graph[i] = graph[a];
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
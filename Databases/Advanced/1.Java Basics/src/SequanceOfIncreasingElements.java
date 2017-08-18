    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.stream.Stream;

    /**
     * Created by Rostislav Kolev on 02-Jul-17.
     */
    public class SequanceOfIncreasingElements {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] sequence = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int longestLength = 1;
            int startIndex = 0;

            for (int i = 0; i < sequence.length - 1; i++) {
                int currentLength = 1;

                for (int j = i + 1; j < sequence.length; j++) {
                    int current = sequence[j];
                    int prev = sequence[j-1];
                    if (prev < current) {
                        currentLength++;
                    } else {
                        break;
                    }
                }

                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    startIndex = i;
                }
            }

            for (int i = startIndex; i < startIndex + longestLength; i++) {
                System.out.print(sequence[i] + " ");
            }
        }
    }
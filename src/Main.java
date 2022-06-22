import java.io.*;

import org.javatuples.Pair;
public class Main {
    final static int INITIAL_POS = 10630;
    final static int NUM_STEPS = 20;
    private static Space scrapeInput(String filename) throws IOException {
        Space space = new Space();
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            Pair<Integer, Integer> position = Pair.with(Integer.parseInt(line.split(">")[0]
                            .split("<")[1]
                            .split(", ")[0]
                            .replace(" ", "")),
                    Integer.parseInt(line.split(">")[0]
                            .split("<")[1]
                            .split(", ")[1]
                            .replace(" ", "")));
            Pair<Integer, Integer> velocity = Pair.with(Integer.parseInt(line.split(">")[1]
                            .split("<")[1]
                            .split(", ")[0]
                            .replace(" ", "")),
                    Integer.parseInt(line.split(">")[1]
                            .split("<")[1]
                            .split(", ")[1]
                            .replace(" ", "")));
            space.addLightSource(position, velocity);
        }
        return space;
    }
    public static void main(String[] args) throws IOException {
        Space space = scrapeInput("input");
        space.move_many_steps(INITIAL_POS);
        for (int i = 0; i < NUM_STEPS; i++) {
            space.move_one_step();
            space.offsetPositionsToZero();
            space.saveAsImage(i + INITIAL_POS);
        }
    }
}

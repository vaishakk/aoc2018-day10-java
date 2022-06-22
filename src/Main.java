import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.javatuples.Pair;
public class Main {
    public static void main(String[] args) throws Exception
    {
        Space space = new Space();
        File file = new File(
                "sample-input");
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
        space.offsetPositionsToZero();
        space.move_many_steps(2);
        space.offsetPositionsToZero();
        //space.showPositions();
        space.saveAsImage();

    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.javatuples.Pair;
public class Main {
    public static void main(String[] args) throws Exception
    {
        Space space = new Space();
        File file = new File(
                "input");
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
        space.move_many_steps(10630);
        space.offsetPositionsToZero();
        //space.displayPos();
        for (int i=0; i<20; i++) {
            space.move_one_step();
            space.offsetPositionsToZero();
            space.saveAsImage(i);
        }

    }
}

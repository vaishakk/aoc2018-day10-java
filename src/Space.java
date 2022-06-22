import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class Space {
    List<LightSource> lightSources;

    public Space(List<Pair<Integer, Integer>> positions, List<Pair<Integer, Integer>> velocities){
        this.lightSources = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++){
            this.lightSources.add(new LightSource(positions.get(i), velocities.get(i)));
        }

    }

    public void move_one_step(){
        for (LightSource lightSource : this.lightSources) {
            lightSource.move_one_step();
        }
    }

    public void move_many_steps(int steps){
        for (LightSource lightSource : this.lightSources) {
            lightSource.move_many_steps(steps);
        }
    }
}

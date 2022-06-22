import org.javatuples.Pair;

public class LightSource {
    Pair <Integer, Integer> position;

    public LightSource(int x, int y){
        this.position = Pair.with(x, y);
    }

    public Pair<Integer, Integer> getPosition(){
        return this.position;
    }
}

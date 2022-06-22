import org.javatuples.Pair;

public class LightSource {
    Pair <Integer, Integer> position;
    Pair <Integer, Integer> velocity;
    public LightSource(int x, int y, int vx, int vy){
        this.position = Pair.with(x, y);
        this.velocity = Pair.with(vx, vy);
    }

    public Pair<Integer, Integer> getPosition(){
        return this.position;
    }

    public Pair<Integer, Integer> getVelocity(){
        return this.velocity;
    }
}

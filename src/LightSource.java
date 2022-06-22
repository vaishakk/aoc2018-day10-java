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

    public void move_one_step(){
        this.position = Pair.with(this.position.getValue0() * this.velocity.getValue0(),
                this.position.getValue1() * this.velocity.getValue1()) ;
    }

    public void move_many_steps(int steps){
        this.position = Pair.with(this.position.getValue0() * steps * this.velocity.getValue0(),
                this.position.getValue1() * steps * this.velocity.getValue1()) ;
    }
}

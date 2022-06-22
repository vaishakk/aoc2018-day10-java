import org.javatuples.Pair;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Space {
    List<LightSource> lightSources;

    public Space(List<Pair<Integer, Integer>> positions, List<Pair<Integer, Integer>> velocities){
        this.lightSources = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++){
            this.lightSources.add(new LightSource(positions.get(i), velocities.get(i)));
        }

    }

    public Space() {
        this.lightSources = new ArrayList<>();
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

    private Pair<Integer, Integer> getMaxPosition(){
        int maxX = this.lightSources.get(0).getPosition().getValue0();
        int maxY = this.lightSources.get(0).getPosition().getValue1();
        for (LightSource lightSource : this.lightSources){
            if (lightSource.getPosition().getValue0() > maxX){
                maxX = lightSource.getPosition().getValue0();
            }
            if (lightSource.getPosition().getValue1() > maxY){
                maxY = lightSource.getPosition().getValue1();
            }
        }
        return Pair.with(maxX, maxY);
    }

    private Pair<Integer, Integer> getMinPosition(){
        int minX = this.lightSources.get(0).getPosition().getValue0();
        int minY = this.lightSources.get(0).getPosition().getValue1();
        for (LightSource lightSource : this.lightSources){
            if (lightSource.getPosition().getValue0() < minX){
                minX = lightSource.getPosition().getValue0();
            }
            if (lightSource.getPosition().getValue1() < minY){
                minY = lightSource.getPosition().getValue1();
            }
        }
        return Pair.with(minX, minY);
    }

    public void offsetPositionsToZero(){
        Pair<Integer, Integer> minPosition = this.getMinPosition();
        for (LightSource lightSource : this.lightSources){
            lightSource.offsetPosition(minPosition);
        }
    }

    public void saveAsImage() throws IOException {
        Pair<Integer, Integer> maxPos = this.getMaxPosition();
        System.out.println(maxPos);
        int maxX = maxPos.getValue0();
        int maxY = maxPos.getValue1();
        BufferedImage theImage = new BufferedImage(maxY + 1, maxX + 1, BufferedImage.TYPE_INT_RGB);
        for (LightSource lightSource : this.lightSources){
            theImage.setRGB(lightSource.getPosition().getValue1(),
                    lightSource.getPosition().getValue0(),
                    255);
        }
        File outputfile = new File("image.jpg");
        ImageIO.write(theImage, "jpg", outputfile);
    }

    public void showPositions(){
        for (LightSource lightSource : this.lightSources){
            System.out.println(lightSource.getPosition());
        }
    }

    public void addLightSource(Pair<Integer, Integer> position, Pair<Integer, Integer> velocity) {
        this.lightSources.add(new LightSource(position, velocity));
    }
}

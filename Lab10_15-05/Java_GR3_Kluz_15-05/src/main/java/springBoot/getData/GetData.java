package springBoot.getData;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import springBoot.data.Data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GetData {
    public static Map<Integer, Data> pictures;


    static {
        pictures = new HashMap<Integer, Data>() {
            {
                put(1, new Data(1, "Boston-Celtics.jpg", image("Boston-Celtics.jpg").getWidth(), image("Boston-Celtics.jpg").getHeight(), 12345));
                put(2, new Data(2, "lebron-flexing.jpg", image("Boston-Celtics.jpg").getWidth(), image("Boston-Celtics.jpg").getHeight(), 12345));
            }

        };
    }

    static public BufferedImage image(String fileName){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\Patryk\\Desktop\\Java_GR3_Kluz_15-05\\src\\main\\resources\\images\\"+fileName));
        } catch (IOException e) {
        }
        return img;
    }

    public Collection<Data> getAllPictures() {
        return this.pictures.values();
    }

    public Data getPictureById(int id) {
        return this.pictures.get(id);
    }

    public void removePictureById(int id) {
            this.pictures.remove(id);
    }
}

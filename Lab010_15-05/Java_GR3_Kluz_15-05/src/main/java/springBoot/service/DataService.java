package springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.data.Data;
import springBoot.getData.GetData;

import java.io.IOException;
import java.util.Collection;

@Service
public class DataService {
    @Autowired
    public GetData getData;

    public Collection<Data> getAllPictures(){
        return this.getData.getAllPictures();
    }

    public Data getPictureById(int id) {
        return this.getData.getPictureById(id);
    }

    public void removePictureById(int id) {
        this.getData.removePictureById(id);
    }
}

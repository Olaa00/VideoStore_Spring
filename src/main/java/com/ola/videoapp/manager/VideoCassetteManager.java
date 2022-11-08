package com.ola.videoapp.manager;
import com.ola.videoapp.dao.entity.VideoCass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ola.videoapp.dao.VideoCassRepo;

import java.util.Optional;

@Service
public class VideoCassetteManager {
    private VideoCassRepo videoCassRepo; //zmienna przechowywujaca info o repo

    @Autowired
    public VideoCassetteManager(VideoCassRepo videoCassRepo) {
        this.videoCassRepo = videoCassRepo;  //konstruktor za pomoca kotego wstrzykuje instacje klasy VideoCassRepo
    }

    public Optional<VideoCass> findById (Long id) {  //metoda zwraca info na temat okreslonego viedo przez dostarczone id
      return videoCassRepo.findById(id);
    }

    public Iterable<VideoCass> findAll(Long id){
        return videoCassRepo.findAll();
    }
    public VideoCass save(VideoCass videoCass){ //zwraca zapisany element
        return videoCassRepo.save(videoCass);
    }
    public void deleteById(Long id){  //usuwa element po id
        videoCassRepo.deleteById(id);
    }

}

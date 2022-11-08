package com.ola.videoapp.manager;
import com.ola.videoapp.dao.entity.VideoCass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import com.ola.videoapp.dao.VideoCassRepo;

import java.time.LocalDate;
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

    public Iterable<VideoCass> findAll(){
        return videoCassRepo.findAll();
    }
    public VideoCass save(VideoCass videoCass){ //zwraca zapisany element
        return videoCassRepo.save(videoCass);
    }
    public void deleteById(Long id){  //usuwa element po id
        videoCassRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCass(1l, "Maveric", LocalDate.of(1980, 5, 2)));
        save(new VideoCass(1l, "Maveric", LocalDate.of(1980, 5, 2)));
        save(new VideoCass(2l, "Disney+", LocalDate.of(2000, 2, 18)));
        save(new VideoCass(3L, "Nowy Pop", LocalDate.of(2018,9,2)));
    }

}

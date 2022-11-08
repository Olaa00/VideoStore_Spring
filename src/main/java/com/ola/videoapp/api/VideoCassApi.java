package com.ola.videoapp.api;

import com.ola.videoapp.dao.VideoCassRepo;
import com.ola.videoapp.dao.entity.VideoCass;
import com.ola.videoapp.manager.VideoCassetteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Locale.filter;

@RestController
@RequestMapping("api/cassetts")
public class VideoCassApi {


    //ZASTAPIENIE BAZA DANCYH
//    private List<VideoCass> videoCassetes;
//
//    public VideoCassApi() {
//        videoCassetes = new ArrayList<>();
//        videoCassetes.add(new VideoCass(1l, "Maveric", LocalDate.of(1980, 5, 2)));
//        videoCassetes.add(new VideoCass(2l, "Disney+", LocalDate.of(2000, 2, 18)));
//        videoCassetes.add(new VideoCass(3L, "Nowy Pop", LocalDate.of(2018,9,2)));
//    }

    private VideoCassetteManager videoCassetes; //instancja klasy menagera
    @Autowired
    public VideoCassApi(VideoCassetteManager videoCassetes) {
        this.videoCassetes = videoCassetes;
    }

    @GetMapping("/all")
    public Iterable<VideoCass> getAll() {
        return videoCassetes.findAll();
    }
//   @GetMapping
//    public VideoCass getById(@RequestParam int index) //po idnexie podanym przez uzytkownika
//   {
//       Optional<VideoCass> first = videoCassetes.stream(). //przeszukuje wszytskie elementy
//       filter(element -> element.getId() == index).findFirst(); //weryfikacja czy id ma taki nr jaki podal index uzytkownik
//       return first.get(); //jesli jest to wyciagam i zwracam
//}

    @GetMapping
    public Optional<VideoCass> getById (@RequestParam Long index) {
        return videoCassetes.findById(index);
    }

    @PostMapping
//    public boolean addVideo (@RequestBody VideoCass videoCass){ //dodanie video i zwrocenie
//        return videoCassetes.add(videoCass);
//    }
    public VideoCass addVideo(@RequestBody VideoCass videoCass){
        return videoCassetes.save(videoCass);
    }
    @PutMapping
//    public boolean updateVideo (@RequestBody VideoCass videoCass){ //zmiana wartosci po id
//        return videoCassetes.add(videoCass);
//    }
    public VideoCass updateVideo(@RequestBody VideoCass videoCass){
        return videoCassetes.save(videoCass);
    }
    @DeleteMapping
//    public boolean deleteVideo (@RequestParam int index){ //usuniecie jesli id = index
//        return videoCassetes.removeIf(element -> element.getId() == index);
//    }
    public void deleteVideo(@RequestParam Long index){
        videoCassetes.deleteById(index);
    }
}


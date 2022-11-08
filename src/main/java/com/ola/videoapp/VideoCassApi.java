package com.ola.videoapp;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Locale.filter;

@RestController
@RequestMapping("api/cassetts")
public class VideoCassApi {
    private List<VideoCass> videoCassetes;

    public VideoCassApi() {
        videoCassetes = new ArrayList<>();
        videoCassetes.add(new VideoCass(1l, "Maveric", LocalDate.of(1980, 5, 2)));
        videoCassetes.add(new VideoCass(2l, "Disney+", LocalDate.of(2000, 2, 18)));
        videoCassetes.add(new VideoCass(3L, "Nowy Pop", LocalDate.of(2018,9,2)));
    }

    @GetMapping("/all")
    public List<VideoCass> getAll() {
        return videoCassetes;
    }
   @GetMapping
    public VideoCass getById(@RequestParam int index) //po idnexie podanym przez uzytkownika
   {
       Optional<VideoCass> first = videoCassetes.stream(). //przeszukuje wszytskie elementy
       filter(element -> element.getId() == index).findFirst(); //weryfikacja czy id ma taki nr jaki podal index uzytkownik
       return first.get(); //jesli jest to wyciagam i zwracam
}
    @PostMapping
    public boolean addVideo (@RequestBody VideoCass videoCass){ //dodanie video i zwrocenie
        return videoCassetes.add(videoCass);
    }
    @PutMapping
    public boolean updateVideo (@RequestBody VideoCass videoCass){ //zmiana wartosci po id
        return videoCassetes.add(videoCass);
    }
    @DeleteMapping
    public boolean deleteVideo (@RequestParam int index){ //usuniecie jesli id = index
        return videoCassetes.removeIf(element -> element.getId() == index);
    }
}


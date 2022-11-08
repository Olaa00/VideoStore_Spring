package com.ola.videoapp.dao;

import com.ola.videoapp.dao.entity.VideoCass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCassRepo extends CrudRepository <VideoCass, Long> {
}

package com.stationeries.song_spec.repository;

import com.stationeries.song_spec.model.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

//    @Test
//    public void saveAndRetrieveSong_shouldPersistAndFetch() {
//        Song song = new Song();
//        song.setTitle("Test Song");
//        song.setArtist("Test Artist");
//        song.setAlbum("Test Album");
//        song.setYear(2024);
//
//        songRepository.save(song);
//        List<Song> songs = songRepository.findAll();
//
//        assertEquals(1, songs.size());
//        assertEquals("Test Song", songs.getFirst().getTitle());
//    }
}
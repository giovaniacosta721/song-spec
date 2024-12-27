package com.stationeries.song_spec.service;

import com.stationeries.song_spec.dto.SongDTO;
import com.stationeries.song_spec.model.Song;
import com.stationeries.song_spec.repository.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SongServiceTest {

    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private SongService songService;

    @Test
    public void getAllSongs_shouldReturnListOfSongDTOs() {
        Song song1 = new Song();
        song1.setId(1L);
        song1.setTitle("Song One");
        song1.setArtist("Artist One");
        song1.setAlbum("Album One");
        song1.setYear(2023);

        Song song2 = new Song();
        song2.setId(2L);
        song2.setTitle("Song Two");
        song2.setArtist("Artist Two");
        song2.setAlbum("Album Two");
        song2.setYear(2022);

        when(songRepository.findAll()).thenReturn(List.of(song1, song2));

        List<SongDTO> songs = songService.getAllSongs();

        assertEquals(2, songs.size());
        assertEquals("Song One", songs.get(0).getTitle());
        assertEquals("Artist Two", songs.get(1).getArtist());
    }

    @Test
    public void addSong_shouldSaveAndReturnSongDTO() {
        Song song = new Song();
        song.setTitle("New Song");
        song.setArtist("New Artist");
        song.setAlbum("New Album");
        song.setYear(2024);

        SongDTO songDTO = new SongDTO();
        songDTO.setTitle("New Song");
        songDTO.setArtist("New Artist");
        songDTO.setAlbum("New Album");
        songDTO.setYear(2024);

        when(songRepository.save(any(Song.class))).thenAnswer(i -> i.getArguments()[0]);

        SongDTO result = songService.addSong(songDTO);

        assertNotNull(result);
        assertEquals("New Song", result.getTitle());
        assertEquals("New Artist", result.getArtist());
    }
}
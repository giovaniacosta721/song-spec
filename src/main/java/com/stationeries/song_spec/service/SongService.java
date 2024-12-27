package com.stationeries.song_spec.service;

import com.stationeries.song_spec.dto.SongDTO;
import com.stationeries.song_spec.model.Song;
import com.stationeries.song_spec.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<SongDTO> getAllSongs() {
        return songRepository.findAll().stream()
                .map(SongDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public SongDTO addSong(SongDTO songDTO) {
        Song song = songDTO.toEntity();
        songRepository.save(song);
        return SongDTO.fromEntity(song);
    }
}
package com.stationeries.song_spec.controller;

import com.stationeries.song_spec.dto.SongDTO;
import com.stationeries.song_spec.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<SongDTO> getAllSongs() {
        return songService.getAllSongs();
    }

    @PostMapping
    public ResponseEntity<SongDTO> addSong(@RequestBody SongDTO songDTO) {
        return new ResponseEntity<>(songService.addSong(songDTO), HttpStatus.CREATED);
    }
}
package com.stationeries.song_spec.dto;

import com.stationeries.song_spec.model.Song;
import lombok.Data;

@Data
public class SongDTO {

    private String title;
    private String artist;
    private String album;
    private int year;

    public static SongDTO fromEntity(Song song) {
        SongDTO dto = new SongDTO();
        dto.setTitle(song.getTitle());
        dto.setArtist(song.getArtist());
        dto.setAlbum(song.getAlbum());
        dto.setYear(song.getYear());
        return dto;
    }

    public Song toEntity() {
        Song song = new Song();
        song.setTitle(this.title);
        song.setArtist(this.artist);
        song.setAlbum(this.album);
        song.setYear(this.year);
        return song;
    }
}
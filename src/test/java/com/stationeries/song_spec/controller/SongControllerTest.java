package com.stationeries.song_spec.controller;

import com.stationeries.song_spec.dto.SongDTO;
import com.stationeries.song_spec.security.SecurityConfig;
import com.stationeries.song_spec.service.SongService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(SongController.class)
@WithMockUser()
@Import(SecurityConfig.class)
public class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private SongService songService;

    @Test
    public void getAllSongs_shouldReturnListOfSongs() throws Exception {

        SongDTO song1 = new SongDTO();
        song1.setTitle("Song One");
        song1.setArtist("Artist One");

        SongDTO song2 = new SongDTO();
        song2.setTitle("Song Two");
        song2.setArtist("Artist Two");

        when(songService.getAllSongs()).thenReturn(List.of(song1, song2));

        mockMvc.perform(get("/songs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].title").value("Song One"))
                .andExpect(jsonPath("$[1].artist").value("Artist Two"));
    }

    @Test
    public void addSong_shouldCreateAndReturnSong() throws Exception {

        SongDTO songDTO = new SongDTO();
        songDTO.setTitle("New Song");
        songDTO.setArtist("New Artist");

        when(songService.addSong(any(SongDTO.class))).thenReturn(songDTO);

        mockMvc.perform(post("/songs")
                        .with(httpBasic("user","password"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"New Song\", \"artist\": \"New Artist\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Song"))
                .andExpect(jsonPath("$.artist").value("New Artist"));
    }


}
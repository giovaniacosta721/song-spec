package com.stationeries.song_spec.exception;

import com.stationeries.song_spec.controller.SongController;
import com.stationeries.song_spec.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SongController.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

  //  @Test
//    public void handleSongNotFoundException_shouldReturnNotFound() throws Exception {
//        when(songService.getAllSongs()).thenThrow(new SongNotFoundException("Song not found"));
//
//        mockMvc.perform(get("/songs"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Song not found"));
//    }
}

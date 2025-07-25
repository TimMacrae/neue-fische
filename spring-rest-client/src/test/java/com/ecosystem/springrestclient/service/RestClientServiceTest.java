package com.ecosystem.springrestclient.service;

import com.ecosystem.springrestclient.model.RUMCharacter;
import com.ecosystem.springrestclient.model.RUMCharacterApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RestClientServiceTest {

//    @Mock
//    private RestClient restClient;
//
//    @Mock
//    private RestClient.Builder restClientBuilder;
//
//    @InjectMocks
//    private RestClientService restClientService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        restClientService = new RestClientService(restClientBuilder);
//    }
//
//    @Test
//    void getCharacters_shouldReturnCharacters(){
//        RUMCharacter rumCharacter = new RUMCharacter("1", "Rick","Human");
//        RUMCharacterApiResponse response = new RUMCharacterApiResponse(List.of(rumCharacter));
//        Mockito.when(restClient.get().retrieve().body(RUMCharacterApiResponse.class)).thenReturn(response);
//
//        List<RUMCharacter> result = restClientService.getCharacters();
//
//        assertEquals(1, result.size());
//        assertEquals(response, result);
//    }

}
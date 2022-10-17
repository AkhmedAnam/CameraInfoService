package ru.ahmed.anam.camerasinfoservice;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.ahmed.anam.camerasinfoservice.domain.dto.CameraInfo;

public class CameraInfoControllerTest {

    @Test
    public void shouldReturnFourCameraInfo() {
        WebTestClient webTestClient = WebTestClient.bindToRouterFunction(new RouterFunctionConfig().routerFunction()).build();

        webTestClient.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CameraInfo.class)
                .hasSize(4);
    }

}

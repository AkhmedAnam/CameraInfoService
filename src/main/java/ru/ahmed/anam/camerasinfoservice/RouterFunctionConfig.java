package ru.ahmed.anam.camerasinfoservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.ahmed.anam.camerasinfoservice.domain.CameraInfoDTO;
import ru.ahmed.anam.camerasinfoservice.domain.CameraInfoResponse;
import ru.ahmed.anam.camerasinfoservice.domain.SourceDataInfo;
import ru.ahmed.anam.camerasinfoservice.domain.TokenDataInfo;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<?> routerFunction(){
        return route(GET("/"), this::getCamerasInfo);
    }

    @Bean
    public WebClient webClient(){
        return WebClient.create();
    }

    public Mono<ServerResponse> getCamerasInfo(ServerRequest serverRequest){
        Flux<CameraInfoDTO> cameraInfoFlux = webClient()
                .get()
                .uri("http://www.mocky.io/v2/5c51b9dd3400003252129fb5")
                .retrieve()
                .bodyToFlux(CameraInfoResponse.class)
                .flatMap(cameraInfoResponse -> {
                    Mono<SourceDataInfo> sourceDataInfoMono = webClient().get().uri(cameraInfoResponse.getSourceDataUrl()).retrieve().bodyToMono(SourceDataInfo.class);
                    Mono<TokenDataInfo> tokenDataInfoMono = webClient().get().uri(cameraInfoResponse.getTokenDataUrl()).retrieve().bodyToMono(TokenDataInfo.class);
                    Mono<CameraInfoDTO> map = sourceDataInfoMono.zipWith(tokenDataInfoMono).map(objects -> {
                        TokenDataInfo t2 = objects.getT2();
                        SourceDataInfo t1 = objects.getT1();
                        return CameraInfoDTO.create(cameraInfoResponse.getId(), t1, t2);
                    });
                    return map.subscribeOn(Schedulers.parallel());
                });
        return ok().body(cameraInfoFlux, CameraInfoDTO.class);
    }

}

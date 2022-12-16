package br.com.victation.gateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


//	@Bean
//	public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory(CircuitBreakerRegistry circuitBreakerRegistry) {
//		ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory = new ReactiveResilience4JCircuitBreakerFactory();
//		reactiveResilience4JCircuitBreakerFactory.configureCircuitBreakerRegistry(circuitBreakerRegistry);
//		return reactiveResilience4JCircuitBreakerFactory;
//	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(p -> p.path("/catalogo/**")
						.filters(f -> f.circuitBreaker(
								config -> config.setName("mycmd2")
										.setFallbackUri("forward:/fallback")
						))
				.uri("http://localhost:8101"))
				.route(p ->
						p.path("/carros/**")
								.filters(f -> f.circuitBreaker(
										config -> config.setName("mycmd")
												.setFallbackUri("forward:/fallback")
								))
						.uri("http://localhost:8100"))
				.build();
	}

	@GetMapping("/fallback")
    public  String  fallback(){
		return "Sinto muito, tente is tarde";
	}

}

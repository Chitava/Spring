package ru.chitava.getawey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GetaweyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetaweyApplication.class, args);
	}

	/**
	 * Параметры маршрутизатора
	 * @param builder возращает маршрутную карту для сервера и клиента
	 * @return
	 */
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("webserver",r->r.path("/server/**")
						.uri("http://localhost:4001/"))
				.route("webclient",r->r.path("/client/**")
						.uri("http://localhost:4002/")).build();}
}

package br.com.fiap.techchallenge.quickserveapi.infra.config;

import br.com.fiap.techchallenge.quickserveapi.domain.ports.*;
import br.com.fiap.techchallenge.quickserveapi.domain.service.CustomerServiceImpl;
import br.com.fiap.techchallenge.quickserveapi.domain.service.OrderServiceImpl;
import br.com.fiap.techchallenge.quickserveapi.domain.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CustomerServicePort customerService(CustomerRepositoryPort customerRepositoryPort){
        return new CustomerServiceImpl(customerRepositoryPort);
    }
    @Bean
    ProductServicePort productService(ProductRepositoryPort productRepositoryPort){
        return new ProductServiceImpl(productRepositoryPort);
    }

    @Bean
    OrderServicePort orderService(OrderRepositoryPort orderRepositoryPort, ProductRepositoryPort productRepositoryPort){
        return new OrderServiceImpl(orderRepositoryPort, productRepositoryPort);
    }

}

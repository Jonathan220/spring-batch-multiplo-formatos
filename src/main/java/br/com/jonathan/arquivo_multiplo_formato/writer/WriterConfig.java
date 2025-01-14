package br.com.jonathan.arquivo_multiplo_formato.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @Bean
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ItemWriter writer(){
        return items -> items.forEach(System.out::println);
    }
}

package br.com.jonathan.arquivo_multiplo_formato.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ReaderConfig {

    @Value("${spring.batch.endereco}")
    private String endereco;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FlatFileItemReader reader(LineMapper lineMapper){
        return new FlatFileItemReaderBuilder<>()
        .name("clienteTransacaoReader")
        .resource(new FileSystemResource(endereco))
        .lineMapper(lineMapper)
        .build();
    }
}

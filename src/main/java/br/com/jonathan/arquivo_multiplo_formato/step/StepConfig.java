package br.com.jonathan.arquivo_multiplo_formato.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jonathan.arquivo_multiplo_formato.reader.ArquivoClienteTransacaoReader;



@Configuration
public class StepConfig {
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Step clienteTransacaoStep(FlatFileItemReader reader, ItemWriter write){
        return stepBuilderFactory
        .get("clienteTransacaoStep")
        .chunk(1)
        .reader(new ArquivoClienteTransacaoReader(reader))
        .writer(write)
        .build();
    }

}

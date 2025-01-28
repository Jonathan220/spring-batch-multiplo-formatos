package br.com.jonathan.arquivo_multiplo_formato.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jonathan.arquivo_multiplo_formato.entities.Cliente;



@Configuration
public class StepConfig {
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Step clienteTransacaoStep(MultiResourceItemReader<Cliente>  multiplosArquivosClienteTransacaoReader, ItemWriter write){
        return stepBuilderFactory
        .get("clienteTransacaoStep")
        .chunk(1)
        .reader(multiplosArquivosClienteTransacaoReader)
        .writer(write)
        .build();
    }

}

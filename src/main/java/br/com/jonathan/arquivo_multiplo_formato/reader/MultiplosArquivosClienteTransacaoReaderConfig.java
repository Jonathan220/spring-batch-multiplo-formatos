package br.com.jonathan.arquivo_multiplo_formato.reader;

import java.io.File;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
public class MultiplosArquivosClienteTransacaoReaderConfig {

    @Value("${spring.batch.endereco}")
    private String endereco;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public MultiResourceItemReader multiplosArquivosClienteTransacaoReader( FlatFileItemReader leituraArquivoMultiplosFormatosReader){
        Resource[] arquivosClientes = getFiles(endereco);

        return new MultiResourceItemReaderBuilder<>()
        .name("multiplosArquivosClienteTransacaoReader")
        .resources(arquivosClientes)
        .delegate(new ArquivoClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
        .build();

    }

    private Resource[] getFiles(String endereco) {

        File path = new File(endereco);
        File[] files = path.listFiles();

        Resource[] arquivosClientes = new Resource[files.length];

        for (int i = 0; i < files.length; i++){
            arquivosClientes[i] = new FileSystemResource(files[i]);
        }

        return arquivosClientes;
    }
}

package br.com.jonathan.arquivo_multiplo_formato.reader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jonathan.arquivo_multiplo_formato.entities.Cliente;
import br.com.jonathan.arquivo_multiplo_formato.entities.Transacao;

@Configuration
public class ClienteTransacaoLineMapperConfig {
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public PatternMatchingCompositeLineMapper lineMapper(){
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fieldSetMappers());
        return lineMapper;

    }

    private Map<String, LineTokenizer> tokenizers() {
        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put("0*", clienteLineTokenizers());
        tokenizers.put("1*", transacaoLineTokenizer());
        return tokenizers;
    }

    private LineTokenizer clienteLineTokenizers(){
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        lineTokenizer.setIncludedFields(1, 2, 3, 4);
        return lineTokenizer;
    }

    private LineTokenizer transacaoLineTokenizer(){
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "descricao", "valor");
        lineTokenizer.setIncludedFields(1, 2, 3);
        return lineTokenizer;
    }

    @SuppressWarnings("rawtypes")
    private Map fieldSetMappers(){
        Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
        fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));
        fieldSetMappers.put("1*", fieldSetMapper(Transacao.class));
        return fieldSetMappers;

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private FieldSetMapper fieldSetMapper(Class classe){
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(classe);
        return fieldSetMapper;
    }

}

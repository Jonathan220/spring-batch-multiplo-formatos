package br.com.jonathan.arquivo_multiplo_formato.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

import br.com.jonathan.arquivo_multiplo_formato.entities.Cliente;
import br.com.jonathan.arquivo_multiplo_formato.entities.Transacao;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente>, ResourceAwareItemReaderItemStream<Cliente> {

    private Object objetoAtual;
    private FlatFileItemReader<Object> delegate;

    public ArquivoClienteTransacaoReader(FlatFileItemReader<Object> delegate){
        this.delegate = delegate;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public Cliente read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(objetoAtual == null)
            objetoAtual = delegate.read();

        Cliente cliente = (Cliente) objetoAtual;
        objetoAtual = null;

        if(cliente != null){
            while (peek() instanceof Transacao) {
                cliente.getTransacaos().add((Transacao) objetoAtual);
            }
        }
        return cliente;
    }

    private Object peek() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception{
        objetoAtual = delegate.read();
        return objetoAtual;
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }

}

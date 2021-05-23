package br.com.lelecoder.forumdynamodb.config;

import br.com.lelecoder.forumdynamodb.adapter.persistence.TopicoPortAdapter;
import br.com.lelecoder.forumdynamodb.adapter.persistence.mapper.TopicoMapper;
import br.com.lelecoder.forumdynamodb.core.ports.in.BuscarRespostaSolucionadora;
import br.com.lelecoder.forumdynamodb.core.ports.out.TopicoPort;
import br.com.lelecoder.forumdynamodb.core.usecases.BuscarRespostaSolucionadoraImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Configuration
public class BeanCreator {

    @Bean
    TopicoPort topicoPort(DynamoDbEnhancedClient dbEnhancedClient, TopicoMapper topicoMapper) {
        return new TopicoPortAdapter(dbEnhancedClient, topicoMapper);
    }

    @Bean
    BuscarRespostaSolucionadora buscarRespostaSolucionadora(TopicoPort topicoPort) {
        return new BuscarRespostaSolucionadoraImpl(topicoPort);
    }
}

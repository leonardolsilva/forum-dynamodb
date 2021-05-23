package br.com.lelecoder.forumdynamodb.adapter.persistence;

import br.com.lelecoder.forumdynamodb.adapter.persistence.mapper.TopicoMapper;
import br.com.lelecoder.forumdynamodb.adapter.persistence.model.TopicoModel;
import br.com.lelecoder.forumdynamodb.core.domain.Topico;
import br.com.lelecoder.forumdynamodb.core.ports.out.TopicoPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import java.util.Optional;

@Slf4j
@Repository
public class TopicoPortAdapter implements TopicoPort {

    private static final String NOME_TABELA = "forum_table";
    private final DynamoDbEnhancedClient dbEnhancedClient;
    private final TopicoMapper mapper;

    public TopicoPortAdapter(DynamoDbEnhancedClient dbEnhancedClient, TopicoMapper mapper) {
        this.dbEnhancedClient = dbEnhancedClient;
        this.mapper = mapper;
    }

    @Override
    public Optional<Topico> buscar(String idTopico) {

        DynamoDbTable<TopicoModel> mappedTable = dbEnhancedClient.table(NOME_TABELA, TableSchema.fromBean(TopicoModel.class));

        Key key = Key
                .builder()
                .partitionValue(idTopico)
                .sortValue("SOLUCIONADO")
                .build();

        try {
            Optional<TopicoModel> optionalTopicoModel = Optional.ofNullable(mappedTable.getItem(key));

            return optionalTopicoModel
                    .map(mapper::paraDominio);

        } catch (DynamoDbException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}

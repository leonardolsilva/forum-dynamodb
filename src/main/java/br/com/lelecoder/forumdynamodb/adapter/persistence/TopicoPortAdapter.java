package br.com.lelecoder.forumdynamodb.adapter.persistence;

import br.com.lelecoder.forumdynamodb.adapter.persistence.mapper.TopicoMapper;
import br.com.lelecoder.forumdynamodb.adapter.persistence.model.TopicoModel;
import br.com.lelecoder.forumdynamodb.core.domain.Topico;
import br.com.lelecoder.forumdynamodb.core.ports.out.TopicoPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class TopicoPortAdapter implements TopicoPort {

    private static final String NOME_TABELA = "forum_table";
    private static final String INDEX_NAME = "TopicosPorCategoriaIndex";
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

    @Override
    public List<Topico> topicosPorCategoria(String idTopico, String categoria) {

        DynamoDbTable<TopicoModel> mappedTable = dbEnhancedClient.table(NOME_TABELA, TableSchema.fromBean(TopicoModel.class));

        DynamoDbIndex<TopicoModel> mappedIndex = mappedTable.index(INDEX_NAME);

        Key key = Key.builder()
                .partitionValue(idTopico)
                .sortValue(categoria)
                .build();

        QueryConditional query = QueryConditional.keyEqualTo(key);

        Iterator<Page<TopicoModel>> result = mappedIndex.query(query).iterator();

        List<TopicoModel> topicoModels = new ArrayList<>();

        while (result.hasNext()) {
            Page<TopicoModel> topicoModelItems = result.next();
            topicoModels.addAll(topicoModelItems.items());
        }

        return topicoModels.stream()
                .map(mapper::paraDominio)
                .collect(Collectors.toList());
    }

}

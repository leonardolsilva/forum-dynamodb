package br.com.lelecoder.forumdynamodb.adapter.persistence.converters;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.RespostaModel;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.stream.Collectors;

public class ListRespostaModelConverter implements AttributeConverter<List<RespostaModel>> {

    private final TableSchema<RespostaModel> listTableSchema = TableSchema.fromBean(RespostaModel.class);

    @Override
    public AttributeValue transformFrom(List<RespostaModel> respostaModels) {

        List<AttributeValue> listAttributeValue = respostaModels.stream()
                .map(respostaModel -> listTableSchema.itemToMap(respostaModel, true))
                .map(mapa -> AttributeValue
                        .builder()
                        .m(mapa)
                        .build()
                )
                .collect(Collectors.toList());

        return AttributeValue
                .builder()
                .l(listAttributeValue)
                .build();
    }

    @Override
    public List<RespostaModel> transformTo(AttributeValue attributeValue) {

        List<AttributeValue> attributeValues = attributeValue.l();

        return attributeValues.stream()
                .map(attributeValue1 -> listTableSchema.mapToItem(attributeValue.m()))
                .collect(Collectors.toList());
    }

    @Override
    public EnhancedType<List<RespostaModel>> type() {
        return EnhancedType.listOf(listTableSchema.itemType());
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.L;
    }
}

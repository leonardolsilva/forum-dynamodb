package br.com.lelecoder.forumdynamodb.adapter.persistence.converters;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.RespostaModel;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class RespostaModelConverter implements AttributeConverter<RespostaModel> {

    private final TableSchema<RespostaModel> respostaModelTableSchema = TableSchema.fromBean(RespostaModel.class);

    @Override
    public AttributeValue transformFrom(RespostaModel respostaModel) {
        return AttributeValue
                .builder()
                .m(respostaModelTableSchema.itemToMap(respostaModel, true))
                .build();
    }

    @Override
    public RespostaModel transformTo(AttributeValue attributeValue) {
        return respostaModelTableSchema.mapToItem(attributeValue.m());
    }

    @Override
    public EnhancedType<RespostaModel> type() {
        return respostaModelTableSchema.itemType();
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }
}

package br.com.lelecoder.forumdynamodb.adapter.persistence.converters;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.TopicoModel;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class TopicoModelConverter implements AttributeConverter<TopicoModel> {

    private final TableSchema<TopicoModel> topicoModelTableSchema = TableSchema.fromBean(TopicoModel.class);

    @Override
    public AttributeValue transformFrom(TopicoModel topicoModel) {
        return AttributeValue
                .builder()
                .m(topicoModelTableSchema.itemToMap(topicoModel, true))
                .build();
    }

    @Override
    public TopicoModel transformTo(AttributeValue attributeValue) {
        return topicoModelTableSchema.mapToItem(attributeValue.m());
    }

    @Override
    public EnhancedType<TopicoModel> type() {
        return topicoModelTableSchema.itemType();
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }
}

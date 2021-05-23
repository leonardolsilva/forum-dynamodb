package br.com.lelecoder.forumdynamodb.adapter.persistence.converters;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.DisciplinaModel;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class DisciplinaModelConverter implements AttributeConverter<DisciplinaModel> {

    private final TableSchema<DisciplinaModel> disciplinaModelTableSchema = TableSchema.fromBean(DisciplinaModel.class);

    @Override
    public AttributeValue transformFrom(DisciplinaModel disciplinaModel) {
        return AttributeValue
                .builder()
                .m(disciplinaModelTableSchema.itemToMap(disciplinaModel, true))
                .build();
    }

    @Override
    public DisciplinaModel transformTo(AttributeValue attributeValue) {
        return disciplinaModelTableSchema.mapToItem(attributeValue.m());
    }

    @Override
    public EnhancedType<DisciplinaModel> type() {
        return disciplinaModelTableSchema.itemType();
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }
}

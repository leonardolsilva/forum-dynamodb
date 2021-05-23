package br.com.lelecoder.forumdynamodb.adapter.persistence.converters;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.AlunoModel;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class AlunoModelConverter implements AttributeConverter<AlunoModel> {

    private static final TableSchema<AlunoModel> alunoModelBeanSchema = TableSchema.fromBean(AlunoModel.class);

    @Override
    public AttributeValue transformFrom(AlunoModel alunoModel) {
        return AttributeValue
                .builder()
                .m(alunoModelBeanSchema.itemToMap(alunoModel, true))
                .build();
    }

    @Override
    public AlunoModel transformTo(AttributeValue attributeValue) {
        return alunoModelBeanSchema.mapToItem(attributeValue.m());
    }

    @Override
    public EnhancedType<AlunoModel> type() {
        return alunoModelBeanSchema.itemType();
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.M;
    }
}

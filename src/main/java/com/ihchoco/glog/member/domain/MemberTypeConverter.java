package com.ihchoco.glog.member.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MemberTypeConverter implements AttributeConverter<MemberType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MemberType memberType) {
        if (memberType == null) return null;
        return memberType.getCode();
    }

    @Override
    public MemberType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;

        for (MemberType type : MemberType.values()) {
            if (type.getCode().equals(dbData)) {
                return type;
            }
        }

        throw new IllegalArgumentException("[ERROR] Invalid member type code : " + dbData);
    }
}

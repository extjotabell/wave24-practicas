package com.mercadolibre.be_java_hisp_w24_g02.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserRelationshipsDTO;

import java.io.IOException;

public class UserRelationshipsDTOSerializer extends StdSerializer<UserRelationshipsDTO> {

    public UserRelationshipsDTOSerializer() {
        this(null);
    }

    public UserRelationshipsDTOSerializer(Class<UserRelationshipsDTO> t) {
        super(t);
    }

    @Override
    public void serialize(UserRelationshipsDTO value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("user_id", value.userId());
        gen.writeStringField("user_name", value.userName());

        // Aquí decides el nombre de la clave
        String relationshipKey = value.isFollowers() ? "followers" : "followed";
        gen.writeObjectField(relationshipKey, value.relationshiDTOList());

        gen.writeEndObject();

    }
}

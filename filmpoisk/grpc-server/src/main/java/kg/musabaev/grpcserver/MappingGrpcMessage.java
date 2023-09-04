package kg.musabaev.grpcserver;

import org.mapstruct.Mapping;


@Mapping(target = "mergeFrom", ignore = true)
@Mapping(target = "clearField", ignore = true)
@Mapping(target = "clearOneof", ignore = true)
@Mapping(target = "titleBytes", ignore = true)
@Mapping(target = "unknownFields", ignore = true)
@Mapping(target = "mergeUnknownFields", ignore = true)
@Mapping(target = "allFields", ignore = true)
public @interface MappingGrpcMessage {
}

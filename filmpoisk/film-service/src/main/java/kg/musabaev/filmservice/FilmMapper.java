package kg.musabaev.filmservice;

import kg.musabaev.filmpoisk.grpc.commmons.FilmItemViewResponse;
import kg.musabaev.filmpoisk.grpc.commmons.FilmListViewResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    @MappingGrpcMessage
    FilmItemViewResponse toItemViewDto(Film entity);

    @MappingGrpcMessage
    FilmListViewResponse toListViewDto(Film entity);
}

package kg.musabaev.filmservice;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import kg.musabaev.filmpoisk.grpc.commmons.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Optional;

import static kg.musabaev.filmservice.FilmServiceApplication.films;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NaiveFilmService extends FilmServiceGrpc.FilmServiceImplBase {

	FilmMapper filmMapper;

	@Override
	public void findAllFilms(Empty request, StreamObserver<FilmListViewResponse> responseObserver) {
		films
				.stream()
				.map(filmMapper::toListViewDto)
				.forEach(responseObserver::onNext);
		responseObserver.onCompleted();
	}

	@Override
	public void findAllByTitle(FilmByTitleRequest request, StreamObserver<FilmListViewResponse> responseObserver) {
		String actualTitle = request.getTitle().toLowerCase();
		films
				.stream()
				.map(filmMapper::toListViewDto)
				.filter(film -> film.getTitle().toLowerCase().contains(actualTitle))
				.forEach(responseObserver::onNext);
		responseObserver.onCompleted();
	}

	@Override
	public void findById(FilmByIdRequest request, StreamObserver<FilmItemViewResponse> responseObserver) {
		Optional<FilmItemViewResponse> foundFilm = films
				.stream()
				.map(filmMapper::toItemViewDto)
				.filter(film -> film.getId() == request.getId())
				.findFirst();
		if (foundFilm.isPresent()) responseObserver.onNext(foundFilm.get());
		else responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
		responseObserver.onCompleted();
	}
}

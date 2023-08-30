package kg.musabaev.tutorial;

import io.grpc.stub.StreamObserver;
import kg.musabaev.tutorial.grpc.HelloReply;
import kg.musabaev.tutorial.grpc.HelloRequest;
import kg.musabaev.tutorial.grpc.TutorialServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SimpleTutorialService extends TutorialServiceGrpc.TutorialServiceImplBase {
	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
		HelloReply reply = HelloReply.newBuilder()
				.setMessage("Hello ==> " + request.getName())
				.build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}

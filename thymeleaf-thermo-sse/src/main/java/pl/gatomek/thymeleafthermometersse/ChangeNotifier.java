package pl.gatomek.thymeleafthermometersse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ChangeNotifier {

    private final List<SseEmitter> emitters = new LinkedList<>();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    synchronized public void add(SseEmitter emitter) {
        this.emitters.add(emitter);
    }

    synchronized public void remove(SseEmitter emitter) {
        this.emitters.remove(emitter);
    }

    synchronized public void removeAll(List<SseEmitter> emitters) {
        this.emitters.removeAll(emitters);
    }

    synchronized public List<SseEmitter> cloneEmitters() {
        return new LinkedList<>(emitters);
    }

    public void raiseSseEvents(int temp) {
        executorService.execute(() -> {
            List<SseEmitter> toBeRemoved = new LinkedList<>();

            cloneEmitters().forEach(e -> {
                try {
                    SseEmitter.SseEventBuilder event = SseEmitter
                            .event()
                            .data(String.valueOf(temp))
                            .name("temp");

                    e.send(event);
                } catch (Exception ex) {
                    e.completeWithError(ex);
                    toBeRemoved.add(e);
                }
            });

            removeAll(toBeRemoved);
        });
    }
}

import aspect.LoggingAspect;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Worker;

public class Starter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        Worker worker = ctx.getBean(Worker.class);

        worker.doWork0();
        worker.doWork1();
        try {
            worker.doWork2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        worker.doWork3("Do faster");
    }
}

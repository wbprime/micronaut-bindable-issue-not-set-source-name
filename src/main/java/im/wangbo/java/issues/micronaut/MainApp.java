package im.wangbo.java.issues.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.PropertySource;
import io.micronaut.runtime.Micronaut;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MainApp {
    public static void main(String[] args) {
        final Map<String, Object> m = new HashMap<>();
        m.put("toplevel.poolName", UUID.randomUUID());
        m.put("toplevel.threadsCount", 1);
        m.put("toplevel.c", "9");
        m.put("toplevel.targets", "[1, 2, 3]");
        m.put("toplevel.t", "[10]");
        final PropertySource s = PropertySource.of(m);
        try (final ApplicationContext context =
                     Micronaut.build(args).mainClass(MainApp.class).banner(true).environmentPropertySource(false).propertySources(s).start()) {
            final TopLevelConfig conf = context.getBean(TopLevelConfig.class);
            System.out.println(conf);
        }
    }
}

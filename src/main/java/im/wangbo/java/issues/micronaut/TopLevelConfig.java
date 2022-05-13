package im.wangbo.java.issues.micronaut;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.annotation.AccessorsStyle;
import io.micronaut.core.bind.annotation.Bindable;

import java.util.List;

/**
 * TODO add description here.
 *
 * @author bwang@citics.com
 * @since 1.0.0
 */
@AccessorsStyle(readPrefixes = "", writePrefixes = "")
@ConfigurationProperties("toplevel")
public final class TopLevelConfig {
    private final String poolName;
    private final int threadsCount;

    private final List<String> targets;

    @ConfigurationInject
    public TopLevelConfig(final String poolName, @Bindable(value = "c") final int threadsCount,
//                          @Bindable(value = "t", defaultValue = "")
                          @Bindable(value = "t")
                          final List<String> targets) {
        this.poolName = poolName;
        this.threadsCount = threadsCount;
        this.targets = targets;
    }

    public int threadsCount() {
        return threadsCount;
    }

    public String poolName() {
        return poolName;
    }

    public List<String> targets() {
        return targets;
    }

    @Override
    public String toString() {
        return "TopLevelConfig{" +
                "poolName='" + poolName + '\'' +
                ", threadsCount=" + threadsCount +
                ", targets=" + targets +
                '}';
    }
}

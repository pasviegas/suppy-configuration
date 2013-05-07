package br.org.pav.suppy.configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: pasviegas
 * Date: 4/26/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */

@EnableMetrics
public class MetricsConfig extends MetricsConfigurerAdapter {

    private MetricRegistry metricRegistry = new MetricRegistry();
    private HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();

    @Override
    public MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }

    @Override
    public HealthCheckRegistry getHealthCheckRegistry() {
        return healthCheckRegistry;
    }

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        ConsoleReporter.forRegistry(metricRegistry).build().start(5, TimeUnit.SECONDS);
    }

}

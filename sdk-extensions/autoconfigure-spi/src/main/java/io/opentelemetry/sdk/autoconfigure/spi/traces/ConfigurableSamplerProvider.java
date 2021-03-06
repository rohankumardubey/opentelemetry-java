/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.sdk.autoconfigure.spi.traces;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.trace.samplers.Sampler;

/**
 * A service provider interface (SPI) for providing additional samplers that can be used with the
 * autoconfigured SDK. If the {@code otel.traces.sampler} property contains a value equal to what is
 * returned by {@link #getName()}, the sampler returned by {@link #createSampler(ConfigProperties)}
 * will be enabled and added to the SDK.
 */
public interface ConfigurableSamplerProvider {

  /**
   * Returns a {@link Sampler} that can be registered to OpenTelemetry by providing the property
   * value specified by {@link #getName()}.
   */
  Sampler createSampler(ConfigProperties config);

  /**
   * Returns the name of this sampler, which can be specified with the {@code otel.traces.sampler}
   * property to enable it. The name returned should NOT be the same as any other exporter name. If
   * the name does conflict with another exporter name, the resulting behavior is undefined and it
   * is explicitly unspecified which exporter will actually be used.
   */
  String getName();
}

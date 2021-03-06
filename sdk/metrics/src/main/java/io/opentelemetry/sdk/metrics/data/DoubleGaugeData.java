/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.sdk.metrics.data;

import com.google.auto.value.AutoValue;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.concurrent.Immutable;

/** {@link GaugeData} recorded uses {@code double}s. */
@Immutable
@AutoValue
public abstract class DoubleGaugeData implements GaugeData<DoublePointData> {
  static final DoubleGaugeData EMPTY = DoubleGaugeData.create(Collections.emptyList());

  public static DoubleGaugeData create(Collection<DoublePointData> points) {
    return new AutoValue_DoubleGaugeData(points);
  }

  DoubleGaugeData() {}

  @Override
  public abstract Collection<DoublePointData> getPoints();
}

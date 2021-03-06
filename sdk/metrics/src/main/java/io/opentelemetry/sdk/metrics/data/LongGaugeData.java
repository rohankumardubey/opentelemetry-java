/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.sdk.metrics.data;

import com.google.auto.value.AutoValue;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.concurrent.Immutable;

/** {@link GaugeData} recorded uses {@code long}s. */
@Immutable
@AutoValue
public abstract class LongGaugeData implements GaugeData<LongPointData> {

  static final LongGaugeData EMPTY = LongGaugeData.create(Collections.emptyList());

  public static LongGaugeData create(Collection<LongPointData> points) {
    return new AutoValue_LongGaugeData(points);
  }

  LongGaugeData() {}

  @Override
  public abstract Collection<LongPointData> getPoints();
}

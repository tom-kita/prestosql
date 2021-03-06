/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.orc.metadata;

import com.google.common.collect.ImmutableList;

import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class StripeFooter
{
    private final List<Stream> streams;
    private final ColumnMetadata<ColumnEncoding> columnEncodings;
    private final Optional<ZoneId> timeZone;

    public StripeFooter(List<Stream> streams, ColumnMetadata<ColumnEncoding> columnEncodings, Optional<ZoneId> timeZone)
    {
        this.streams = ImmutableList.copyOf(requireNonNull(streams, "streams is null"));
        this.columnEncodings = requireNonNull(columnEncodings, "columnEncodings is null");
        this.timeZone = requireNonNull(timeZone, "timeZone is null");
    }

    public ColumnMetadata<ColumnEncoding> getColumnEncodings()
    {
        return columnEncodings;
    }

    public List<Stream> getStreams()
    {
        return streams;
    }

    public Optional<ZoneId> getTimeZone()
    {
        return timeZone;
    }
}

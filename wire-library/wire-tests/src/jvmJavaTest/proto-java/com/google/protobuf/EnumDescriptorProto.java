// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

/**
 * Describes an enum type.
 */
public final class EnumDescriptorProto extends Message<EnumDescriptorProto, EnumDescriptorProto.Builder> {
  public static final ProtoAdapter<EnumDescriptorProto> ADAPTER = new ProtoAdapter_EnumDescriptorProto();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String name;

  @WireField(
      tag = 2,
      adapter = "com.google.protobuf.EnumValueDescriptorProto#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<EnumValueDescriptorProto> value;

  @WireField(
      tag = 3,
      adapter = "com.google.protobuf.EnumOptions#ADAPTER"
  )
  public final EnumOptions options;

  /**
   * Range of reserved numeric values. Reserved numeric values may not be used
   * by enum values in the same enum declaration. Reserved ranges may not
   * overlap.
   */
  @WireField(
      tag = 4,
      adapter = "com.google.protobuf.EnumDescriptorProto$EnumReservedRange#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<EnumReservedRange> reserved_range;

  /**
   * Reserved enum value names, which may not be reused. A given name may only
   * be reserved once.
   */
  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REPEATED
  )
  public final List<String> reserved_name;

  public EnumDescriptorProto(String name, List<EnumValueDescriptorProto> value, EnumOptions options,
      List<EnumReservedRange> reserved_range, List<String> reserved_name) {
    this(name, value, options, reserved_range, reserved_name, ByteString.EMPTY);
  }

  public EnumDescriptorProto(String name, List<EnumValueDescriptorProto> value, EnumOptions options,
      List<EnumReservedRange> reserved_range, List<String> reserved_name,
      ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.value = Internal.immutableCopyOf("value", value);
    this.options = options;
    this.reserved_range = Internal.immutableCopyOf("reserved_range", reserved_range);
    this.reserved_name = Internal.immutableCopyOf("reserved_name", reserved_name);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.value = Internal.copyOf(value);
    builder.options = options;
    builder.reserved_range = Internal.copyOf(reserved_range);
    builder.reserved_name = Internal.copyOf(reserved_name);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof EnumDescriptorProto)) return false;
    EnumDescriptorProto o = (EnumDescriptorProto) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(name, o.name)
        && value.equals(o.value)
        && Internal.equals(options, o.options)
        && reserved_range.equals(o.reserved_range)
        && reserved_name.equals(o.reserved_name);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + value.hashCode();
      result = result * 37 + (options != null ? options.hashCode() : 0);
      result = result * 37 + reserved_range.hashCode();
      result = result * 37 + reserved_name.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(Internal.sanitize(name));
    if (!value.isEmpty()) builder.append(", value=").append(value);
    if (options != null) builder.append(", options=").append(options);
    if (!reserved_range.isEmpty()) builder.append(", reserved_range=").append(reserved_range);
    if (!reserved_name.isEmpty()) builder.append(", reserved_name=").append(Internal.sanitize(reserved_name));
    return builder.replace(0, 2, "EnumDescriptorProto{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<EnumDescriptorProto, Builder> {
    public String name;

    public List<EnumValueDescriptorProto> value;

    public EnumOptions options;

    public List<EnumReservedRange> reserved_range;

    public List<String> reserved_name;

    public Builder() {
      value = Internal.newMutableList();
      reserved_range = Internal.newMutableList();
      reserved_name = Internal.newMutableList();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder value(List<EnumValueDescriptorProto> value) {
      Internal.checkElementsNotNull(value);
      this.value = value;
      return this;
    }

    public Builder options(EnumOptions options) {
      this.options = options;
      return this;
    }

    /**
     * Range of reserved numeric values. Reserved numeric values may not be used
     * by enum values in the same enum declaration. Reserved ranges may not
     * overlap.
     */
    public Builder reserved_range(List<EnumReservedRange> reserved_range) {
      Internal.checkElementsNotNull(reserved_range);
      this.reserved_range = reserved_range;
      return this;
    }

    /**
     * Reserved enum value names, which may not be reused. A given name may only
     * be reserved once.
     */
    public Builder reserved_name(List<String> reserved_name) {
      Internal.checkElementsNotNull(reserved_name);
      this.reserved_name = reserved_name;
      return this;
    }

    @Override
    public EnumDescriptorProto build() {
      return new EnumDescriptorProto(name, value, options, reserved_range, reserved_name, super.buildUnknownFields());
    }
  }

  /**
   * Range of reserved numeric values. Reserved values may not be used by
   * entries in the same enum. Reserved ranges may not overlap.
   *
   * Note that this is distinct from DescriptorProto.ReservedRange in that it
   * is inclusive such that it can appropriately represent the entire int32
   * domain.
   */
  public static final class EnumReservedRange extends Message<EnumReservedRange, EnumReservedRange.Builder> {
    public static final ProtoAdapter<EnumReservedRange> ADAPTER = new ProtoAdapter_EnumReservedRange();

    private static final long serialVersionUID = 0L;

    public static final Integer DEFAULT_START = 0;

    public static final Integer DEFAULT_END = 0;

    /**
     * Inclusive.
     */
    @WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer start;

    /**
     * Inclusive.
     */
    @WireField(
        tag = 2,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer end;

    public EnumReservedRange(Integer start, Integer end) {
      this(start, end, ByteString.EMPTY);
    }

    public EnumReservedRange(Integer start, Integer end, ByteString unknownFields) {
      super(ADAPTER, unknownFields);
      this.start = start;
      this.end = end;
    }

    @Override
    public Builder newBuilder() {
      Builder builder = new Builder();
      builder.start = start;
      builder.end = end;
      builder.addUnknownFields(unknownFields());
      return builder;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) return true;
      if (!(other instanceof EnumReservedRange)) return false;
      EnumReservedRange o = (EnumReservedRange) other;
      return unknownFields().equals(o.unknownFields())
          && Internal.equals(start, o.start)
          && Internal.equals(end, o.end);
    }

    @Override
    public int hashCode() {
      int result = super.hashCode;
      if (result == 0) {
        result = unknownFields().hashCode();
        result = result * 37 + (start != null ? start.hashCode() : 0);
        result = result * 37 + (end != null ? end.hashCode() : 0);
        super.hashCode = result;
      }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      if (start != null) builder.append(", start=").append(start);
      if (end != null) builder.append(", end=").append(end);
      return builder.replace(0, 2, "EnumReservedRange{").append('}').toString();
    }

    public static final class Builder extends Message.Builder<EnumReservedRange, Builder> {
      public Integer start;

      public Integer end;

      public Builder() {
      }

      /**
       * Inclusive.
       */
      public Builder start(Integer start) {
        this.start = start;
        return this;
      }

      /**
       * Inclusive.
       */
      public Builder end(Integer end) {
        this.end = end;
        return this;
      }

      @Override
      public EnumReservedRange build() {
        return new EnumReservedRange(start, end, super.buildUnknownFields());
      }
    }

    private static final class ProtoAdapter_EnumReservedRange extends ProtoAdapter<EnumReservedRange> {
      public ProtoAdapter_EnumReservedRange() {
        super(FieldEncoding.LENGTH_DELIMITED, EnumReservedRange.class, "type.googleapis.com/google.protobuf.EnumDescriptorProto.EnumReservedRange");
      }

      @Override
      public int encodedSize(EnumReservedRange value) {
        return ProtoAdapter.INT32.encodedSizeWithTag(1, value.start)
            + ProtoAdapter.INT32.encodedSizeWithTag(2, value.end)
            + value.unknownFields().size();
      }

      @Override
      public void encode(ProtoWriter writer, EnumReservedRange value) throws IOException {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.start);
        ProtoAdapter.INT32.encodeWithTag(writer, 2, value.end);
        writer.writeBytes(value.unknownFields());
      }

      @Override
      public EnumReservedRange decode(ProtoReader reader) throws IOException {
        Builder builder = new Builder();
        long token = reader.beginMessage();
        for (int tag; (tag = reader.nextTag()) != -1;) {
          switch (tag) {
            case 1: builder.start(ProtoAdapter.INT32.decode(reader)); break;
            case 2: builder.end(ProtoAdapter.INT32.decode(reader)); break;
            default: {
              reader.readUnknownField(tag);
            }
          }
        }
        builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
        return builder.build();
      }

      @Override
      public EnumReservedRange redact(EnumReservedRange value) {
        Builder builder = value.newBuilder();
        builder.clearUnknownFields();
        return builder.build();
      }
    }
  }

  private static final class ProtoAdapter_EnumDescriptorProto extends ProtoAdapter<EnumDescriptorProto> {
    public ProtoAdapter_EnumDescriptorProto() {
      super(FieldEncoding.LENGTH_DELIMITED, EnumDescriptorProto.class, "type.googleapis.com/google.protobuf.EnumDescriptorProto");
    }

    @Override
    public int encodedSize(EnumDescriptorProto value) {
      return ProtoAdapter.STRING.encodedSizeWithTag(1, value.name)
          + EnumValueDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(2, value.value)
          + EnumOptions.ADAPTER.encodedSizeWithTag(3, value.options)
          + EnumReservedRange.ADAPTER.asRepeated().encodedSizeWithTag(4, value.reserved_range)
          + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, value.reserved_name)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, EnumDescriptorProto value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      EnumValueDescriptorProto.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.value);
      EnumOptions.ADAPTER.encodeWithTag(writer, 3, value.options);
      EnumReservedRange.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.reserved_range);
      ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 5, value.reserved_name);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public EnumDescriptorProto decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.value.add(EnumValueDescriptorProto.ADAPTER.decode(reader)); break;
          case 3: builder.options(EnumOptions.ADAPTER.decode(reader)); break;
          case 4: builder.reserved_range.add(EnumReservedRange.ADAPTER.decode(reader)); break;
          case 5: builder.reserved_name.add(ProtoAdapter.STRING.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public EnumDescriptorProto redact(EnumDescriptorProto value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.value, EnumValueDescriptorProto.ADAPTER);
      if (builder.options != null) builder.options = EnumOptions.ADAPTER.redact(builder.options);
      Internal.redactElements(builder.reserved_range, EnumReservedRange.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}

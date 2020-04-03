// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

/**
 * Describes a field within a message.
 */
public final class FieldDescriptorProto extends Message<FieldDescriptorProto, FieldDescriptorProto.Builder> {
  public static final ProtoAdapter<FieldDescriptorProto> ADAPTER = new ProtoAdapter_FieldDescriptorProto();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final Integer DEFAULT_NUMBER = 0;

  public static final Label DEFAULT_LABEL = Label.LABEL_OPTIONAL;

  public static final Type DEFAULT_TYPE = Type.TYPE_DOUBLE;

  public static final String DEFAULT_TYPE_NAME = "";

  public static final String DEFAULT_EXTENDEE = "";

  public static final String DEFAULT_DEFAULT_VALUE = "";

  public static final Integer DEFAULT_ONEOF_INDEX = 0;

  public static final String DEFAULT_JSON_NAME = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String name;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer number;

  @WireField(
      tag = 4,
      adapter = "com.google.protobuf.FieldDescriptorProto$Label#ADAPTER"
  )
  public final Label label;

  /**
   * If type_name is set, this need not be set.  If both this and type_name
   * are set, this must be one of TYPE_ENUM, TYPE_MESSAGE or TYPE_GROUP.
   */
  @WireField(
      tag = 5,
      adapter = "com.google.protobuf.FieldDescriptorProto$Type#ADAPTER"
  )
  public final Type type;

  /**
   * For message and enum types, this is the name of the type.  If the name
   * starts with a '.', it is fully-qualified.  Otherwise, C++-like scoping
   * rules are used to find the type (i.e. first the nested types within this
   * message are searched, then within the parent, on up to the root
   * namespace).
   */
  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String type_name;

  /**
   * For extensions, this is the name of the type being extended.  It is
   * resolved in the same manner as type_name.
   */
  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String extendee;

  /**
   * For numeric types, contains the original text representation of the value.
   * For booleans, "true" or "false".
   * For strings, contains the default text contents (not escaped in any way).
   * For bytes, contains the C escaped value.  All bytes >= 128 are escaped.
   * TODO(kenton):  Base-64 encode?
   */
  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String default_value;

  /**
   * If set, gives the index of a oneof in the containing type's oneof_decl
   * list.  This field is a member of that oneof.
   */
  @WireField(
      tag = 9,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer oneof_index;

  /**
   * JSON name of this field. The value is set by protocol compiler. If the
   * user has set a "json_name" option on this field, that option's value
   * will be used. Otherwise, it's deduced from the field's name by converting
   * it to camelCase.
   */
  @WireField(
      tag = 10,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String json_name;

  @WireField(
      tag = 8,
      adapter = "com.google.protobuf.FieldOptions#ADAPTER"
  )
  public final FieldOptions options;

  public FieldDescriptorProto(String name, Integer number, Label label, Type type, String type_name,
      String extendee, String default_value, Integer oneof_index, String json_name,
      FieldOptions options) {
    this(name, number, label, type, type_name, extendee, default_value, oneof_index, json_name, options, ByteString.EMPTY);
  }

  public FieldDescriptorProto(String name, Integer number, Label label, Type type, String type_name,
      String extendee, String default_value, Integer oneof_index, String json_name,
      FieldOptions options, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.number = number;
    this.label = label;
    this.type = type;
    this.type_name = type_name;
    this.extendee = extendee;
    this.default_value = default_value;
    this.oneof_index = oneof_index;
    this.json_name = json_name;
    this.options = options;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.number = number;
    builder.label = label;
    builder.type = type;
    builder.type_name = type_name;
    builder.extendee = extendee;
    builder.default_value = default_value;
    builder.oneof_index = oneof_index;
    builder.json_name = json_name;
    builder.options = options;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof FieldDescriptorProto)) return false;
    FieldDescriptorProto o = (FieldDescriptorProto) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(name, o.name)
        && Internal.equals(number, o.number)
        && Internal.equals(label, o.label)
        && Internal.equals(type, o.type)
        && Internal.equals(type_name, o.type_name)
        && Internal.equals(extendee, o.extendee)
        && Internal.equals(default_value, o.default_value)
        && Internal.equals(oneof_index, o.oneof_index)
        && Internal.equals(json_name, o.json_name)
        && Internal.equals(options, o.options);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (number != null ? number.hashCode() : 0);
      result = result * 37 + (label != null ? label.hashCode() : 0);
      result = result * 37 + (type != null ? type.hashCode() : 0);
      result = result * 37 + (type_name != null ? type_name.hashCode() : 0);
      result = result * 37 + (extendee != null ? extendee.hashCode() : 0);
      result = result * 37 + (default_value != null ? default_value.hashCode() : 0);
      result = result * 37 + (oneof_index != null ? oneof_index.hashCode() : 0);
      result = result * 37 + (json_name != null ? json_name.hashCode() : 0);
      result = result * 37 + (options != null ? options.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(Internal.sanitize(name));
    if (number != null) builder.append(", number=").append(number);
    if (label != null) builder.append(", label=").append(label);
    if (type != null) builder.append(", type=").append(type);
    if (type_name != null) builder.append(", type_name=").append(Internal.sanitize(type_name));
    if (extendee != null) builder.append(", extendee=").append(Internal.sanitize(extendee));
    if (default_value != null) builder.append(", default_value=").append(Internal.sanitize(default_value));
    if (oneof_index != null) builder.append(", oneof_index=").append(oneof_index);
    if (json_name != null) builder.append(", json_name=").append(Internal.sanitize(json_name));
    if (options != null) builder.append(", options=").append(options);
    return builder.replace(0, 2, "FieldDescriptorProto{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<FieldDescriptorProto, Builder> {
    public String name;

    public Integer number;

    public Label label;

    public Type type;

    public String type_name;

    public String extendee;

    public String default_value;

    public Integer oneof_index;

    public String json_name;

    public FieldOptions options;

    public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder number(Integer number) {
      this.number = number;
      return this;
    }

    public Builder label(Label label) {
      this.label = label;
      return this;
    }

    /**
     * If type_name is set, this need not be set.  If both this and type_name
     * are set, this must be one of TYPE_ENUM, TYPE_MESSAGE or TYPE_GROUP.
     */
    public Builder type(Type type) {
      this.type = type;
      return this;
    }

    /**
     * For message and enum types, this is the name of the type.  If the name
     * starts with a '.', it is fully-qualified.  Otherwise, C++-like scoping
     * rules are used to find the type (i.e. first the nested types within this
     * message are searched, then within the parent, on up to the root
     * namespace).
     */
    public Builder type_name(String type_name) {
      this.type_name = type_name;
      return this;
    }

    /**
     * For extensions, this is the name of the type being extended.  It is
     * resolved in the same manner as type_name.
     */
    public Builder extendee(String extendee) {
      this.extendee = extendee;
      return this;
    }

    /**
     * For numeric types, contains the original text representation of the value.
     * For booleans, "true" or "false".
     * For strings, contains the default text contents (not escaped in any way).
     * For bytes, contains the C escaped value.  All bytes >= 128 are escaped.
     * TODO(kenton):  Base-64 encode?
     */
    public Builder default_value(String default_value) {
      this.default_value = default_value;
      return this;
    }

    /**
     * If set, gives the index of a oneof in the containing type's oneof_decl
     * list.  This field is a member of that oneof.
     */
    public Builder oneof_index(Integer oneof_index) {
      this.oneof_index = oneof_index;
      return this;
    }

    /**
     * JSON name of this field. The value is set by protocol compiler. If the
     * user has set a "json_name" option on this field, that option's value
     * will be used. Otherwise, it's deduced from the field's name by converting
     * it to camelCase.
     */
    public Builder json_name(String json_name) {
      this.json_name = json_name;
      return this;
    }

    public Builder options(FieldOptions options) {
      this.options = options;
      return this;
    }

    @Override
    public FieldDescriptorProto build() {
      return new FieldDescriptorProto(name, number, label, type, type_name, extendee, default_value, oneof_index, json_name, options, super.buildUnknownFields());
    }
  }

  public enum Type implements WireEnum {
    /**
     * 0 is reserved for errors.
     * Order is weird for historical reasons.
     */
    TYPE_DOUBLE(1),

    TYPE_FLOAT(2),

    /**
     * Not ZigZag encoded.  Negative numbers take 10 bytes.  Use TYPE_SINT64 if
     * negative values are likely.
     */
    TYPE_INT64(3),

    TYPE_UINT64(4),

    /**
     * Not ZigZag encoded.  Negative numbers take 10 bytes.  Use TYPE_SINT32 if
     * negative values are likely.
     */
    TYPE_INT32(5),

    TYPE_FIXED64(6),

    TYPE_FIXED32(7),

    TYPE_BOOL(8),

    TYPE_STRING(9),

    /**
     * Tag-delimited aggregate.
     * Group type is deprecated and not supported in proto3. However, Proto3
     * implementations should still be able to parse the group wire format and
     * treat group fields as unknown fields.
     */
    TYPE_GROUP(10),

    /**
     * Length-delimited aggregate.
     */
    TYPE_MESSAGE(11),

    /**
     * New in version 2.
     */
    TYPE_BYTES(12),

    TYPE_UINT32(13),

    TYPE_ENUM(14),

    TYPE_SFIXED32(15),

    TYPE_SFIXED64(16),

    /**
     * Uses ZigZag encoding.
     */
    TYPE_SINT32(17),

    /**
     * Uses ZigZag encoding.
     */
    TYPE_SINT64(18);

    public static final ProtoAdapter<Type> ADAPTER = new ProtoAdapter_Type();

    private final int value;

    Type(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Type fromValue(int value) {
      switch (value) {
        case 1: return TYPE_DOUBLE;
        case 2: return TYPE_FLOAT;
        case 3: return TYPE_INT64;
        case 4: return TYPE_UINT64;
        case 5: return TYPE_INT32;
        case 6: return TYPE_FIXED64;
        case 7: return TYPE_FIXED32;
        case 8: return TYPE_BOOL;
        case 9: return TYPE_STRING;
        case 10: return TYPE_GROUP;
        case 11: return TYPE_MESSAGE;
        case 12: return TYPE_BYTES;
        case 13: return TYPE_UINT32;
        case 14: return TYPE_ENUM;
        case 15: return TYPE_SFIXED32;
        case 16: return TYPE_SFIXED64;
        case 17: return TYPE_SINT32;
        case 18: return TYPE_SINT64;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }

    private static final class ProtoAdapter_Type extends EnumAdapter<Type> {
      ProtoAdapter_Type() {
        super(Type.class);
      }

      @Override
      protected Type fromValue(int value) {
        return Type.fromValue(value);
      }
    }
  }

  public enum Label implements WireEnum {
    /**
     * 0 is reserved for errors
     */
    LABEL_OPTIONAL(1),

    LABEL_REQUIRED(2),

    LABEL_REPEATED(3);

    public static final ProtoAdapter<Label> ADAPTER = new ProtoAdapter_Label();

    private final int value;

    Label(int value) {
      this.value = value;
    }

    /**
     * Return the constant for {@code value} or null.
     */
    public static Label fromValue(int value) {
      switch (value) {
        case 1: return LABEL_OPTIONAL;
        case 2: return LABEL_REQUIRED;
        case 3: return LABEL_REPEATED;
        default: return null;
      }
    }

    @Override
    public int getValue() {
      return value;
    }

    private static final class ProtoAdapter_Label extends EnumAdapter<Label> {
      ProtoAdapter_Label() {
        super(Label.class);
      }

      @Override
      protected Label fromValue(int value) {
        return Label.fromValue(value);
      }
    }
  }

  private static final class ProtoAdapter_FieldDescriptorProto extends ProtoAdapter<FieldDescriptorProto> {
    public ProtoAdapter_FieldDescriptorProto() {
      super(FieldEncoding.LENGTH_DELIMITED, FieldDescriptorProto.class, "type.googleapis.com/google.protobuf.FieldDescriptorProto");
    }

    @Override
    public int encodedSize(FieldDescriptorProto value) {
      return ProtoAdapter.STRING.encodedSizeWithTag(1, value.name)
          + ProtoAdapter.INT32.encodedSizeWithTag(3, value.number)
          + Label.ADAPTER.encodedSizeWithTag(4, value.label)
          + Type.ADAPTER.encodedSizeWithTag(5, value.type)
          + ProtoAdapter.STRING.encodedSizeWithTag(6, value.type_name)
          + ProtoAdapter.STRING.encodedSizeWithTag(2, value.extendee)
          + ProtoAdapter.STRING.encodedSizeWithTag(7, value.default_value)
          + ProtoAdapter.INT32.encodedSizeWithTag(9, value.oneof_index)
          + ProtoAdapter.STRING.encodedSizeWithTag(10, value.json_name)
          + FieldOptions.ADAPTER.encodedSizeWithTag(8, value.options)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, FieldDescriptorProto value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      ProtoAdapter.INT32.encodeWithTag(writer, 3, value.number);
      Label.ADAPTER.encodeWithTag(writer, 4, value.label);
      Type.ADAPTER.encodeWithTag(writer, 5, value.type);
      ProtoAdapter.STRING.encodeWithTag(writer, 6, value.type_name);
      ProtoAdapter.STRING.encodeWithTag(writer, 2, value.extendee);
      ProtoAdapter.STRING.encodeWithTag(writer, 7, value.default_value);
      ProtoAdapter.INT32.encodeWithTag(writer, 9, value.oneof_index);
      ProtoAdapter.STRING.encodeWithTag(writer, 10, value.json_name);
      FieldOptions.ADAPTER.encodeWithTag(writer, 8, value.options);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public FieldDescriptorProto decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.extendee(ProtoAdapter.STRING.decode(reader)); break;
          case 3: builder.number(ProtoAdapter.INT32.decode(reader)); break;
          case 4: {
            try {
              builder.label(Label.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 5: {
            try {
              builder.type(Type.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          case 6: builder.type_name(ProtoAdapter.STRING.decode(reader)); break;
          case 7: builder.default_value(ProtoAdapter.STRING.decode(reader)); break;
          case 8: builder.options(FieldOptions.ADAPTER.decode(reader)); break;
          case 9: builder.oneof_index(ProtoAdapter.INT32.decode(reader)); break;
          case 10: builder.json_name(ProtoAdapter.STRING.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public FieldDescriptorProto redact(FieldDescriptorProto value) {
      Builder builder = value.newBuilder();
      if (builder.options != null) builder.options = FieldOptions.ADAPTER.redact(builder.options);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}

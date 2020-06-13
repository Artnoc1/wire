/*
 * Copyright 2020 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire

import com.google.protobuf.ListValue
import com.google.protobuf.NullValue
import com.google.protobuf.Struct
import com.google.protobuf.Value

internal fun structOf(map: Map<String, *>): Struct {
  val builder = Struct.newBuilder()
  for ((key, value) in map) {
    builder.putFields(key, valueOf(value))
  }
  return builder.build()
}

internal fun emptyStruct(): Struct {
  return Struct.newBuilder().build()
}

internal fun listValueOf(list: List<*>): ListValue {
  val builder = ListValue.newBuilder()
  for (any in list) {
    builder.addValues(valueOf(any))
  }
  return builder.build()
}

internal fun emptyListValue(): ListValue {
  return ListValue.newBuilder().build()
}

internal fun valueOf(any: Any?): Value {
  return when (any) {
    null -> Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build()
    is Double -> Value.newBuilder().setNumberValue(any).build()
    is String -> Value.newBuilder().setStringValue(any).build()
    is Boolean -> Value.newBuilder().setBoolValue(any).build()
    is Map<*, *> -> Value.newBuilder().setStructValue(structOf(any as Map<String, *>)).build()
    is List<*> -> Value.newBuilder().setListValue(listValueOf(any)).build()
    else -> throw IllegalArgumentException("unexpected struct value: $any")
  }
}

internal fun nullValue(): NullValue {
  return NullValue.NULL_VALUE
}

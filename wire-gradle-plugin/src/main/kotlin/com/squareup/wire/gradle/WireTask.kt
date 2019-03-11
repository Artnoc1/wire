/*
 * Copyright (C) 2018 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.gradle

import com.squareup.wire.schema.Location
import com.squareup.wire.schema.Target
import com.squareup.wire.schema.WireRun
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.FileCollectionDependency
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.TaskAction
import java.io.File

open class WireTask : SourceTask() {
  @Input
  fun pluginVersion() = ""

  lateinit var sourceConfiguration: Configuration
  lateinit var protoConfiguration: Configuration
  lateinit var roots: List<String>
  lateinit var prunes: List<String>
  var rules: File? = null
  lateinit var targets: List<Target>

  @TaskAction
  fun generateWireFiles() {
    val includes = mutableListOf<String>()
    val excludes = mutableListOf<String>()

    rules?.forEachLine {
      when (it.firstOrNull()) {
        '+' -> includes.add(it.substring(1))
        '-' -> excludes.add(it.substring(1))
        else -> Unit
      }
    }

    if (includes.isNotEmpty()) {
      logger.info("INCLUDE:\n * ${includes.joinToString(separator = "\n * ")}")
    }
    if (excludes.isNotEmpty()) {
      logger.info("EXCLUDE:\n * ${excludes.joinToString(separator = "\n * ")}")
    }
    if (includes.isEmpty() && excludes.isEmpty()) logger.info("NO INCLUDES OR EXCLUDES")

    if (logger.isDebugEnabled) {
      sourceConfiguration.dependencies.forEach {
        logger.debug(
            "dep: $it -> " + ((it as? FileCollectionDependency)?.files as? SourceDirectorySet)?.srcDirs
        )
        logger.debug("sourceConfiguration.files for dep: " + sourceConfiguration.files(it))
      }
      protoConfiguration.dependencies.forEach {
        logger.debug(
            "dep: $it -> " + ((it as? FileCollectionDependency)?.files as? SourceDirectorySet)?.srcDirs
        )
        logger.debug("protoConfiguration.files for dep: " + protoConfiguration.files(it))
      }
      logger.debug("roots: $roots")
      logger.debug("prunes: $prunes")
      logger.debug("rules: $rules")
      logger.debug("targets: $targets")
    }

    val wireRun = WireRun(
        sourcePath = sourceConfiguration.toLocations(),
        protoPath = protoConfiguration.toLocations(),
        treeShakingRoots = if (roots.isEmpty()) includes else roots,
        treeShakingRubbish = if (prunes.isEmpty()) excludes else prunes,
        targets = targets
    )
    wireRun.execute()
  }

  private fun Configuration.toLocations(): List<Location> {
    return dependencies
        .flatMap { dep ->
          files(dep)
              .map { file ->
                if (dep is FileCollectionDependency && dep.files is SourceDirectorySet) {
                  val srcDir = (dep.files as SourceDirectorySet).srcDirs.first {
                    file.path.startsWith(it.path + "/")
                  }
                  Location.get(srcDir.path, file.path.substring(srcDir.path.length + 1))
                } else {
                  Location.get(file.path)
                }
              }
        }
  }
}
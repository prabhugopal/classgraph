package com.nagkom.classgraph

import sbt.*
import sbt.Keys.*
import sbt.plugins.JvmPlugin

object ClassGraphPlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin

  object autoImport {
    val sampleSetting = settingKey[String]("A setting that is automatically imported to the build")
    val showGraph = taskKey[Unit]("A task that is automatically imported to the build")
    lazy val baseClassGraphSettings :  Seq[Setting[_]] = Def.settings(
      sampleSetting := "this is sample",
      showGraph := {
        showClassGraph()
      }
    )
  }

  import autoImport._

  override val projectSettings: Seq[Setting[_]] =  baseClassGraphSettings

  override lazy val buildSettings = Seq()

  override lazy val globalSettings = Seq()

  protected def showClassGraph(): Unit = {
    println("Hello, plugin.. :)")
  }
}

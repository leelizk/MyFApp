package com.example.myapplication.utils

/**
 * This class is responsible for providing the information in the [BuildConfig] but in a testable
 * fashion.
 */
interface BuildConfiguration {
	fun versionName(): String
	val environmentConfig: String?
	val isDebug: Boolean
}

class BuildConfigBuildConfiguration(
	private val versionName: String
) : BuildConfiguration {
	override fun versionName() = versionName

	override val environmentConfig: String? = BuildConfig.ENVIRONMENT

	override val isDebug: Boolean = BuildConfig.DEBUG
}

class TestBuildConfiguration : BuildConfiguration {
	override fun versionName() = ""

	override val environmentConfig: String? = "demo"

	override val isDebug: Boolean = true
}

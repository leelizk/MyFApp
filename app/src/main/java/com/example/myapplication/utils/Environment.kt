package com.example.myapplication.utils

/**
 * This class is responsible for providing the current environment that the app is running in.
 * This effects the endpoints we point to, etc.
 */
class Environment(
	private val buildConfiguration: BuildConfiguration,
	private val userPreferences: UserPreferences
) {

	val name: String
		get() = if (buildConfiguration.isDebug) {
			userPreferences.environment
				?: buildConfiguration.environmentConfig
				?: DEMO_ENVIRONMENT
		} else {
			PRODUCTION_ENVIRONMENT
		}

	companion object {
		const val DEMO_ENVIRONMENT = "demo"
		const val PRODUCTION_ENVIRONMENT = "production"
		const val LOCAL_ENVIRONMENT = "local"
	}
}

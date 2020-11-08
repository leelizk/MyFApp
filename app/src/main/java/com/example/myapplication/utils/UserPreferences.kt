package com.example.myapplication.utils

/**
 * Any class that implements this interface is responsible for storing and producing
 * simple data values that persists across app starts.
 */
interface UserPreferences {
	var environment: String?
	var analyticsLoggingEnabled: Boolean
}

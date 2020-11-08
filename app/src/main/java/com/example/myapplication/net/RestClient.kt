package com.example.myapplication.net

import okhttp3.MediaType
import okhttp3.RequestBody

interface RestClient {

	companion object {
		val MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8")
	}

	fun get(url: String, headers: Map<String, String>): NetworkResponse

	fun get(
		url: String,
		params: Map<String, Any> = emptyMap(),
		headers: Map<String, String>
	): NetworkResponse

	fun post(
		url: String,
		params: Map<String, Any> = emptyMap(),
		headers: Map<String, String>
	): NetworkResponse

	fun post(
		url: String,
		requestBody: RequestBody,
		headers: Map<String, String>
	): NetworkResponse

	fun patch(
		url: String,
		params: Map<String, Any> = emptyMap(),
		headers: Map<String, String>
	): NetworkResponse

	fun patch(
		url: String,
		params: Map<String, Any> = emptyMap(),
		requestBody: RequestBody,
		headers: Map<String, String>
	): NetworkResponse

	fun put(
		url: String,
		params: Map<String, Any> = emptyMap(),
		headers: Map<String, String>
	): NetworkResponse

	fun delete(url: String, headers: Map<String, String>): NetworkResponse

	/**
	 * This data class is responsible for representing the data object that we will receive back from
	 * any particular API request.
	 */
	data class NetworkResponse(
		val isSuccessful: Boolean,
		val text: String,
		val code: Int?,
		val requestUrl: String = "",
		val description: String = "",
		val httpMethod: String = "",
		val environment: String = ""
	)
}

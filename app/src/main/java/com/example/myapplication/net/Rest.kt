package com.example.myapplication.net

import com.example.myapplication.utils.Environment
import com.example.myapplication.utils.toStringsMap
import okhttp3.Headers
import okhttp3.RequestBody
import retrofit2.Response

/**
 * This class is responsible for being a lightweight wrapper around our networking library,
 * Retrofit.
 */
class Rest(
	private val retrofitService: RetrofitService,
	//val config: Config,
	//val keyChainWrapper: KeyChainWrapper,
	val environment: Environment,
	//val freshlyLog: FreshlyLog,
	//val dataStore: DataStore
) : RestClient {
	override fun get(url: String, headers: Map<String, String>): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.get(url, headers).execute()
			createResponse(response, url, GET, requestHeaders = headers, exception = null)
		} catch (e: Exception) {
			createResponse(null, url, GET, requestHeaders = headers, exception = e)
		}
	}

	override fun get(url: String, params: Map<String, Any>, headers: Map<String, String>): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.get(url, params.toStringsMap(), headers).execute()
			createResponse(
				response,
				url,
				GET,
				parameters = headers.toStringsMap(),
				requestHeaders = headers,
				exception = null
			)
		} catch (e: Exception) {
			createResponse(null, url, GET, headers.toStringsMap(), requestHeaders = headers, exception = e)
		}
	}

	override fun post(
		url: String,
		params: Map<String, Any>,
		headers: Map<String, String>
	): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.post(url, params.toStringsMap(), headers).execute()
			createResponse(
				response, url, POST, parameters = headers.toStringsMap(), requestHeaders = headers,
				exception = null
			)
		} catch (e: Exception) {
			createResponse(null, url, POST, headers.toStringsMap(), headers, exception = e)
		}
	}

	override fun post(url: String, requestBody: RequestBody, headers: Map<String, String>): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.post(url, requestBody, headers).execute()
			createResponse(
				response, url, POST,
				parameters = headers.toStringsMap(),
				requestHeaders = headers,
				exception = null
			)
		} catch (e: Exception) {
			createResponse(null, url, POST, headers.toStringsMap(), headers, exception = e)
		}
	}

	override fun patch(
		url: String,
		params: Map<String, Any>,
		headers: Map<String, String>
	): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.patch(url, params.toStringsMap(), headers).execute()
			createResponse(response, url, PATCH, requestHeaders = headers, exception = null)
		} catch (e: Exception) {
			createResponse(null, url, PATCH, requestHeaders = headers, exception = e)
		}
	}

	override fun patch(
		url: String,
		params: Map<String, Any>,
		requestBody: RequestBody,
		headers: Map<String, String>
	): RestClient.NetworkResponse {
		return try {
			val response =
				retrofitService.patch(url, requestBody, headers).execute()
			createResponse(response, url, PATCH, requestHeaders = headers, exception = null)
		} catch (e: Exception) {
			createResponse(null, url, PATCH, requestHeaders = headers, exception = e)
		}
	}

	override fun put(
		url: String,
		params: Map<String, Any>,
		headers: Map<String, String>
	): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.put(url, params.toStringsMap(), headers).execute()
			createResponse(response, url, PUT, requestHeaders = headers, exception = null)
		} catch (e: Exception) {
			createResponse(null, url, PUT, requestHeaders = headers, exception = e)
		}
	}

	override fun delete(url: String, headers: Map<String, String>): RestClient.NetworkResponse {
		return try {
			val response = retrofitService.delete(url, headers).execute()
			createResponse(response, url, DELETE, requestHeaders = headers, exception = null)
		} catch (e: Exception) {
			createResponse(null, url, DELETE, requestHeaders = headers, exception = e)
		}
	}

	private fun createResponse(
		response: Response<String>?,
		requestUrl: String,
		httpMethod: String,
		parameters: Map<String, String>? = emptyMap(),
		requestHeaders: Map<String, String>,
		exception: Exception?
	): RestClient.NetworkResponse {
		val headers: Headers? = response?.headers()
		val s: String? = null;//headers?.get(Api.DEVICE_TOKEN_KEY)
		s?.let {
			if (it.isNotBlank()) {
				//keyChainWrapper.storeDeviceToken(it)
			}
		}
		val isSuccessful: Boolean = if (response == null) false else response.code() < 400
		val text: String = if (isSuccessful) response?.body()
			?: "1"/*config.defaultNoBodyMessage*/ else "2"/*response?.errorBody()?.string()*/
			?: "3"/*config.errorMessage*/
		val description: String = response.toString()
		val environment: String = environment.name
		val networkResponse = RestClient.NetworkResponse(
			isSuccessful,
			text,
			response?.code(),
			requestUrl,
			description,
			httpMethod,
			environment
		)
		if (!isSuccessful) {

			//记录日志
			/*freshlyLog.error(
				"NETWORK-ERROR",
				parameters,
				requestHeaders,
				networkResponse,
				if (isSuccessful) response?.body() else response?.errorBody()?.string(),
				dataStore.fetchUserId(),
				dataStore.getCurrentSubscriptionId(),
				exception
			)*/
		}
		return networkResponse
	}

	companion object {
		const val GET = "GET"
		const val POST = "POST"
		const val PATCH = "PATCH"
		const val DELETE = "DELETE"
		const val PUT = "PUT"
	}
}

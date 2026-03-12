package com.matejdro.micropebble.webservices.api

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

@Serializable
data class WebservicesToken(
   val sourceId: Uuid,
   val bootUrl: String = DEFAULT_BOOT_API_URL,
   val token: String,
) {
   companion object {
      const val DEFAULT_API_URL = "https://appstore-api.rebble.io/"
      const val DEFAULT_BOOT_API_URL = "https://boot.rebble.io/"
   }
}

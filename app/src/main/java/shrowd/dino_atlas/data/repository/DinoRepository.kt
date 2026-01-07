package shrowd.dino_atlas.data.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import shrowd.dino_atlas.data.model.Dino
import java.io.File

class DinoRepository(private val context: Context) {

    private val client = OkHttpClient()
    private val gson = Gson()

    private val cacheFile: File
        get() = File(context.cacheDir, "dinosaurs_cache.json")

    suspend fun loadDinos(): List<Dino> = withContext(Dispatchers.IO) {
        return@withContext try {

            val request = Request.Builder()
                .url("https://raw.githubusercontent.com/shrowd/dino_atlas/refs/heads/master/dinosaurs.json")
                .build()

            val response = client.newCall(request).execute()
            val json = response.body.string()

            if (json.isEmpty()) {
                throw Exception("Empty response from server")
            }

            cacheFile.writeText(json)
            parseDinos(json)
        } catch (e: Exception) {
            if (cacheFile.exists()) {
                parseDinos(cacheFile.readText())
            } else {
                emptyList()
            }
        }
    }
    private fun parseDinos(json: String): List<Dino> {
        val type = object : TypeToken<List<Dino>>() {}.type
        return gson.fromJson(json, type)
    }
}
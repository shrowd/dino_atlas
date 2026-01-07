package shrowd.dino_atlas.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import shrowd.dino_atlas.data.model.Dino
import java.io.File

class DinoRepository(private val context: Context) {

    private val client = OkHttpClient()
    private val gson = Gson()

    private val cacheFile: File
        get() = File(context.cacheDir, "cache.json")

    companion object {
        private const val DINO_URL =
            "https://raw.githubusercontent.com/shrowd/dinoapp/refs/heads/main/dinosaurs.json"
    }

    private fun parse(json: String): List<Dino> {
        val type = object : TypeToken<List<Dino>>() {}.type
        return gson.fromJson(json, type)
    }

    fun loadDinos(): List<Dino> {
        return try {
            val request = Request.Builder()
                .url(DINO_URL)
                .build()

            val response = client.newCall(request).execute()
            val json = response.body?.string() ?: throw Exception("Empty")

            cacheFile.writeText(json)
            parse(json)
        } catch (e: Exception) {
            if (cacheFile.exists()) {
                parse(cacheFile.readText())
            } else {
                emptyList()
            }
        }
    }
}

package source

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import shapes.BaseShape
import java.io.FileReader
import java.io.FileWriter
import java.lang.Exception


class ShapeStore(private val sourcePath: String) {
    fun read(): List<BaseShape> {
        try {
            val reader = FileReader(sourcePath);
            val gsonBuilder = GsonBuilder()
            val type = object : TypeToken<List<BaseShape>>() {}.type
            gsonBuilder.registerTypeAdapter(BaseShape::class.java, InterfaceAdapter())
            return gsonBuilder.create().fromJson(reader, type)
        } catch (e: Exception) {
            throw e
        }
        return listOf()
    }


    fun write(shapes: List<BaseShape>) {
        try {
            val writer = FileWriter(sourcePath);
            val gsonBuilder = GsonBuilder()
            val type = object : TypeToken<List<BaseShape>>() {}.type
            gsonBuilder.registerTypeAdapter(BaseShape::class.java, InterfaceAdapter())
            print(gsonBuilder.create().toJson(shapes, type))
            gsonBuilder.create().toJson(shapes, type, writer)
            writer.flush()
            writer.close()
        } catch (e: Exception) {
            throw e
        }
    }
}
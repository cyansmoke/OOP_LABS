package store

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import shapes.BaseShape
import store.InterfaceAdapter
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.lang.Exception

class ShapeStore(private val sourcePath: String) {
    fun read(): List<BaseShape> {
        try {
            val reader = FileReader(sourcePath)
            val gsonBuilder = GsonBuilder()
            val type = object : TypeToken<List<BaseShape>>() {}.type
            gsonBuilder.registerTypeAdapter(BaseShape::class.java, InterfaceAdapter())
            return gsonBuilder.create().fromJson(reader, type)
        } catch (e: FileNotFoundException) {
            throw ReadFileException("File not found, looks like u didn't call write func")
        }
    }


    fun write(shapes: List<BaseShape>) {
        try {
            val writer = FileWriter(sourcePath)
            val gsonBuilder = GsonBuilder()
            val type = object : TypeToken<List<BaseShape>>() {}.type
            gsonBuilder.registerTypeAdapter(BaseShape::class.java, InterfaceAdapter())
            gsonBuilder.create().toJson(shapes, type, writer)
            writer.flush()
            writer.close()
        } catch (e: IOException) {
            throw WriteFileException("Can't create file or can't edit it, try to create in another directory, or clear storage")
        }
    }
}
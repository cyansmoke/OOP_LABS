package store

import com.google.gson.*
import shapes.BaseShape
import java.lang.reflect.Type

const val CLASSNAME = "CLASSNAME"
const val DATA = "DATA"

class InterfaceAdapter : JsonSerializer<BaseShape>, JsonDeserializer<BaseShape> {
    override fun serialize(o: BaseShape, type: Type, jsonSerializationContext: JsonSerializationContext): JsonElement {
        val jsonObject = JsonObject()
        jsonObject.addProperty(CLASSNAME, o.javaClass.name)
        jsonObject.add(DATA, jsonSerializationContext.serialize(o))
        return jsonObject
    }

    override fun deserialize(json: JsonElement, type: Type, context: JsonDeserializationContext): BaseShape {
        val jsonObject = json.asJsonObject
        val prim = jsonObject[CLASSNAME] as JsonPrimitive
        val className = prim.asString
        val clazz = getObjectClass(className)
        return context.deserialize(jsonObject[DATA], clazz)
    }

    private fun getObjectClass(className: String?): Class<*> {
        return try {
            Class.forName(className)
        } catch (e: ClassNotFoundException) {
            throw JsonParseException(e.message)
        }
    }
}
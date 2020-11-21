import com.google.gson.Gson
import shapes.*
import java.io.FileReader
import java.io.FileWriter


val gson = Gson()

fun main() {
    val triangles = listOf(
        Triangle(3.0, 4.0, 5.0),
        Triangle(10.0, 12.0, 13.4),
        Triangle(23.0, 11.4, 23.4)
    )

    val circles = listOf(
        Circle(10.0),
        Circle(1.1),
        Circle(23.4)
    )

    val squares = listOf(
        Square(35.0),
        Square(3.4),
        Square(78.3)
    )

    val rectangles = listOf(
        Rectangle(83.2, 45.3),
        Rectangle(1.2, 34.5),
        Rectangle(4.2, 3.5)
    )

    writeToFile(triangles)

    val readTriangles = readFromFile(Array<Triangle>::class.java)

    print(readTriangles[0].firstSide)
}

inline fun <reified T : BaseShape> readFromFile(clazz: Class<Array<T>>): List<T> {
    FileReader("output_${clazz.simpleName.replace("[]", "")}.json").use {
        return gson.fromJson(it, clazz).toList()
    }
}

inline fun <reified RT : BaseShape> writeToFile(listOfShape: List<RT>) {
    FileWriter("output_${RT::class.java.simpleName}.json").use {
        gson.toJson(listOfShape, it)
    }
}
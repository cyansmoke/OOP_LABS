import shapes.Circle
import shapes.Rectangle
import shapes.Square
import shapes.Triangle

fun main() {
    val shapes = listOf(
        Triangle(3.0, 4.0, 5.0),
        Triangle(10.0, 12.0, 13.4),
        Triangle(23.0, 11.4, 23.4),
        Circle(10.0),
        Circle(1.1),
        Circle(23.4),
        Square(35.0),
        Square(3.4),
        Square(78.3),
        Rectangle(83.2, 45.3),
        Rectangle(1.2, 34.5),
        Rectangle(4.2, 3.5)
    )

    val areaSum = shapes.sumByDouble { it.calculateArea() }
    val maxAreaShape = shapes.maxBy { it.calculateArea() }
    val minAreaShape = shapes.minBy { it.calculateArea() }
    val minPerimeterShape = shapes.minBy { it.calculatePerimeter() }
    val maxPerimeterShape = shapes.maxBy { it.calculatePerimeter() }

    println("Area Sum: $areaSum")
    println("Max Area Shape: $maxAreaShape")
    println("Min Area Shape: $minAreaShape")
    println("Min Perimeter Shape: $minPerimeterShape")
    println("Max Perimeter Shape: $maxPerimeterShape")
}
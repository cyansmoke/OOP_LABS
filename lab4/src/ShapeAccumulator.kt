import shapes.BaseShape

class ShapeAccumulator<T : BaseShape> {

    private val listOfFigures = mutableListOf<T>()

    fun add(shape: T) = listOfFigures.add(shape)

    fun addAll(shapes: Collection<T>) = listOfFigures.addAll(shapes)

    fun getMaxAreaShape() = listOfFigures.maxByOrNull { it.calculateArea() }

    fun getMinAreaShape() = listOfFigures.minByOrNull { it.calculateArea() }

    fun getMaxPerimeterShape() = listOfFigures.maxByOrNull { it.calculatePerimeter() }

    fun getMinPerimeterShape() = listOfFigures.minByOrNull { it.calculatePerimeter() }

    fun getTotalArea() = listOfFigures.sumByDouble { it.calculateArea() }

    fun getTotalPerimeter() = listOfFigures.sumByDouble { it.calculatePerimeter() }
}
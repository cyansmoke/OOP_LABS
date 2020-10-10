package shapes

class Square(private val sideSize: Double) : Rectangle(sideSize, sideSize) {
    init {
        if (!validate()) {
            throw Error("Invalid shape parameters")
        }
    }

    override fun printShapeInfo() {
        println("Square with side size: $sideSize, area: ${calculateArea()}, perimeter: ${calculatePerimeter()}")
    }
}
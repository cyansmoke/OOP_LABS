package shapes

class Circle(private val radius: Double) : BaseShape() {
    override fun validate(): Boolean = radius > 0

    override fun calculateArea(): Double = Math.PI * radius * radius

    override fun calculatePerimeter(): Double = 2 * Math.PI * radius
}
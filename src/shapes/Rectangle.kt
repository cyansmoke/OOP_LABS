package shapes

open class Rectangle(private val width: Double, private val height: Double) : BaseShape() {

    override fun validate(): Boolean = width > 0 && height > 0

    override fun calculateArea(): Double = width * height

    override fun calculatePerimeter(): Double = (width + height) * 2
}
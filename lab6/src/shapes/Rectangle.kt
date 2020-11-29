package shapes

open class Rectangle(val width: Double, val height: Double) : BaseShape {
    init {
        if (!validate()) {
            throw Error("Invalid shape parameters")
        }
    }

    final override fun validate(): Boolean = width > 0 && height > 0

    override fun calculateArea(): Double = width * height

    override fun calculatePerimeter(): Double = (width + height) * 2

    override fun toString(): String {
        return "Rectangle (${width}x${height})"
    }
}
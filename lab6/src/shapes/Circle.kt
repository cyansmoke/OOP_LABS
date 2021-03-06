package shapes

class Circle(val radius: Double) : BaseShape {

    init {
        if (!validate()) {
            throw Error("Invalid shape parameters")
        }
    }

    override fun validate(): Boolean = radius > 0

    override fun calculateArea(): Double = Math.PI * radius * radius

    override fun calculatePerimeter(): Double = 2 * Math.PI * radius

    override fun toString(): String {
        return "Circle: ($radius)"
    }
}
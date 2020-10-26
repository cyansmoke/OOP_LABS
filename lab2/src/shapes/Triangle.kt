package shapes

import kotlin.math.sqrt

class Triangle(val firstSide: Double, val secondSide: Double, val thirdSide: Double) :
    BaseShape {

    init {
        if (!validate()) {
            throw Error("Invalid shape parameters")
        }
    }

    override fun validate(): Boolean {
        return firstSide > 0 && secondSide > 0 && thirdSide > 0
                && firstSide + secondSide > thirdSide
                && firstSide + thirdSide > secondSide
                && thirdSide + secondSide > firstSide
    }

    override fun calculateArea(): Double {
        val halfPerimeter = calculatePerimeter() / 2
        return sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide))
    }

    override fun calculatePerimeter(): Double = firstSide + secondSide + thirdSide

    override fun toString(): String {
        return "Triangle with sides size: $firstSide, $secondSide, $thirdSide, area: ${calculateArea()}, perimeter: ${calculatePerimeter()}"
    }
}
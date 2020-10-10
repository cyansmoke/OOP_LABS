package shapes

import kotlin.math.sqrt

class Triangle(private val firstSide: Double, private val secondSide: Double, private val thirdSide: Double) :
    BaseShape() {
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
}
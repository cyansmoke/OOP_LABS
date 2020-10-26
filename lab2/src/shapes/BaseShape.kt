package shapes

interface BaseShape {
    fun validate(): Boolean
    fun calculateArea(): Double
    fun calculatePerimeter(): Double
}
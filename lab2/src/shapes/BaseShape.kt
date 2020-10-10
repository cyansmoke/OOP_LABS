package shapes

abstract class BaseShape {
    protected abstract fun validate(): Boolean
    abstract fun calculateArea(): Double
    abstract fun calculatePerimeter(): Double
    abstract fun printShapeInfo()
}
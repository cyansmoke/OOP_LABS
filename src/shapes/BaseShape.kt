package shapes

abstract class BaseShape {
    abstract fun validate(): Boolean
    abstract fun calculateArea(): Double
    abstract fun calculatePerimeter(): Double

    init {
        if (!this.validate()) {
            throw Error("Invalid shape parameters")
        }
    }
}
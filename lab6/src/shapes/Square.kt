package shapes

class Square(val sideSize: Double) : Rectangle(sideSize, sideSize) {
    init {
        if (!validate()) {
            throw Error("Invalid shape parameters")
        }
    }

    override fun toString(): String {
        return "Square ($sideSize)"
    }
}
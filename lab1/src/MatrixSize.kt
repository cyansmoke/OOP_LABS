data class MatrixSize (val x: Int, val y: Int) {
    init {
        if (x < 0) {
            throw Exception("'x' value must be greater than zero")
        }
        if (y < 0) {
            throw Exception("'y' value must be greater than zero")
        }
    }

    fun isSquare(): Boolean {
        return this.x == this.y
    }

    override fun toString(): String {
        return """$x X $y"""
    }
}

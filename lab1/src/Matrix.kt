import java.util.*
import kotlin.math.pow

class Matrix(private var matrixSize: MatrixSize) {
    var matrix: Array<Array<Double>>

    init {
        matrix = Array(matrixSize.x) { Array(matrixSize.y) { 1.0 } }
    }

    constructor(size: MatrixSize, initMatrix: Array<Array<Double>>): this(size) {
        if (initMatrix.isNotEmpty() && initMatrix[0].isNotEmpty()) {
            matrix = initMatrix.map { it.clone() }.toTypedArray();
            val isCorrectArraysSize = initMatrix.all { it.size == size.y }
            if (size.x != initMatrix.size || !isCorrectArraysSize) {
                throw IllegalArgumentException("Wrong matrix size")
            }
        } else {
            throw IllegalArgumentException("Expected not empty array")
        }
    }

    private fun getValueByCoordinates(coords: MatrixSize): Double {
        if (coords.x > matrixSize.x - 1 || coords.y > matrixSize.y - 1) {
            throw IllegalArgumentException("Coordinates are outside of matrix")
        }
        return matrix[coords.x][coords.y];
    }

    operator fun get(x: Int, y: Int): Double {
        return this.getValueByCoordinates(MatrixSize(x, y))
    }

    private fun setValueByCoordinates(coords: MatrixSize, value: Double) {
        if (coords.x > matrixSize.x - 1 || coords.y > matrixSize.y - 1) {
            throw IllegalArgumentException("Coordinates are outside of matrix")
        }
        matrix[coords.x][coords.y] = value;
    }

    operator fun set(x: Int, y: Int, value: Double) {
        this.setValueByCoordinates(MatrixSize(x, y), value)
    }

    fun size(): MatrixSize {
        return matrixSize;
    }

    operator fun times(scalar: Double): Matrix {
        val newMatrix = Matrix(matrixSize.copy())
        matrix.forEachIndexed() {x, array ->
            array.forEachIndexed {y, number -> newMatrix[x, y] = number * scalar }
        }
        return newMatrix;
    }

    operator fun times(mulMatrix: Matrix): Matrix {
        if (matrixSize.y != mulMatrix.size().x) {
            throw IllegalArgumentException("Incorrect matrix size")
        }
        val result = Matrix(MatrixSize(matrixSize.x, mulMatrix.size().y))
        var value = 0.0
        for (i in 0 until matrixSize.x) {
            for (j in 0 until mulMatrix.size().y) {
                for (k in 0 until matrixSize.y) {
                    value += this[i, k] * mulMatrix[k, j]
                }
                result[i, j] = value;
                value = 0.0
            }
        }
        return result
    }

    operator fun plus(plusMatrix: Matrix): Matrix {
        if (matrixSize.x != plusMatrix.size().x || matrixSize.y != plusMatrix.size().y) {
            throw IllegalArgumentException("Incorrect matrix size")
        }
        val result = Matrix(matrixSize.copy())
        for (i in 0 until matrixSize.x) {
            for (j in 0 until matrixSize.y) {
                result[i, j] = this[i, j] + plusMatrix[i, j]
            }
        }
        return result
    }

    operator fun minus(minusMatrix: Matrix): Matrix {
        if (matrixSize.x != minusMatrix.size().x || matrixSize.y != minusMatrix.size().y) {
            throw IllegalArgumentException("Incorrect matrix size")
        }
        val result = Matrix(matrixSize.copy())
        for (i in 0 until matrixSize.x) {
            for (j in 0 until matrixSize.y) {
                result[i, j] = this[i, j] - minusMatrix[i, j]
            }
        }
        return result
    }

    fun determinant(): Double {
        if (!matrixSize.isSquare()) {
            throw IllegalArgumentException("Not square matrix")
        }
        return this.calcDeterminant(matrix)
    }

    private fun calcDeterminant(matrix: Array<Array<Double>>): Double {
        var result = 0.0
        if (matrix.size == 1) {
            result = matrix[0][0]
            return result
        }
        if (matrix.size == 2) {
            result = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
            return result
        }
        for (i in matrix[0].indices) {
            val buffer = Array(matrixSize.x - 1) { Array(matrixSize.y - 1) { 1.0 } }
            for (j in 1 until matrix.size) {
                for (k in matrix[0].indices) {
                    if (k < i) {
                        buffer[j - 1][k] = matrix[j][k]
                    } else if (k > i) {
                        buffer[j - 1][k - 1] = matrix[j][k]
                    }
                }
            }
            val subDeterminant = matrix[0][i] * (-1.0).pow(i.toDouble()) * this.calcDeterminant(buffer)
            result += subDeterminant
        }
        return result
    }

    fun getArray(): Array<Array<Double>> {
        return this.matrix.map { it.clone() }.toTypedArray();
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder();
        stringBuilder.append("[")
        matrix.forEach {
            stringBuilder.append("[")
            it.forEach { number ->
                stringBuilder.append(""" $number""")
            }
            stringBuilder.append(" ]")
        }
        stringBuilder.append("]")
        return stringBuilder.toString()
    }
}
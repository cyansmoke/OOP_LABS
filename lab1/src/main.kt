fun main() {
    val matrix = Matrix(MatrixSize(3, 3))
    println(matrix.size())
    println(matrix * 1.5)
    matrix[2, 1] = 2.6
    println(matrix[2, 1])
    print(matrix)
    print(matrix.determinant())

    val newMatrix = Matrix(
        MatrixSize(3, 3),
        arrayOf(
            arrayOf(1.2, 3.0, 3.4),
            arrayOf(4.3, 5.1, 3.1),
            arrayOf(4.3, 5.1, 3.1)
        )
    )

    print(matrix * newMatrix)
    print(matrix - newMatrix)
    print(matrix + newMatrix)
}
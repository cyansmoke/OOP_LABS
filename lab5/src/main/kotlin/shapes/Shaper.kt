package shapes

data class Shaper<T : BaseShape>(
    val shapes: List<T>
)
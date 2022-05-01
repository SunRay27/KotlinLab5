package shapes2d

interface ColoredShape2D : Shape2D {
    val borderColor: Color
    val fillColor: Color

    override fun toString() : String
}
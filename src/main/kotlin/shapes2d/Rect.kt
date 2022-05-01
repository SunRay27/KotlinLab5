package shapes2d

open class Rect(private val size: Vector2, override val fillColor: Color, override val borderColor: Color) :
    BaseShape(borderColor, fillColor) {

    init {
        if (size.x <= 0 || size.y <= 0)
            throw IllegalArgumentException("rect size can't be <= 0")
    }

    override fun calcArea(): Double {
        return size.x * size.y
    }

    override fun toString(): String {
        return "${this::class} Size: $size Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }


}
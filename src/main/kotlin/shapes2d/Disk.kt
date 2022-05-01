package shapes2d

class Disk(private val radius: Double, override val fillColor: Color, override val borderColor: Color) :
    BaseShape(borderColor, fillColor) {

    init {
        if (radius <= 0)
            throw IllegalArgumentException("disc radius can't be <= 0")
    }

    override fun calcArea(): Double {
        return Math.PI * radius * radius
    }

    override fun toString(): String {
        return "${this::class} Radius: $radius Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }
}
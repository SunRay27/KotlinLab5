package shapes2d

import jdk.jshell.spi.ExecutionControl.NotImplementedException

abstract class BaseShape(override val fillColor: Color, override val borderColor: Color) : ColoredShape2D {
    override fun calcArea(): Double {
        throw NotImplementedException("Calculating the area of this shape is not implemented")
    }

    override fun toString(): String {
        return "${this::class} Area: ${calcArea()} Fill: $fillColor Border: $borderColor"
    }
}
import shapes2d.*
import kotlin.reflect.KClass

class ShapeCollector<T : ColoredShape2D> {
    private val shapes: MutableList<T> = mutableListOf()

    fun add(newShape: T) {
        shapes.add(newShape)
    }

    fun getMinAreaShape(): Shape2D? {
        return shapes.minByOrNull { it.calcArea() }
    }

    fun getMaxAreaShape(): Shape2D? {
        return shapes.maxByOrNull { it.calcArea() }
    }

    fun getTotalShapesArea(): Double {
        return shapes.sumOf { it.calcArea() }
    }

    fun getAllShapesWithFillColor(fillColor: Color): List<ColoredShape2D> {
        return shapes.filter { it.fillColor == fillColor }
    }

    fun getAllShapesWithBorderColor(borderColor: Color): List<ColoredShape2D> {
        return shapes.filter { it.borderColor == borderColor }
    }

    fun getAllShapes(): List<ColoredShape2D> {
        return shapes.toList()
    }

    fun count(): Int {
        return shapes.count()
    }

    fun getAllShapesGroupedByFillColor(): Map<Color, List<ColoredShape2D>> {
        return shapes.groupBy { it.fillColor }
    }

    fun getAllShapesGroupedByBorderColor(): Map<Color, List<ColoredShape2D>> {
        return shapes.groupBy { it.borderColor }
    }

    fun <T : Any> getAllShapesOfType(shapeType: KClass<T>): List<T> {
        @Suppress("UNCHECKED_CAST")
        return shapes.filter { it::class == shapeType } as List<T>
    }

    fun addAll(collection: Collection<T>) {
        shapes.addAll(collection)
    }

    fun getSorted(comparator: Comparator<T>): List<T> {
        val copy = shapes.toMutableList()
        copy.sortWith(comparator)
        return copy
    }


}



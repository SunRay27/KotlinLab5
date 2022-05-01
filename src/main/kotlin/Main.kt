import shapes2d.*

fun main() {
    val red = Color(1f, 0f, 0f, 1f)
    val green = Color(0f, 1f, 0f, 1f)
    val blue = Color(0f, 0f, 1f, 1f)
    val white = Color(1f, 1f, 1f, 1f)
    val black = Color(0f, 0f, 0f, 1f)


    val collector = ShapeCollector<ColoredShape2D>()

    collector.add(Disk(1.0, white, black))
    collector.add(Disk(2.0, white, black))
    collector.add(Disk(3.0, white, black))

    collector.add(SquareRect(5.0, black, red))
    collector.add(Rect(Vector2(5.0, 10.0), black, red))
    collector.add(SquareRect(5.0, black, red))

    collector.add(
        Triangle(
            Vector2(0.0, 0.0),
            Vector2(15.0, 0.0),
            Vector2(0.0, 15.0),
            green,
            blue
        )
    )

    println("Collector count: " + collector.count())
    println("Min area shape: ${collector.getMinAreaShape()}")
    println("Max area shape: ${collector.getMaxAreaShape()}")
    println("Total area: ${(collector.getTotalShapesArea())}")

    println()
    println("White fill color shapes:")
    collector.getAllShapesWithFillColor(white).forEach { println(it) }

    println()
    println("Red border color shapes:")
    collector.getAllShapesWithBorderColor(red).forEach { println(it) }

    println()
    println("Grouped by fill color:")
    collector.getAllShapesGroupedByFillColor().forEach { entry ->
        println("${entry.key}: ")
        entry.value.forEach { shape ->
            println("${shape as BaseShape}")
        }
    }

    println()
    println("Grouped by border color:")
    collector.getAllShapesGroupedByBorderColor().forEach { entry ->
        println("${entry.key}: ")
        entry.value.forEach { shape ->
            println("${shape as BaseShape}")
        }
    }

    println()
    println("All shapes of type Disk:")
    collector.getAllShapesOfType(Disk::class).forEach { println(it) }

    println()
    println("All shapes:")
    collector.getAllShapes().forEach { println(it.toString()) }

    val collectorNew = ShapeCollector<ColoredShape2D>()
    collectorNew.addAll(collector.getAllShapes())

    println("All shapes from copy:")
    collectorNew.getAllShapes().forEach { println(it) }

    println("Copy shapes sorted by area:")
    collectorNew.getSorted(compareBy { it.calcArea() }).forEach { println(it) }
}
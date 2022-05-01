package shapes2d

data class Color(val r: Float, val g: Float, val b: Float, val a: Float) {
    override fun toString(): String {
        return "($r; $g; $b; $a)"
    }
}
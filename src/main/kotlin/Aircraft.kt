abstract class Aircraft(val id: Int, protected val maxRange: Double, protected val tankCapacity: Double) {
    abstract val model: String

    protected val fuelConsumption: Double
        get() = tankCapacity / maxRange * 100

    open fun showParams() {
        println("""
            бортовой номер: $id
            максимальная дальность: $maxRange
            объём топлива: $tankCapacity
            расход топлива: $fuelConsumption
        """.trimIndent()
        )
    }
}
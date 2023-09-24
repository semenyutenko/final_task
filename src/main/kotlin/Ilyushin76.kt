class Ilyushin76(id: Int, maxRange: Double, tankCapacity: Double, override val carryingCapacity: Double) :
    Aircraft(id, maxRange, tankCapacity), Cargo {

    override val model: String = "Ил-76"
    override fun showParams() {
        println(model)
        super.showParams()
        println("грузоподъёмность: $carryingCapacity")
    }
}
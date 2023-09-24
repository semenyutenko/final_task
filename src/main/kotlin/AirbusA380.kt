class AirbusA380(id: Int, maxRange: Double, tankCapacity: Double, override val passengersNumber: Int) :
    Aircraft(id, maxRange, tankCapacity), Passenger {

    override val model: String = "Airbus A380"
    override fun showParams() {
        println(model)
        super.showParams()
        println("количество пассажиров: $passengersNumber")
    }
}
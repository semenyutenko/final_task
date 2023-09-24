import kotlin.reflect.KClass

var isExit: Boolean = false
val airplanes = ArrayList<Aircraft>()

fun main() {
    airplanes.add(Boeing747(1, 7200.0, 183380.0, 366))
    airplanes.add(AirbusA380(2, 15200.0, 248380.0, 525))
    airplanes.add(Ilyushin76(3, 10500.0, 109000.0, 60000.0))
    airplanes.add(AirbusA380(4, 14000.0, 210080.0, 450))

    while (!isExit) {
        println("""            
1. Полный список всех самолётов
2. Список грузовых самолётов
3. Список пассажирских самолётов
4. Параметры самолёта по его номеру
5. Выход из программы    
    """)
        print("Какая информация Вас интересует? Укажите номер операции: ")
        val operationNumber = readln()
        when (operationNumber) {
            "1" -> allAirplanes()
            "2" -> getAirplanesByType(Cargo::class)
            "3" -> getAirplanesByType(Passenger::class)
            "4" -> getParamsById()
            "5" -> exit()
            else -> println("Вы ввели: \"$operationNumber\". Это некорректное значение. Попробуйте ещё раз.")
        }
    }
}

fun allAirplanes() {
    println("\nСписок всех самолётов авиакомпании: \n")
    airplanes.forEach{plane -> println("Модель: ${plane.model} бортовой номер: ${plane.id}")}
}

fun getAirplanesByType(type: KClass<*>) {
    if (type.isInstance(Cargo::class)) {
        println("\nСписок грузовых самолётов авиакомпании: \n")
    } else {
        println("\nСписок пассажирских самолётов авиакомпании: \n")
    }
    airplanes.stream()
        .filter { plane -> type.isInstance(plane) }
        .forEach { plane -> println("Модель: ${plane.model} бортовой номер: ${plane.id}")}
}

fun getParamsById() {
    print("Укажите номер самолёта, который Вас интересует: ")
    val id = readln()
    val plane = airplanes.find {plane -> plane.id.toString() == id}
    println()
    if (plane == null) {
        println("Самолёта с бортовым номером $id в списках нет")
    } else {
        plane.showParams()
    }

}

fun exit() {
    println("\nПрограмма завершена")
    isExit = true
}

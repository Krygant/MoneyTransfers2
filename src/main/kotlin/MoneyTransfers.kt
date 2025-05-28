fun main() {
    var resultCommission = calculateCommission("Visa", 0.0, 150_000.0)
    when(resultCommission){
        -1.0 -> println("Превышен суточный лимит!")
        -2.0 -> println("Превышен месячный лимит!")
        -3.0 -> println("Неизвестный тип карты!")
        else -> println("Комиссия составляет $resultCommission руб")
    }
}

fun calculateCommission(cardType: String = "Мир", monthlyTransfers: Double = 0.0, transferAmount: Double): Double {
    val dailyLimit = 150_000.0 // Максимум в сутки
    val monthlyLimit = 600_000.0 // Максимум в месяц
    val mastercardLimit = 75_000.0 // Лимит для Mastercard

    // Проверка лимитов
    if (transferAmount > dailyLimit) {
        return -1.0
    }
    if (monthlyTransfers + transferAmount > monthlyLimit) {
        return -2.0
    }

    // Расчет комиссии
    return when (cardType) {
        "Mastercard" -> {
            if (monthlyTransfers + transferAmount <= mastercardLimit) {
                0.0 // Комиссия не взимается
            } else {
                val commission = transferAmount * 0.006 + 20 // 0.6% + 20 руб
                commission
            }
        }
        "Visa" -> {
            val commission = transferAmount * 0.0075
            if (commission < 35) {
                35.0 // Минимальная комиссия
            } else {
                commission
            }
        }
        "Мир" -> 0.0 // Комиссия не взимается
        else -> -3.0
    }
}
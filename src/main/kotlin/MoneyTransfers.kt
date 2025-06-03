fun main() {
    var resultCommission = calculateCommission("VK Pay", 40_001.0, 1_000.0)
    when(resultCommission){
        -1.0 -> println("Превышен суточный лимит!")
        -2.0 -> println("Превышен месячный лимит!")
        -3.0 -> println("Неизвестный тип карты!")
        else -> println("Комиссия составляет $resultCommission руб")
    }
}

fun calculateCommission(cardType: String = "Мир",
                        monthlyTransfers: Double = 0.0,
                        transferAmount: Double): Double
{
    val dailyCardLimit = 150_000.0 // Максимум по карте в сутки
    val monthlyCardLimit = 600_000.0 // Максимум по карте в месяц
    val dailyVKPayLimit = 15_000 // Максимум с VKPay в сутки
    val monthlyVKPayLimit = 40_000 // Максимум с VKPay в месяц
    val mastercardMaxLimit = 75_000.0 // Максимальный лимит для Mastercard и Maestro
    val mastercardMinLimit = 300.0 // Минимальный лимит для Mastercard и Maestro
    val visaMinCommission = 35.0 // Минимальная комиссия для Visa и Мир
    val visaCommission = 0.0075 // Комиссия для Visa и Мир
    val nonCommission = 0.0 // Комиссия не взимается
    val dailyLimitExceeded = -1.0 // Превышен суточный лимит!
    val monthlyLimitExceeded = -2.0 // Превышен месячный лимит!
    val unknownCardType = -3.0 // Неизвестный тип карты!
    val rangeNonCommission = mastercardMinLimit..mastercardMaxLimit // Значения минимального и максимального платежа,
                                                                          // когда не берется комиссия для Mastercard и Maestro

    // Проверка лимитов
    if(cardType == "VK Pay") {
        if (transferAmount > dailyVKPayLimit) return dailyLimitExceeded
        if (monthlyTransfers + transferAmount > monthlyVKPayLimit) return monthlyLimitExceeded
    }

    if(cardType !== "VK Pay") {
        if (transferAmount > dailyCardLimit) return dailyLimitExceeded
        if (monthlyTransfers + transferAmount > monthlyCardLimit) return monthlyLimitExceeded
    }
    // Расчет комиссии
    return when (cardType) {
        "Mastercard", "Maestro" -> {
            var commission: Double
            if (monthlyTransfers + transferAmount in rangeNonCommission) {
                nonCommission // Комиссия не взимается
            }else if (transferAmount !in rangeNonCommission) {
                commission = transferAmount * 0.006 + 20// 0.6% + 20 руб
                commission
            } else {
                nonCommission // Просто для работы кода
            }
        }

        "Visa", "Мир" ->
            {
                val commission = transferAmount * visaCommission
                if (commission < visaMinCommission) {
                    visaMinCommission // Минимальная комиссия
            }
                else
            {
                commission
            }
        }

        "VK Pay" -> nonCommission // Комиссия не взимается
        else -> unknownCardType
    }
}
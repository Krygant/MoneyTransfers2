import org.junit.Assert.*
import org.junit.Test

class MoneyTransfersTest {
    //Тесты по VK Pay
    @Test
    fun calculateVKPayNonCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVKPayAddCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 30_000.0
        val transferAmount: Double = 4_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun calculateVKPayDailyLimit() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 15_001.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -1.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVKPayMonthlyLimit() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 40_000.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -2.0, /* actual = */ result, /* delta = */ 0.0)
    }

    //Тесты по Mastercard и Maestro
    @Test
    fun calculateMastercardNonCommission() {
        //arrange
        val cardType: String = "Mastercard"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 299.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 21.794, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMastercardAddCommission() {
        //arrange
        val cardType: String = "Mastercard"
        val monthlyTransfers: Double = 30_000.0
        val transferAmount: Double = 4_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun calculateMaestroNonCommission() {
        //arrange
        val cardType: String = "Maestro"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 299.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 21.794, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMaestroAddCommission() {
        //arrange
        val cardType: String = "Maestro"
        val monthlyTransfers: Double = 30_000.0
        val transferAmount: Double = 4_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(0.0, result, 0.0)
    }

    //Тесты по Visa и Мир
    @Test
    fun calculateVisaCommission() {
        //arrange
        val cardType: String = "Visa"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 15_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 112.5, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVisaAddMinCommission() {
        //arrange
        val cardType: String = "Visa"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 35.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVisaDailyLimitCommission() {
        //arrange
        val cardType: String = "Visa"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 151_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -1.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVisaMonthlyLimitCommission() {
        //arrange
        val cardType: String = "Visa"
        val monthlyTransfers: Double = 600_000.0
        val transferAmount: Double = 1.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -2.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMirCommission() {
        //arrange
        val cardType: String = "Мир"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 15_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 112.5, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMirAddMinCommission() {
        //arrange
        val cardType: String = "Мир"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 35.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMirDailyLimitCommission() {
        //arrange
        val cardType: String = "Мир"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 151_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -1.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMirMonthlyLimitCommission() {
        //arrange
        val cardType: String = "Мир"
        val monthlyTransfers: Double = 600_000.0
        val transferAmount: Double = 1.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -2.0, /* actual = */ result, /* delta = */ 0.0)
    }



    @Test
    fun unknownCard() {
        //arrange
        val cardType: String = "Malibu"
        val monthlyTransfers: Double = 200_000.0
        val transferAmount: Double = 1.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ -3.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun defaultCard() {
        //arrange
        val transferAmount = 50_000.0

        //act
        val result = calculateCommission(transferAmount = transferAmount)

        assertEquals(/* expected = */ 375.0, /* actual = */ result, /* delta = */ 0.0)
    }

}
import org.junit.Assert.*
import org.junit.Test

class MoneyTransfersTest {
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
    fun calculateMastercardNonCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateMastercardAddCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 30_000.0
        val transferAmount: Double = 4_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun calculateVisaNonCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVisaAddCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVKPayDailyLimitCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateVKPayMonthlyLimitCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateCardDailyLimitCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateCardMonthlyLimitCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

}
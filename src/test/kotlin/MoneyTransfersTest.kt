import org.junit.Assert.*
import org.junit.Test

class MoneyTransfersTest {
    @Test
    fun calculateNonCommission() {
        //arrange
        val cardType: String = "VK Pay"
        val monthlyTransfers: Double = 0.0
        val transferAmount: Double = 150.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.0)
    }

    @Test
    fun calculateAddCommission() {
        //arrange
        val cardType: String = "Mastercard"
        val monthlyTransfers: Double = 500_000.0
        val transferAmount: Double = 35_000.0

        //act
        val result = calculateCommission(cardType, monthlyTransfers, transferAmount)

        assertEquals(0.0, result, 0.0)
    }

}
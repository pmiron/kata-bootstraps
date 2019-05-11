import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AccountRepository {

    val transactions = mutableMapOf<String, Int>()

    fun deposit(quantity:Int, date:LocalDateTime) {
        transactions.put(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), quantity)
    }

    fun withdraw(quantity: Int,  date:LocalDateTime){
        transactions.put(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), -quantity)
    }

    fun getAllTransactions(): MutableMap<String, Int> {
        return transactions
    }

}

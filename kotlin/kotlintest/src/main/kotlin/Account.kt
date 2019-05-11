import java.time.LocalDateTime

class Account(var accountRepository: AccountRepository, var statementFormatter: StatementFormatter) {

    fun deposit(quantity:Int, date: LocalDateTime) {
        accountRepository.deposit(quantity, date)
    }

    fun withdraw(quantity: Int, date: LocalDateTime) {
        accountRepository.withdraw(quantity, date)
    }

    fun printStatement(): String {
        val allTransactions = accountRepository.getAllTransactions()
        return statementFormatter.format(allTransactions)
    }
}

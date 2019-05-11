import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.StringSpec
import java.time.LocalDateTime

class AccountStringSpec : StringSpec() { init {
    "it should print bank statement" {
        val accountRepository = AccountRepository()
        val statementFormatter = StatementFormatter()
        val account = Account(accountRepository, statementFormatter)
        val dateDeposit = LocalDateTime.now()
        account.deposit(10, dateDeposit)
        val dateWithdraw = LocalDateTime.now()
        account.withdraw(5, dateWithdraw)
        val printStatement = account.printStatement()
        printStatement shouldEqual
                "Date|Amount|Balance\n" +
                dateDeposit + "|10|10\n" +
                dateWithdraw + "|-5|5"
    }

}}

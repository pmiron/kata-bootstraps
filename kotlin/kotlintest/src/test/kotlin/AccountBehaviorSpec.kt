import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldEqual
import io.kotlintest.specs.BehaviorSpec
import java.time.LocalDateTime

class AccountBehaviorSpec : BehaviorSpec() { init {

    given("an account") {
        val accountRepository = AccountRepository()
        val statementFormatter = StatementFormatter()
        val account = Account(accountRepository, statementFormatter)
        val dateDeposit = LocalDateTime.now()
        val dateWithdraw = LocalDateTime.now()

        `when`("deposit") {
            account.deposit(100, dateDeposit)
            val printStatement = account.printStatement()

            then("account should deposit") {
                printStatement shouldEqual
                        "Date|Amount|Balance\n" +
                        dateDeposit + "|100|100"
            }
        }

        `when`("withdraw") {
            val value = account.withdraw(10, dateWithdraw)
            val printStatement = account.printStatement()

            then("account should withdraw") {
                printStatement shouldEqual
                        "Date|Amount|Balance\n" +
                        dateWithdraw + "|-10|-10"
            }
        }
    }
}}
